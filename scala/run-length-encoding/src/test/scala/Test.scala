import org.scalatest.{Matchers, FunSuite}

// start 9:38 am
class WIPTest extends FunSuite with Matchers {

  test("bla") {
    val seq: Seq[Char] = "AAABBBBB".toCharArray.toSeq
    println(RunLengthEncoding.encode(seq, List()))
  }
}