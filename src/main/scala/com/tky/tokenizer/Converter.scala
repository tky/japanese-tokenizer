package com.tky.tokenizer

import java.io._

object Converter {

  def fromFile(file: File): Converter = new Converter(file)
}

class Converter(file: File) {
  def using[A <% { def close():Unit }](s: A)(f: A=>Any) {
    try f(s) finally s.close()
  }
  def toLatin(dest: File) = {
    using(new PrintWriter(dest)) { writer =>
      scala.io.Source.fromFile(file).getLines.foreach { line =>
        writer.println(JapaneseTokenizer.toLatin(line))
      }
    }
  }
}
