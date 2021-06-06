object PythagoreanTriplet {

  private def isPythagoreanABC(a: Int, b: Int, c: Int): Boolean = {
    scala.math.pow(a, 2).toInt + scala.math.pow(b, 2).toInt == scala.math.pow(c, 2).toInt
  }

  def isPythagorean(tripletTuple: (Int, Int, Int)): Boolean = {
    val triplet = List(tripletTuple._1, tripletTuple._2, tripletTuple._3)
    val permutations: Iterator[List[Int]] = triplet.permutations
    permutations.exists(perm => isPythagoreanABC(perm(0), perm(1), perm(2)))
  }

  def pythagoreanTriplets(from: Int, to: Int): Seq[(Int, Int, Int)] = {
    for {
      a <- from to to
      b <- from to to
      c <- from to to
      if isPythagorean((a, b, c)) && a < b && b < c
    } yield (a, b, c)

  }

}
