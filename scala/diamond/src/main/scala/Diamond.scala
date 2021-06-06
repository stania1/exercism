import scala.collection.immutable

object Diamond {
  def rows(input: Char): List[String] = {
    if (input == 'A') return List("A")

    val topRows = ('A' to input).map {
      (rowLetter: Char) => {

        val numSpaceSide = (input - rowLetter)
        val numSpaceMid = (rowLetter - 'A') * 2 - 1
        if (rowLetter == 'A') {
          (" " * numSpaceSide) + rowLetter + (" " * numSpaceSide)
        } else {
          (" " * numSpaceSide) + rowLetter + (" " * numSpaceMid) + rowLetter + (" " * numSpaceSide)
        }

      }
    }

    val allRows = topRows ++ topRows.reverse.tail

    allRows.toList
  }
}