object Isogram {

  def isIsogram(words: String): Boolean = {
    val charCount = words.toLowerCase
      .filter(_.isLetter)
      .groupBy(identity)
      .mapValues(_.length)
      .values

    !charCount.exists(_ > 1)
  }

}
