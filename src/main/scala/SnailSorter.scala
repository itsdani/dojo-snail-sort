object SnailSorter {

  def rotate[T](input: List[List[T]]) : List[List[T]] = {
    input.transpose.reverse
  }

  def sortStep[T](input: List[List[T]]) : (List[T], List[List[T]]) = {
    (input.head, rotate(input.tail))
  }
  
  def snail[T](input: List[List[T]]) : List[T] = {
    snailRecursive(List(), input)
  }
  
  private def snailRecursive[T](aggregator : List[T], input: List[List[T]]) : List[T] = input match {
    case List() => aggregator
    case rest: List[List[T]] => snailRecursive(aggregator ++ rest.head, rotate(rest.tail))
  }


}
