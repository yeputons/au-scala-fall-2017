trait Text {
  lazy val text: String = null
  val length: Int = text.length
}

class TextImpl extends Text {
  override lazy val text = "text"
}

val text = new TextImpl
text.length