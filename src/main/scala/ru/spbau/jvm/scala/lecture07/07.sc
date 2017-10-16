"Basic types:"

// Primitive types
// Type designators
// Parameterized types
// Tuple types
// Function types
// Infix types
class Op[K, V]

val op: Int Op Double = new Op[Int, Double]
val map: Int Map String = Map.empty

// Type projections
class Foo {

  class Bar

  def withBar(bar: Bar): Unit = // Bar === this.Bar
    println("bar")

  def withBarProjected(bar: Foo#Bar): Unit =
    print("bar")
}

object Foo {

  class WannabeStaticBar

}

val foo = new Foo
val bar: foo.Bar = new foo.Bar
foo.withBar(bar)

val newFoo = new Foo
val newBar: foo.Bar = new foo.Bar
//newFoo.withBar(newBar)
newFoo.withBarProjected(newBar)

// Singleton types
class Foo2 {

  val foo = "foo"

  val bar: this.foo.type = foo
}

// Annotated types

"Advanced types:"

// Structural types
// Existential types
class GenericClass[T]

val clazz: GenericClass[_ <: Int] = new GenericClass[Int]
val clazz2: GenericClass[T] forSome {type T <: Int} = new GenericClass[Int] // new GenericClass[String]

// Method types (internal type)
// Polymorphic method types (internal type)
// Type constructors (internal type)