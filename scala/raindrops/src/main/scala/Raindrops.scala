object Raindrops {
  private val raindropSpeak = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int): String = {
    val raindrops = raindropSpeak
                      .keys
                      .filter(n % _ == 0)

    if (raindrops.isEmpty) return n.toString

    raindrops
      .map(raindropSpeak(_))
      .mkString
  }
}

