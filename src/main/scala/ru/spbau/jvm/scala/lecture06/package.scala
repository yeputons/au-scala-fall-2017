package ru.spbau.jvm.scala

package object lecture06 {

  implicit class StructExt(val struct: Struct) extends AnyVal {

    def increase(seq: Seq[Int]): Unit = {
      seq.foreach(struct.increase)
    }
  }

  implicit def foo2Bar(foo: Foo): Bar = new Bar(foo.string)
}
