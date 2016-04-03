package algorithms.implementation

import scala.io.StdIn

object FindDigits {

    def main(args: Array[String]) {
        val numberOfTests = StdIn.readInt()
        (1 to numberOfTests).foreach { _ =>
            val number = StdIn.readLine()
            val countOfDivisibleDigits = number.map(_.asDigit)
                .count(divisibleByDigit(_, number.toLong))
            println(countOfDivisibleDigits)
        }
    }

    def divisibleByDigit(digit: Int, number: Long) = {
        (digit > 0) && (number.toLong % digit == 0)
    }
}
