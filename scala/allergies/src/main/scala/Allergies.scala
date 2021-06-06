import Allergen.Allergen

import scala.util.Try

object Allergen extends Enumeration {
  type Allergen = Value
  val Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats = Value
}

object Allergies {

  def allergicTo(allergen: Allergen, score: Int): Boolean = {

    val allergenScore = Math.pow(2, allergen.id).toInt
    //    if (score <= Math.pow(2, Allergen.maxId)) return true
    if (allergenScore <= score) return true
    //    if (score > Math.pow(2, Allergen.maxId) && allergen == Allergen.Eggs) return true
    false
  }

  def list(score: Int): List[Allergen] = {

    def list(score: Int, potentialAllergens: List[Allergen]): List[Allergen] = {
      if (score == 0 || potentialAllergens.isEmpty) return List()
      if (isAllergenScore(score) && !hasAssociatedAllergen(score)) return List()

      val highestDefinedAllergenScore = (Math.log10(score) / Math.log10(2)).floor.toInt
      if (Try {
        scoreToAllergens(highestDefinedAllergenScore)
      }.isSuccess) {
        val allergen = scoreToAllergens(highestDefinedAllergenScore)
        val allergenScore = Math.pow(2, allergen.id).toInt

        list(score - allergenScore, potentialAllergens.tail) ++ List(allergen)
      } else {

      }


      //      val potentialAllergen = closestDefinedAllergen(score)
      //      val potentialAllergenScore = Math.pow(2, potentialAllergen.id).toInt

      //      if (score >= potentialAllergenScore) {
      //
      //      } else {
      //
      //      }
    }

    val potentialAllergens = Allergen.values.toList

    list(score, potentialAllergens)
  }

  private val EPSILON = 0.00001

  private val scoreToAllergens: Map[Int, Allergen] = Allergen.values.zipWithIndex.map { case (v, k) => (k, v) }.toMap

  private def closestDefinedAllergen(score: Int): Allergen = {
    val closestDefinedAllergenScore = (Math.log10(score) / Math.log10(2)).floor.toInt
    scoreToAllergens(closestDefinedAllergenScore)
  }

  private def isAllergenScore(score: Int) = {
    val dividedByLog10Of2 = Math.log10(score) / Math.log10(2)
    (dividedByLog10Of2 - dividedByLog10Of2.floor) <= EPSILON
  }

  private def hasAssociatedAllergen(score: Int): Boolean = {
    (Math.log10(score) / Math.log10(2)).toInt <= (Allergen.maxId - 1)
  }
}