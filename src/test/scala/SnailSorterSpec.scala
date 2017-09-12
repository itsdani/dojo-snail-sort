import org.scalatest.{Matchers, WordSpec}

class SnailSorterSpec extends WordSpec with Matchers {
  "SnailSorter" when {
    val input = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )

    "asked for rotation" should {
      "return input rotated anti-clockwise" in {
        val result = SnailSorter.rotate(input)
        result should equal(List(List(3, 6, 9), List(2, 5, 8), List(1, 4, 7)))
      }
    }

    "asked to perform a step" should {
      "return the first line and the rest rotated" in {
        val result = SnailSorter.sortStep(input)
        result should equal(List(1, 2, 3),
                            List(List(6, 9), List(5, 8), List(4, 7)))
      }
    }

    "asked to perform snail" should {
      "return snail-sorted list" in {
        val result = SnailSorter.snail(input)
        result should equal(List(1, 2, 3, 6, 9, 8, 7, 4, 5))
      }
    }

    "asked to perform snail for an empty matrix" should {
      "return an empty list" in {
        val result = SnailSorter.snail(List(List()))
        result should equal(List())
      }
    }

    "ran on an array of characters" should {
      "sort the array" in {
        val charInput = List(List('a', 'b'), List('c', 'd'))
        val result = SnailSorter.snail(charInput)

        result should equal(List('a', 'b', 'd', 'c'))
      }
    }
  }
}
