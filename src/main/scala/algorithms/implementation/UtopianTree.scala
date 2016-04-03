package algorithms.implementation

import scala.io.StdIn


object UtopianTree {

    def main(args: Array[String]) {
        val numberOfTests = StdIn.readInt()

        (1 to numberOfTests).foreach { _ =>
            val cycles = StdIn.readInt()
            val treeHeight = (1 to cycles).foldLeft(1) {
                (height, cycle) => calculateHeightPerCycle(height, cycle)
            }
            println(treeHeight)
        }
    }

    def calculateHeightPerCycle(cycle: Int, height: Int) = {
        if ((cycle % 2) == 0) height + 1 else height * 2
    }
}
