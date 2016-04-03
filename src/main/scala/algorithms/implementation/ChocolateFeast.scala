package algorithms.implementation

import java.util.Scanner

object ChocolateFeast {

    def main(args: Array[String]) {
        val scanner = new Scanner(System.in)
        val numberOfTests = scanner.nextInt()
        (1 to numberOfTests).foreach { _ =>
            val money = scanner.nextInt()
            val price = scanner.nextInt()
            val wrappersNeeded = scanner.nextInt()
            val chocolatesBought = money / price

            def exchangeWrappers(wrappers: Int) : Int = {
                val result = wrappers - wrappersNeeded
                if (result == 0)
                    return 1
                if (result > 0)
                    return 1 + exchangeWrappers(result + 1)
                0
            }

            println(chocolatesBought + exchangeWrappers(chocolatesBought))
        }
    }
}
