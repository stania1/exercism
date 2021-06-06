import scala.util.Try

object Series {
  def largestProduct(seriesLength: Int, input: String): Option[Int] = {
    if (seriesLength > input.length || seriesLength < 0 || !input.forall(Character.isDigit)) return None
    if (seriesLength == 0 || input.isEmpty) return Some(1)
    val maxStart = input.length - seriesLength

    val candidates: Seq[String] = for {
      start <- 0 to maxStart
    } yield {
      input.substring(start, start + seriesLength)
    }

    val maxProduct = candidates.map { c =>
      c.toCharArray.map(_.asDigit).product
    }.max

    Some(maxProduct)
  }
}