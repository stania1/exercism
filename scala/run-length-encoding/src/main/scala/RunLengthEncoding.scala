import scala.annotation.tailrec

object RunLengthEncoding {

  def encode(input: String): String = {
    val seq: Seq[Char] = input.toCharArray.toSeq
    val runLength = encodeInternal(seq, List())
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

  def encodeInternal(input: Seq[Char], acc: List[(Char, Int)]): List[(Char, Int)] = {
    if (input.isEmpty) return acc
    if (acc.isEmpty) return encodeInternal(input.tail, List((input.head, 1)))

    acc.last match {
      case (char, count) if input.head == char => {
        encodeInternal(input.tail, dropRight(acc) ++ List((char, count + 1)))
      }
      case (char, _) if input.head != char => {
        encodeInternal(input.tail, acc ++ List((input.head, 1)))
      }
    }
  }

  def dropRight(l: List[(Char, Int)]): List[(Char, Int)] = {
    l.reverse.tail.reverse
  }

}
