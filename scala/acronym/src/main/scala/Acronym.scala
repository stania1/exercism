object Acronym {
  def abbreviate(phrase: String): String = {
    phrase.replace("[^A-Za-z']", " ")
      .replace("-", " ")
      .split( " ")
      .filter(_.nonEmpty)
      .map { (word) => word.charAt(0).toUpper

      }.mkString
  }
}
