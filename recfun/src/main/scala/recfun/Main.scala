package recfun

import scala.collection.mutable.ListBuffer
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if ((c == 0) || (r == 0) || (c == r)) 1
  else (pascal(c-1,r-1) + pascal(c,r-1));

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def f(chars: List[Char], numOpens: Int): Boolean = {
      if (chars.isEmpty) {
        numOpens == 0
      } else {
        val h = chars.head
        val n =
          if (h == '(') numOpens + 1
          else if (h == ')') numOpens - 1
          else numOpens
        if (n >= 0) f(chars.tail, n)
        else false
      }
    }

    f(chars, 0)
  }
  

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = (money, coins.sortWith(_>_)) match {
  case (0, _) => 1
  case (money, _) if money < 0 => 0
  case (_, Nil) => 0
  case (money, head::tail) => countChange(money-head, coins) + countChange(money, tail)
}
}

