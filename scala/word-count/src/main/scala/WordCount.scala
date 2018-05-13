

case class WordCount(phrase: String) {
  private val separator = "'?[^a-z0-9\\']'?"

  def countWords: Map[String, Int] = {
    phrase.toLowerCase
      .split(separator)
      .filter(_.nonEmpty)
      .groupBy(identity)
      .mapValues(_.size)
  }
}
