object Series {

  def slices(length: Int, series: String): List[List[Int]] = {
    series
      .map(_.asDigit)
      .sliding(length)
      .map(_.toList)
      .toList
  }

}
