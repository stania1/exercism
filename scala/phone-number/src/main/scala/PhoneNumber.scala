object PhoneNumber {

  // not using regex on purpose, as an exercise, at the expense of verbosity

  private val validNs: Seq[Char] = '2' to '9'
  private val validXs: Seq[Char] = '0' to '9'
  private val validChars: Map[Int, Seq[Char]] = Map(0 -> validNs, 3 -> validNs).withDefaultValue(validXs)
  private val validLength = 10

  def clean(phoneNumber: String): Option[String] = {
    sanitizeLength( sanitizeNumbers(phoneNumber) )
  }

  private def sanitizeNumbers(phoneNumber: String): String = {
    phoneNumber.foldLeft("") { (acc, curr) =>
      if (isValidChar(acc, curr)) acc + curr else acc
    }
  }

  private def isValidChar(acc: String, curr: Char) = {
    validChars(acc.length).contains(curr)
  }

  private def sanitizeLength(phoneNumber: String): Option[String] = {
    if (phoneNumber.length != validLength) return None

    Some(phoneNumber.mkString)
  }

}
