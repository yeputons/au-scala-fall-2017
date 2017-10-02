trait Text {
  val text: String
  val length: Int = text.length
}

class TextImpl extends {
  val text: String = "text"
} with Text

val text = new TextImpl
text.text