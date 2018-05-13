object Sieve {

  private val lowestPrime = 2

  def primes(limit: Int): List[Int] = {
    val candidates = (lowestPrime to limit).toList

    candidates.foldLeft(candidates) { (acc, curr) =>
      acc.filterNot(i => i != curr && i % curr == 0)
    }
  }

}
