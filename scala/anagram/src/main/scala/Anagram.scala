object Anagram {

  def findAnagrams(word: String, candidates: List[String]): List[String] = {
    candidates
      .filterNot(itself(_, word))
      .filter(anagram(_, word))
  }

  private def itself(candidate: String, word: String) = {
    normalized(candidate) == normalized(word)
  }

  private def anagram(candidate: String, word:String) = {
    normalized(candidate).sorted == normalized(word).sorted
  }

  private def normalized(word: String) = word.toLowerCase.toCharArray.toList

}
