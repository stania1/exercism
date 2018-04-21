import Bearing.Bearing

object Bearing extends Enumeration {
  type Bearing = Value
  val North, East, South, West = Value
}

case class Robot(bearing: Bearing, coordinates: (Int, Int)) {

  private def turn(func: (Int => Int)): Bearing = {
    val bearings = Bearing.values.toSeq
    bearings((func(bearing.id) + bearings.length) % bearings.length)
  }

  def turnRight: Robot = {
    Robot(turn(_ + 1), coordinates)
  }

  def turnLeft: Robot = {
    Robot(turn(_ - 1), coordinates)
  }

  def advance: Robot = {
    bearing match {
      case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
      case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
      case Bearing.East => Robot(bearing, (coordinates._1 + 1, coordinates._2))
      case Bearing.West => Robot(bearing, (coordinates._1 - 1, coordinates._2))
    }
  }

  def simulate(movements: String): Robot = {
    movements.foldLeft(this) { (robot, movement) =>
      movement match {
        case 'R' => robot.turnRight
        case 'L' => robot.turnLeft
        case 'A' => robot.advance
        case _ => robot
      }
    }
  }

}
