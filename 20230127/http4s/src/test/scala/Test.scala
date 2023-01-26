import org.scalatest.funsuite.AnyFunSuite

import cats.effect.IO

import org.http4s.client.Client
import org.http4s.client.JavaNetClientBuilder
import org.http4s.syntax.all.uri
import org.http4s.headers.Accept
import org.http4s.Method
import org.http4s.Request
import org.http4s.MediaType
import org.http4s.Headers

import cats.effect.unsafe.implicits.global

class Test extends AnyFunSuite:
  test("httpClient") {
    val httpClient: Client[IO] = JavaNetClientBuilder[IO].create

    val request = Request(
      method = Method.GET,
      uri = uri"https://jsonplaceholder.typicode.com/posts/2",
      headers = Headers(
        Accept(MediaType.application.json)
      )
    )

    val response = httpClient.expect[String](request).unsafeRunSync()

    assert(response.contains("\"userId\":"))
  }
