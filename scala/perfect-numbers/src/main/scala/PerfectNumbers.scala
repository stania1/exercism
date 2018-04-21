import NumberType.NumberType

object NumberType extends Enumeration {
  type NumberType = Value
  val Perfect, Abundant, Deficient = Value
}

object PerfectNumbers {
  def classify(num: Int): Either[String, NumberType] = {
    if (num < 1) return Left("Classification is only possible for natural numbers.")

    val factors = (1 until num).filter(num % _ == 0)
    factors.sum match {
      case sum if num == sum => Right(NumberType.Perfect)
      case sum if sum > num => Right(NumberType.Abundant)
      case sum if sum < num => Right(NumberType.Deficient)
    }
  }
}



