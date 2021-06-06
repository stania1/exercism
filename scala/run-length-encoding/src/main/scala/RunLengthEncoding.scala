import scala.annotation.tailrec

object RunLengthEncoding {

  def encode(input: String): String = {
    val seq: Seq[Char] = input.toCharArray.toSeq
    val runLength = encode(seq, List())
    format(runLength)
  }

  private def format(runLength: List[(Char, Int)]): String = {
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

  private def dropRight(l: List[(Char, Int)]): List[(Char, Int)] = {
    l.reverse.tail.reverse
  }

  def decode(input: String): String = {
    decode(input.toCharArray.toSeq, "")
  }

  @tailrec
  private def decode(input: Seq[Char], acc: String, interimCount: String = ""): String = {
    if (input.isEmpty) return acc

    input.head match {
      // not the most readable..
      case char if !input.head.isDigit => decode(input.tail, acc + char)
      case count if input.head.isDigit && !input.tail.head.isDigit => {
        val finalCountForChar = (interimCount + count).toInt
        val char = input.tail.head
        decode(input.tail.tail, acc + (char.toString * finalCountForChar), "")
      }
      case count if input.head.isDigit && input.tail.head.isDigit =>
        decode(input.tail, acc, interimCount + count)
    }
  }

}
