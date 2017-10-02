class Foo {
  def foo() = 1
}

trait Bar {
  def bar() = 2
}

val foo: Foo with Bar {
  def baz(): Int
} = new Foo with Bar {
  def baz(): Int = 3
}

foo.foo()
foo.bar()
foo.baz()

