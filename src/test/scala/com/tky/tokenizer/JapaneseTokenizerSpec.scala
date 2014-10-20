package com.tky.tokenizer

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

    it("should analyze document") {
      val tokens = JapaneseTokenizer.analyze("家に帰る")
      tokens.size should be(3)
      tokens(0).value should be("家")
      tokens(0).kana should be("イエ")
      tokens(0).wordClass should be(Noun)

      tokens(2).value should be("帰る")
      tokens(2).wordClass should be(Verb)
    }
  }
}
