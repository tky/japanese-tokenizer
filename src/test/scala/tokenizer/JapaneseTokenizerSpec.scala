package tokenizer

import org.scalatest.{ FunSpec, Matchers }

import org.scalatest.matchers._

class JapaneseTokenizerSpec extends FunSpec with Matchers {
  describe("JapaneseTokenizer") {
    it("should translat hiragana to katakana") {
      JapaneseTokenizer.toKatakana("あ") should be("ア")
      JapaneseTokenizer.toKatakana("愛") should be("アイ")
    }

    it("should translat hiragana which contains katakana to katakana") {
      JapaneseTokenizer.toKatakana("アイ愛あい") should be("アイアイアイ")
    }
  }
}
