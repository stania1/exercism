object Hamming {
  def distance(str: String, str1: String): Option[Int] = {
    if (str.length == str1.length) {
      Some(_distance(str, str1))
    } else {
      None
    }
  }

  private def _distance(str: String, str1: String): Int = {
    str.toCharArray
      .zip(str1.toCharArray)
      .foldLeft(0) { (acc, curr) =>
        if (curr._1 == curr._2) {
          acc
        } else {
          acc + 1
        }
      }
  }
}
