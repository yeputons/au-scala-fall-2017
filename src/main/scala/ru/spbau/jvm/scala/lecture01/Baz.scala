package ru.spbau.jvm.scala.lecture01

class Baz extends Foo

object Baz extends FooCompanion[Baz] {
  override def apply() = new Baz
}
