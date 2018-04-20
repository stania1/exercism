object FlattenArray {

  def flatten(list: List[Any]): List[Any] = {
    list.foldLeft(List[Any]()) { (acc, curr) =>
      curr match {
        case l: List[_] => acc ::: flatten(l)
        case i: Any => acc :+ i
        case _ => acc
      }
    }
  }

}
