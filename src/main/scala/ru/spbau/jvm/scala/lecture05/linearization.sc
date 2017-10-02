trait Foo {
  def foo: Int
}

trait Bar extends Foo {
  override def foo = 1
}

trait Baz extends Foo {
  override def foo = 2
}

class BarBaz extends Bar with Baz

val barBaz = new BarBaz
barBaz.foo

trait One {
  print(1)
}

trait Two extends One {
  print(2)
}

trait Three extends Two {
  print(3)
}

trait Four extends One {
  print(4)
}

class Five extends Four with Three with Two {
  println(5)
}

new Five