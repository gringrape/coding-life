import org.scalatest.funsuite.AnyFunSuite

import cats.effect.IO

import org.http4s.client.Client
import org.http4s.client.JavaNetClientBuilder
import org.http4s.headers.Accept
import org.http4s.Method
import org.http4s.Request
import org.http4s.MediaType
import org.http4s.Headers

import org.http4s.implicits.uri

import org.http4s.client.dsl.io.http4sClientSyntaxMethod

import cats.effect.unsafe.implicits.global
import org.http4s.headers.`Content-Type`
import org.http4s.Entity
import org.http4s.UrlForm
import org.http4s.EntityEncoder

import cats.effect._
import io.circe._
import io.circe.literal._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.circe._

class Test extends AnyFunSuite {
  test("building HTTP GET request using Request API") {
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

  test("building HTTP POST request using Request API") {
    val httpClient: Client[IO] = JavaNetClientBuilder[IO].create

    val entityEncoder = EntityEncoder.encodeBy()

    val request = Request(
      method = Method.POST,
      uri = uri"https://jsonplaceholder.typicode.com/posts",
      headers = Headers(
        `Content-Type`(MediaType.application.json)
      )
    ).withEntity(json"""{"name": "Alice"}""")

    val response = httpClient.expect[String](request).unsafeRunSync()

    assert(response.contains("\"id\":"))
  }
}
