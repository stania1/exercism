object Hamming {
  def distance(s1: String, s2: String): Option[Int] = {
    if (s1.length != s2.length) {
      None
    } else {
      Some(s1.zip(s2)
        .count(p => p._1 != p._2))
    }
  }
}
