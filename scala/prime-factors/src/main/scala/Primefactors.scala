object PrimeFactors {

  def factors(num: Long, nextPossibleFactor: Int = 2): List[Long] = {
    if (nextPossibleFactor > num) return List()

    if (num % nextPossibleFactor == 0) {
      nextPossibleFactor :: factors(num / nextPossibleFactor, nextPossibleFactor + 1)
    } else {
      factors(num,  nextPossibleFactor + 1)
    }

  }

}