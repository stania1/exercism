object SecretHandshake {
  private val reference = Map(
    "1" -> "wink",
    "10" -> "double blink",
    "100" -> "close your eyes",
    "1000" -> "jump")

  def commands(code: Int, key: String = "1", secretHandshake: List[String] = List()): List[String] = {
    if (code == 0) return secretHandshake
    if (key == "10000") return secretHandshake.reverse

    code % 2 match {
      case 1 => commands(code >> 1, key + "0", secretHandshake :+ reference(key))
      case 0 => commands(code >> 1, key + "0", secretHandshake)
    }
  }

}
