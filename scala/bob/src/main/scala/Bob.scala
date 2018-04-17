object Bob {

  def response(statement: String): String = {
    statement.trim match {
      case s if shoutedQuestion(s) => "Calm down, I know what I'm doing!"
      case s if shouted(s) => "Whoa, chill out!"
      case s if question(s) => "Sure."
      case s if s.isEmpty => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  private def shoutedQuestion(s: String) = {
    shouted(s) && question(s)
  }

  private def shouted(s: String) = {
    s == s.toUpperCase && containsAlphabets(s)
  }

  private def containsAlphabets(string: String) = {
    string
      .filter(_.isLetter)
      .nonEmpty
  }

  private def question(string: String): Boolean = string.endsWith("?")
}
