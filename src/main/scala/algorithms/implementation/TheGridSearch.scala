package algorithms.implementation

import java.util.Scanner

object TheGridSearch {

    def main(args: Array[String]) {
        println("começou")
        val scanner = new Scanner(System.in)
        val tests = scanner.nextInt()
        val readMatrix = buildMatrix(scanner) _

        (1 to tests).foreach { _ =>
            val rowsBigMatrix = scanner.nextInt()
            val colsBigMatrix = scanner.nextInt()
            val bigMatrix = readMatrix(rowsBigMatrix, colsBigMatrix)

            val rowsPattern = scanner.nextInt()
            val colsPattern = scanner.nextInt()
            val patternMatrix = readMatrix(rowsPattern, colsPattern)

            if (validInputs(rowsBigMatrix, colsBigMatrix, rowsPattern, colsPattern)) {
                println(hasPattern(bigMatrix, patternMatrix, 0, 0))
            } else {
                println("NO")
            }
        }
    }

    def validInputs(rowsBigMatrix: Int, colsBigMatrix: Int, rowsPattern: Int, colsPattern: Int): Boolean = {
        rowsPattern <= rowsBigMatrix && colsPattern <= colsBigMatrix
    }

    def buildMatrix(scanner: Scanner)(rows: Int, cols: Int): Seq[Seq[Int]] = {
        scanner.nextLine()
        (1 to rows).map { row =>
            val lineValues = scanner.nextLine()
            (0 until cols).map( lineValues.charAt(_).asDigit )
        }
    }

    def hasPattern(matrix: Seq[Seq[Int]], pattern: Seq[Seq[Int]], startRow: Int, startCol: Int): String = {
        val patternMatch = pattern.indices.forall { row =>
            pattern.head.indices.forall { col =>
                pattern(row)(col) == matrix(startRow + row)(startCol + col)
            }
        }

        val greaterThanLastRow = startRow + pattern.size >= matrix.size
        val greaterThanLastCol = startCol + pattern.head.size >= matrix.head.size

        if (patternMatch) {
            "YES"
        } else {
            (greaterThanLastRow, greaterThanLastCol) match {
                case ( false, false ) => hasPattern(matrix, pattern, startRow + 1, startCol)
                case ( true, false ) => hasPattern(matrix, pattern, 0, startCol + 1)
                case ( false, true ) => hasPattern(matrix, pattern, startRow + 1, startCol)
                case ( _ ) => "NO"
            }
        }
    }
}
