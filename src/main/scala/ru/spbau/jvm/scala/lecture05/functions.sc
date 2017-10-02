val function: Function1[Int, Int] = 42 + (_: Int)

def function1(n: Int) = 42 + n

def function2(n: Int)
             (k: Int): Int = 0
// Int => Int => Int
val intToInt: Int => Int = function2(5)

function2(5)(3)

def function3(n: Int, k: Int): Int = 0
val function4: (Int, Int) => Int = function3

val intToInt1: Int => Int = function3(_, 42)

function2(_)(_)

val maybe: Option[(Int, String)] =
  Some(1, "")

val maybeInts: Option[(Int, Int)] =
  Some(0, 1)

maybeInts.map {
  case (n, k) => function4(n, k)
}

maybeInts.map { pair =>
  val (left, right) = pair
  function4(left, right)
}

val function5: Int => Int = 42 + _
Option(1).map(function1)
Option(2).map(function5)
