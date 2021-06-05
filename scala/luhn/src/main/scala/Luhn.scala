import scala.util.Try

object Luhn {

  def valid(number: String): Boolean = {
    val sanitized = number.replace(" ", "")

    if (sanitized.length <= 1) return false

    if (Try {
      sanitized.toInt
    }.isFailure) return false

    val ints = sanitized
      .reverse
      .toSeq
      .map {
        _.toString.toInt
      }

    val luhnSum = ints
      .zipWithIndex
      .map { case (digit, idx) =>
        if (idx + 1 >= 2 && (idx + 1) % 2 == 0) {
          digit * 2
        } else {
          digit
        }
      }
      .map { num => if (num >= 9) num - 9 else num }
      .sum


    luhnSum % 10 == 0
  }


}