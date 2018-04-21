object Pangrams {
  private val letters = "abcdefghijklmnopqrstuvwxyz"

  def isPangram(sentence: String): Boolean = {
    val normalizedSentence = sentence
      .toLowerCase
      .replaceAll("[^a-z]", "")
      .distinct
      .sorted

    normalizedSentence == letters
  }
}

