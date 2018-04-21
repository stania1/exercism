object Raindrops {
  private val raindropSpeak = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

  def convert(n: Int): String = {
    val raindrops = (1 to n)
                      .filter(n % _ == 0)
                      .filter(raindropSpeak.keySet.contains(_))

    if (raindrops.isEmpty) return n.toString

    raindrops
      .map(raindropSpeak(_))
      .mkString
  }
}

