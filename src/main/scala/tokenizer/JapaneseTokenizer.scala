package tokenizer
import org.apache.commons.lang3._
import org.atilika.kuromoji._
import org.atilika.kuromoji.Tokenizer.Builder
import collection.JavaConversions._

object JapaneseTokenizer {

  lazy val tokenizer: Tokenizer = Tokenizer.builder.build
  def toKatakana(word: String): String = {
    tokenizer.tokenize(word).map {
      token: Token => ObjectUtils.firstNonNull(token.getReading, token.getSurfaceForm)
    }.mkString
  }
}
