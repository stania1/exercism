object ArmstrongNumbers {

  def isArmstrongNumber(number: Int): Boolean = {

    val digits = number.toString.map(_.asDigit)

    val numDigits = digits.length

    val criteria = digits
      .map(digit => Math.pow(digit, numDigits))
      .sum
      .toInt

    number == criteria

  }


}
