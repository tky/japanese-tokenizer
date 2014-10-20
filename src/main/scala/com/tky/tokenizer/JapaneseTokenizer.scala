package com.tky.tokenizer

import org.apache.commons.lang3._
import org.atilika.kuromoji._
import org.atilika.kuromoji.Tokenizer.Builder
import collection.JavaConversions._

object JapaneseTokenizer {

  lazy val tokenizer: Tokenizer = Tokenizer.builder.build
  def tokenize(document: String): List[Element] = {
    tokenizer.tokenize(document).map {
      token: Token => convert(token)
    } toList
  }

  def toKatakana(document: String): String = {
    tokenize(document) map { _.kana } mkString
  }

  private def convert(token: Token): Element = {
    Element(token.getSurfaceForm, ObjectUtils.firstNonNull(token.getReading, token.getSurfaceForm), WordClass(token.getAllFeatures().split(",").head))
  }
}
