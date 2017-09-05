package ru.spbau.jvm.scala.lecture01

import java.util

class Bar(name: String = "") extends Foo {

  val list = new util.ArrayList[Int]()

  override def foo() = 1

  private def definition(): Int = 0

  // var value = 5 // syntactic sugar
  private[this] var value$ = value$init

  def value: Int = value$

  def value_=(v: Int): Unit = {
    value$ = v
    return ()
  }

  def value$init: Int = 5

  override def equals(obj: scala.Any) = {
    if (obj.isInstanceOf[Bar]) {
      val bar = obj.asInstanceOf[Bar]
      bar.definition()
      //      bar.value$ // compilation error
    }
    super.equals(obj)
  }
}

object Bar extends FooCompanion[Bar] {
  override def apply() = new Bar()
}
