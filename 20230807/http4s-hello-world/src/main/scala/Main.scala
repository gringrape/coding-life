import cats.effect._, org.http4s._, org.http4s.dsl.io._

import org.http4s.server.Router
import org.http4s.ember.server._
import org.http4s.implicits._

import cats.syntax.all._
import com.comcast.ip4s._
import scala.concurrent.duration._

val helloWorldService = HttpRoutes.of[IO] { case GET -> Root / "hello" =>
  Ok("Hello World!!!!!!!!")
}

object Main extends IOApp:
  def run(args: List[String]): IO[ExitCode] =
    val httpApp = Router("/" -> helloWorldService).orNotFound

    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"9100")
      .withHttpApp(httpApp)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
