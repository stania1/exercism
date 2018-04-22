import scala.util.Random

private object RobotName {
  private var cache: Set[String] = Set.empty

  def generate: String = {
    val candidate = (alphabetStream.take(2).toList ::: numericStream.take(3).toList).mkString
    if (cache.contains(candidate)) {
      generate
    } else {
      cache += candidate
      candidate
    }
  }

  private def alphabetStream: Stream[Char] = Random.alphanumeric.filter(_.isLetter).map(_.toUpper)

  private def numericStream: Stream[Char] = Random.alphanumeric.filter(_.isDigit)
}

class Robot {

  var name: String = RobotName.generate

  def reset(): Unit = {
    this.name = RobotName.generate
  }

}

