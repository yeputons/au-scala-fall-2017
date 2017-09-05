package ru.spbau.jvm.scala.lecture01

trait Foo {
  def foo(): Int = 0
}

trait FooCompanion[F <: Foo] {

  def apply(): Foo

  def apply(foo: Foo): Foo = foo
}
