package com.packt.chapter1

import akka.actor.ActorSystem

object HelloAkkaActorSystem extends App {
  val actorSystem = ActorSystem("HelloAkka")
  println(actorSystem)
}
