import scala.annotation.tailrec

class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {
    accumulate(f, list, List())
  }

  @tailrec private def accumulate[A, B](f: (A) => B, list: List[A], accumulator: List[B]): List[B] = {
    if (list.isEmpty) accumulator
    else accumulate(f, list.tail, accumulator :+ f(list.head))
  }
}
