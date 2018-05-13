

object BracketPush {
  private val bracketPairs = Map('{' -> '}', '[' -> ']', '(' -> ')').withDefaultValue("")

  private def isBracket(char: Char) = bracketPairs.exists(i => i._1 == char || i._2 == char)

  def isPaired(str: String) = {
    str.foldLeft(List.empty[Char]) { (acc, curr) =>
      if (acc.nonEmpty && bracketPairs(acc.last) == curr) acc.slice(0, acc.size - 1)
      else if (isBracket(curr)) acc :+ curr
      else acc
    }.isEmpty
  }
}
