object Change {
  //  findFewestCoins(25, List(1, 5, 10, 25, 100)) should be (Some(List(25)))
  // assumes coins are always sorted low -> high
  def findFewestCoins(change: Int, coins: List[Int]): Option[List[Int]] = {

    Some(findFewestCoins(change, coins, List()))
  }

  private def findFewestCoins(change: Int, coins: List[Int], usedCoins: List[Int] = List()):List[Int] = {
    val largestCoin = coins.last
    if (change == 0) return usedCoins
    if (largestCoin > change) return findFewestCoins(change, coins.dropRight(1),  usedCoins)
    // largestCoin <= change
    // 23 - 15 = 8
    // 8 - 4
    // 8 - 4
    // this won't find the fewest - to find the fewest we do need to find all possibilities then do min length.
    findFewestCoins(change - largestCoin, coins, largestCoin :: usedCoins)
  }
}