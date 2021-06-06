
object Series {
  def largestProduct(seriesLength: Int, input: String): Option[Int] = {
    if (seriesLength > input.length) return None
    if (seriesLength < 0) return None
    if (input.exists(!_.isDigit)) return None
    if (seriesLength == 0 || input.isEmpty) return Some(1)

    val candidates = input.sliding(seriesLength, 1).toSeq

    val maxProduct = candidates.map { c =>
      c.map(_.asDigit).product
    }.max

    Some(maxProduct)
  }
}