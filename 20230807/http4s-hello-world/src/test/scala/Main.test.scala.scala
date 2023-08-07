import org.scalatest.funsuite.AnyFunSuite

import cats.effect._
import cats.syntax.all._
import org.http4s._, org.http4s.dsl.io._, org.http4s.implicits._

import cats.effect.unsafe.IORuntime
implicit val runtime: IORuntime = cats.effect.unsafe.IORuntime.global

class SetSuite extends AnyFunSuite:
  val service = HttpRoutes.of[IO] { case _ => IO(Response(Status.Ok)) }

  test("simple http client") {
    val getRoot = Request[IO](Method.GET, uri"/")
    val serviceIO = service.orNotFound.run(getRoot)

    val response = serviceIO.unsafeRunSync()

    assert(response.status == Status.Ok)
  }
