package ru.spbau.jvm.scala.lecture06

class Struct {

  import Struct._

  private var i: Int = 0

  privateStaticWannabe()
  //  innerWannabe()

  def increase(i: Int): Unit = {
    this.i += i
  }
}

object Struct {

  private def privateStaticWannabe(): Unit = {
    innerWannabe()
  }

  private[this] def innerWannabe(): Unit = {
  }

  //    def increase(struct: Struct, seq: Alias): Unit = {
  //      seq.foreach(struct.increase)
  //    }
}

