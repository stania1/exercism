object CollatzConjecture {

  def steps(i: Int, accumulator: Int = 0): Option[Int] = {
    i match {
      case _ if i <= 0 => None
      case _ if i == 1 => Some(accumulator)
      case evenNumber if i % 2 == 0 => steps(evenNumber / 2, accumulator + 1)
      case oddNumber if i % 2 == 1 => steps((oddNumber * 3) + 1, accumulator + 1)
    }
  }

}
