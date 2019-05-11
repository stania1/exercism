

object BookStore {

  private val UNIT_PRICE = 800
  private val MIN_DISTINCT_ITEMS = 2
  private val DISCOUNTS: Map[Int, Double] = Map(
    2 -> 0.95,
    3 -> 0.9,
    4 -> 0.8,
    5 -> 0.75
  ).withDefaultValue(0)

  def total(purchases: List[Int]): Int = {

    if (purchases.distinct.length == 1) {
      // no discounts apply
      return purchases.length * UNIT_PRICE
    }

    if (purchases.length == purchases.distinct.length) {
      // there's only 1 grouping possibility
      return price(purchases.length)
    }

    val possibleCombinations = purchases.toSet
      .subsets
      .filter(_.size >= MIN_DISTINCT_ITEMS)

    possibleCombinations
      .map { combo =>

        val leftover = purchases.diff(combo.toList)

        price(combo.size) + total(leftover)

      }
      .min // get the cheapest
  }

  private def price(distinctItemCount: Int): Int = {
    val price = DISCOUNTS(distinctItemCount) * distinctItemCount * UNIT_PRICE
    price.toInt
  }

  }
