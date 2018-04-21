object Etl {
  def transform(oldScores: Map[Int, Seq[String]]): Map[String, Int] = {
    oldScores
      .flatMap(score =>
        score._2.map(l => (l.toLowerCase, score._1)
        )
      )
  }

}
