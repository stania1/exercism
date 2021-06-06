//import RunLengthEncoding.dropRight

//def encode(input: Seq[Char], acc: List[(Char, Int)]): List[(Char, Int)] = {
//  if (input.isEmpty) return List()
//
//  acc.last match {
//    case (char, count) if input.head == char => {
//      encode(input.tail, dropRight(acc) ++ List((char, count + 1)))
//    }
//    case (char, _) if input.head != char => {
//      encode(input.tail, acc ++ List((char, 1)))
//    }
//  }
//}
//

val seq: Seq[Char] = "AAABBBBB".toCharArray.toSeq
RunLengthEncoding.encodeInternal(seq, List())