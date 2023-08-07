import cats.effect._, org.http4s._, org.http4s.dsl.io._

import org.http4s.server.Router
import org.http4s.ember.server._
import org.http4s.implicits._

import cats.syntax.all._
import com.comcast.ip4s._
import scala.concurrent.duration._

import org.http4s.circe.CirceEntityEncoder._
import org.http4s.circe._

import io.circe._
import io.circe.syntax._
import io.circe.literal._
import io.circe.generic.auto._

case class Task(id: Int, title: String)

implicit val taskDecoder: EntityDecoder[IO, Task] = jsonOf[IO, Task]
implicit val taskEncoder: Encoder[Task] =
  Encoder.instance { (task: Task) =>
    json"""{"id":${task.id}, "title": ${task.title}}"""
  }

val helloWorldService = HttpRoutes.of[IO] {
  case GET -> Root / "hello" => Ok("Hello World!")
  case GET -> Root / "tasks" => Ok(listTasks())
  case GET -> Root / "tasks" / IntVar(taskId) =>
    findTask(taskId) match {
      case Some(v) => Ok(v)
      case None    => NotFound()
    }
  case request @ POST -> Root / "tasks" => {
    for {
      task <- request.as[Task]
      response <- Created()
    } yield {
      createTask(task)
      response
    }
  }
  case request @ PATCH -> Root / "tasks" / IntVar(taskId) => {
    for {
      task <- request.as[Task]
      response <- NoContent()
    } yield {
      updateTask(taskId, task)
      response
    }
  }
  case DELETE -> Root / "tasks" / IntVar(taskId) => {
    deleteTask(taskId)
    NoContent()
  }
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
