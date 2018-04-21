import scala.annotation.tailrec

object Strain {
  @tailrec def keep[A](list: Seq[A], func: (A) => (Boolean), accumulator: Seq[A] = List.empty[A]): Seq[A] = {
    if (list.isEmpty) return accumulator

    if (func(list.head)) {
      keep(list.tail, func, accumulator :+ list.head)
    } else {
      keep(list.tail, func, accumulator)
    }
  }

  def discard[A](list: Seq[A], func: (A) => (Boolean), accumulator: Seq[A] = List.empty[A]): Seq[A] = {
    val invertedFunc: (A) => (Boolean) = !func(_)
    keep(list, invertedFunc)
  }
}