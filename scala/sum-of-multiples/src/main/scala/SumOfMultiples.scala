object SumOfMultiples {

  private def isMultipleOf(number: Int, factors: Set[Int]): Boolean = {
    factors
      .map(number % _ == 0)
      .exists(_ == true) // a multiple of at least one of factors
  }

  def sum(factors: Set[Int], limit: Int): Int = {
    (1 until limit)
      .toStream
      .filter(num => isMultipleOf(num, factors))
      .sum
  }

}

