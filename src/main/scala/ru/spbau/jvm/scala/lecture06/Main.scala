package ru.spbau.jvm.scala.lecture06

import scala.collection.{JavaConverters, mutable}

//import java.util.{List => JList}
import java.{util => ju}

object Main {

  type IntSequence = Seq[Int]

  def main(args: Array[String]): Unit = {
    val struct = new Struct
    struct.increase(1)

    //    Struct.increase(struct, Seq(1, 2, 3))
    //    import Struct.increase
    //    increase(struct, Seq())

    //    new StructExt(struct).increase(Seq(1, 2, 3))

    val ints: IntSequence = Seq(1, 2, 3)
    struct.increase(ints)

    val struct1 = new Struct
    new StructExt(struct1).increase(ints)

    val str = ints.mkString("[", ", ", "]")
    println(str)

    val builder = mkString1(ints)
    println(builder)

    Bar.action(new Foo("string"))

    new GenericType[Int]
    new AbstractMemberType {
      override type K = Int
    }
  }

  def list2List(buffer: mutable.ListBuffer[Int]): ju.List[Int] = {
    import JavaConverters._
    buffer.asJava
  }

  private def mkString1[A](seq: Seq[A]): String = {
    val builder = new StringBuffer()
    for (e <- seq) {
      builder.append(e)
      builder.append(" ")
    }
    builder.toString
  }

  class GenericType[K <: AnyVal]

  class AbstractMemberType {
    type K <: AnyVal
  }

}
