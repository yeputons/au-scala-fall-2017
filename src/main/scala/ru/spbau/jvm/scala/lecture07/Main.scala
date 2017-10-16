package ru.spbau.jvm.scala.lecture07

import ru.spbau.jvm.scala.lecture07.model.{Editor, Module, Project, SyntaxTree}

object Main {

  def main(args: Array[String]): Unit = {
    import Context.{editor, project}

    implicit val module: Module = new Module(project)
    doSomething(new SyntaxTree {
      override val project: Project = project
    })

    val action: (Editor, Module) => Unit = doSomething(null)(_, _)
  }

  private def doSomething(tree: SyntaxTree)
                         (implicit editor: Editor, module: Module): Unit = {
    val Seq(first, second, third, fourth, _) = tree.children

    //    implicit val module = new Module(editor.project)

    doSomething2(first, second)
    doSomething2(third, fourth)
  }

  private def doSomething2(first: SyntaxTree, second: SyntaxTree)
                          (implicit editor: Editor, module: Module): Unit = {

  }
}

object Context {
  val project = new Project
  implicit val editor: Editor = new Editor(project)
  implicit val module: Module = new Module(project)
}
