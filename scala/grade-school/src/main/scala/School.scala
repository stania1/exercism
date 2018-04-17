

class School {

  type DB = Map[Int, Seq[String]]
  private var schoolRoster: DB = Map()

  def add(name: String, g: Int) = {
    val newGradeRoster: Seq[String] = grade(g).toList ::: List(name)
    schoolRoster += (g -> newGradeRoster)
  }

  def db: DB = schoolRoster

  def grade(g: Int): Seq[String] = {
    schoolRoster.getOrElse(g, Seq.empty)
  }

  def sorted: DB = {
    val sortedRoster = schoolRoster
      .mapValues(_.sorted)
      .toSeq
      .sortWith(_._1 < _._1)

    Map(sortedRoster:_*)
  }
}


