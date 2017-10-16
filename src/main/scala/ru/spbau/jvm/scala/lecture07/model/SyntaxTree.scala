package ru.spbau.jvm.scala.lecture07.model

trait SyntaxTree {
  val project: Project

  val children: Seq[SyntaxTree] = Seq.empty
}
