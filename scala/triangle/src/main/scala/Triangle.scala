case class Triangle(sides: Double*) {

  private def distinctSides: Set[Double] = sides.toSet

  private def isLegal = !sides.contains(0.0) && sides.sortWith(_ > _).tail.sum >= sides.max

  def equilateral: Boolean = isLegal && distinctSides.size == 1

  def isosceles: Boolean = isLegal && distinctSides.size <= 2

  def scalene: Boolean = isLegal && distinctSides.size == 3
}
