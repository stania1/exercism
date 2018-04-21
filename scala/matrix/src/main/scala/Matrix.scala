case class Matrix(s: String) {

  private val rows: Vector[Vector[Int]] = s.lines
    .toVector
    .map(line => line.split(" ")
      .map(_.toInt)
      .toVector)

  def row(index: Int) = rows(index)

  def column(index: Int) = rows.map(_(index))
}
