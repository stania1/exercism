import scala.annotation.tailrec

object BinarySearch {

  def find(numbers: List[Int], toFind: Int): Option[Int] = {
    binarySearch(numbers, toFind, 0)
  }

  @tailrec private def binarySearch(numbers: List[Int], toFind: Int, startIndex: Int): Option[Int] = {

    if (numbers.size <= 1) {
      return numbers.lastOption match {
        case Some(last) if last == toFind => Some(startIndex)
        case _ => None
      }
    }

    val midpoint = numbers.size / 2
    lazy val left = numbers.slice(0, midpoint)
    lazy val right = numbers.slice(midpoint, numbers.size)

    if (left.last >= toFind) binarySearch(left, toFind, startIndex)
    else binarySearch(right, toFind, startIndex + midpoint)

  }

}
