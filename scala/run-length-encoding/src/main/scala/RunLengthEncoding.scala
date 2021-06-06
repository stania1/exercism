import scala.annotation.tailrec

object RunLengthEncoding {

  def encode(input: String): String = {
    val seq: Seq[Char] = input.toCharArray.toSeq
    val runLength = encode(seq, List())
    format(runLength)
  }

  def format(runLength: List[(Char, Int)]): String = {
    runLength.foldLeft("") { (acc, head) =>
      head match {
        case (char, count) if count != 1 => s"${acc}${count}${char}"
        case (char, count) if count == 1 => s"${acc}${char}"
        case _ => acc
      }
    }
  }

  def encode(input: Seq[Char], acc: List[(Char, Int)]): List[(Char, Int)] = {
    if (input.isEmpty) return acc

    input.foldLeft(acc) { (acc, head) =>
      if (acc.isEmpty) {
        List((head, 1))
      } else {
        acc.last match {
          case (char, count) if head == char => dropRight(acc) ++ List((char, count + 1))
          case (char, _) if head != char => acc ++ List((head, 1))
        }
      }
    }
  }

  def dropRight(l: List[(Char, Int)]): List[(Char, Int)] = {
    l.reverse.tail.reverse
  }

}
