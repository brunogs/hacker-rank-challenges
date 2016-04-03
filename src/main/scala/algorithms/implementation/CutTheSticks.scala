package algorithms.implementation

import java.util.Scanner

object CutTheSticks {

    def main(args: Array[String]) {
        val scanner = new Scanner(System.in)
        val numberOfTests = scanner.nextInt()
        val sticks = (1 to numberOfTests).map { _ =>
            scanner.nextInt()
        }
        cutSticks(sticks)
    }

    def cutSticks(sticks: Seq[Int]) : Seq[Int] = {
        if (sticks.exists( _ > 0 )) {
            val minStick = sticks.min
            val countSticksToCut = sticks.count( _ >= minStick )
            println(countSticksToCut)
            val resultSticks = sticks.map( _ - minStick).filter( _ > 0)
            cutSticks(resultSticks)
        }
        sticks
    }

}
