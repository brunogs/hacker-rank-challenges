package algorithms.implementation

import java.util.Scanner

object CavityMap {

    def main(args: Array[String]) {
        val scanner = new Scanner(System.in)
        val readMatrix = buildMatrix(scanner) _
        val dimension = scanner.nextInt()
        val matrix = readMatrix(dimension, dimension)

        matrix.indices.foreach { row =>
            matrix.head.indices.foreach { col =>
                (row, col) match {
                    case ( x, y ) if isOnBorder(x, y, dimension - 1) => print(matrix(row)(col))
                    case ( x, y ) if isCavity(x, y, matrix) => print('X')
                    case ( _ ) => print(matrix(row)(col))
                }
            }
            println()
        }
    }

    def buildMatrix(scanner: Scanner)(rows: Int, cols: Int): Seq[Seq[Char]] = {
        scanner.nextLine()
        (0 until rows).map { row =>
            val lineValues = scanner.nextLine()
            (0 until cols).map( lineValues.charAt )
        }
    }

    def isOnBorder(row: Int, col: Int, max: Int): Boolean = {
        (row == 0 || col == 0) || (row == max || col == max)
    }

    def isCavity(row: Int, col: Int, matrix: Seq[Seq[Char]]) = {
        val cell = matrix(row)(col).toInt
        val upperCell = matrix(row - 1)(col).toInt
        val bottomCell = matrix(row + 1)(col).toInt
        val leftCell = matrix(row)(col - 1).toInt
        val rightCell = matrix(row )(col + 1).toInt
        List(upperCell, bottomCell, leftCell, rightCell).forall( cell > _ )
    }

}
