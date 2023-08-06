package greet

import scala.sys.process._

case class SSHClient(keyPath: String, userName: String, host: String):
  def execute(command: String): String =
    s"ssh -T -i $keyPath $userName@$host '$command'".!!

def readEnvVariable(key: String): String = sys.env.get(key) match
  case Some(value) => value
  case None        => throw Exception("env not found")

object Hello:
  def main(args: Array[String]): Unit =
    val client = SSHClient(
      keyPath = readEnvVariable(key = "KEYPATH"),
      userName = readEnvVariable(key = "USERNAME"),
      host = readEnvVariable(key = "HOST")
    )

    val containerName = "paredent-prod"
    val command = s"sudo docker logs $containerName"

    val result = client.execute(command)

    println(result)
