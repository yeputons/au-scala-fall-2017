package ru.spbau.jvm.scala.lecture04.solution

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks
import ru.spbau.jvm.scala.lecture04.solution.mutable.Multiset

class MultisetTest extends FlatSpec with Matchers with TableDrivenPropertyChecks {
  val seqs = Table(
    "seq",
    Seq(),
    Seq(1),
    Seq(1, 2, 3, 4, 10),
    Seq(1, 1, 1),
    Seq(1, 1, 2, 2, 2, 3),
    Seq(1, 2, 2, 2, 3, 3),
    Seq(1, 1, 2, 3),
  )

  "mutable.Multiset" should "convert from/to Seq" in {
    forAll (seqs) { source =>
        Multiset[Int](source).toSeq.sorted shouldBe source
    }
  }

  it should "be create with apply" in {
    Multiset[Int](1, 1, 1, 4, 5, 6).toSeq.sorted shouldBe Seq(1, 1, 1, 4, 5, 6)
  }

  it should "work with filter" in {
    forAll (seqs) { source =>
      val multiset = Multiset[Int](source)
      multiset.filter(_ >= 1).toSeq.sorted shouldBe source.filter(_ >= 1)
    }
  }

  it should "work with map" in {
    forAll (seqs) { source =>
      val multiset = Multiset[Int](source)
      multiset.map(_ * 2).toSeq.sorted shouldBe source.map(_ * 2)
    }
  }

  it should "work with map" in {
    forAll (seqs) { source =>
      val multiset = Multiset[Int](source)
      multiset.map(_ * 2).toSeq.sorted shouldBe source.map(_ * 2)
    }
  }
}
