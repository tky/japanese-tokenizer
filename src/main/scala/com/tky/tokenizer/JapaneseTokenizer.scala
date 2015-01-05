package com.tky.tokenizer

import org.apache.commons.lang3._
import org.atilika.kuromoji._
import org.atilika.kuromoji.Tokenizer.Builder
import collection.JavaConversions._
import com.ibm.icu.text._

object JapaneseTokenizer {

  lazy val tokenizer: Tokenizer = Tokenizer.builder.build
  lazy val kataToHira = Transliterator.getInstance("Katakana-Hiragana");
  lazy val hiraToLatin = Transliterator.getInstance("Hiragana-Latin");
  def tokenize(document: String): List[Element] = {
    tokenizer.tokenize(document).map {
      token: Token => convert(token)
    } toList
  }

  def toKatakana(document: String): String = {
    tokenize(document) map { _.kana } mkString
  }

  def toHiragana(document: String): String = {
    document.split("ー").map { doc =>
      kataToHira.transliterate(toKatakana(doc))
    }.mkString("ー")
  }

  def toLatin(document: String): String = {
    return hiraToLatin.transliterate(toHiragana(document))
  }

  private def convert(token: Token): Element = {
    Element(token.getSurfaceForm, ObjectUtils.firstNonNull(token.getReading, token.getSurfaceForm), WordClass(token.getAllFeatures().split(",").head))
  }
}
