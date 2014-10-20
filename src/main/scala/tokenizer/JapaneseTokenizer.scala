package tokenizer

import org.apache.commons.lang3._
import org.atilika.kuromoji._
import org.atilika.kuromoji.Tokenizer.Builder
import collection.JavaConversions._

object JapaneseTokenizer {

  lazy val tokenizer: Tokenizer = Tokenizer.builder.build
  def toKatakana(document: String): String = {
    tokenizer.tokenize(document).map {
      token: Token => convert(token).kana
    }.mkString
  }

  private def convert(token: Token): Element = {
    Element(token.getSurfaceForm, ObjectUtils.firstNonNull(token.getReading, token.getSurfaceForm), WordClass(token.getAllFeatures().split(",").head))
  }

  def analyze(document: String): List[Element] = {
    tokenizer.tokenize(document).map {
      token: Token => convert(token)
    } toList
  }

}
