package ru.spbau.jvm.scala.lecture06

class Bar(val string: String)

object Bar {

  def action(bar: Bar): Unit = {
    println(bar)
  }
}