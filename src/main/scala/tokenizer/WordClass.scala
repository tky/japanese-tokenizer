package tokenizer

sealed trait WordClass
case object Noun extends WordClass
case object Verb extends WordClass
case object Unknown extends WordClass

object WordClass {
  def apply(clazz: String): WordClass = clazz match {
    case "名詞" => Noun
    case "動詞" => Verb
    case _ => Unknown
  }
}
