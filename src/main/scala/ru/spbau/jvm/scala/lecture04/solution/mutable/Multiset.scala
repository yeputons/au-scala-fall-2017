package ru.spbau.jvm.scala.lecture04.solution.mutable

import scala.collection.mutable

class Multiset[A] extends ru.spbau.jvm.scala.lecture04.solution.Multiset[A] {
  private val data = mutable.Map[A, Int]()

  class MultisetIterator(var mapIterator: Iterator[(A, Int)]) extends Iterator[A] {
    var currentVal: Option[A] = None
    var remaining: Int = 0

    override def hasNext: Boolean = remaining > 0 || mapIterator.hasNext

    override def next(): A = {
      if (remaining == 0) {
        val (v, total) = mapIterator.next()
        currentVal = Some(v)
        remaining = total
      }
      remaining -= 1
      currentVal.get
    }
  }

  override def iterator = new MultisetIterator(data.iterator)

  def +=(x: A): Multiset[A] = {
    data.update(x, data.getOrElse(x, 0) + 1)
    this
  }

  def -=(x : A): Multiset[A] = {
    val newCount: Int = data.getOrElse(x, 0) - 1
    if (newCount > 0) {
      data.update(x, newCount)
    } else {
      data.remove(x)
    }
    this
  }
}

object Multiset {
  def apply[A](xs: A*): Multiset[A] = {
    apply(xs)
  }
  def apply[A](xs : Traversable[A]): Multiset[A] = {
    val res = new Multiset[A]
    xs foreach { x => res += x }
    res
  }
}
