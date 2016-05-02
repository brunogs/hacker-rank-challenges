package algorithms.implementation

import java.util.Scanner


object CeasarCipher1 {

    def main(args: Array[String]) {
        val scanner = new Scanner (System.in)
        val characters = scanner.nextInt()
        scanner.nextLine()
        val line = scanner.nextLine()
        val numberOfRotate = scanner.nextInt()

        println(line.map(rotateChar(numberOfRotate, _))
                .map(_.toChar)
                .mkString(""))
    }

    def rotateChar(numberOfRotate: Int, character: Char): Int = {
        val min = if (character.isLower) 'a' else 'A'
        if (!character.isLetter)
            character
        else
            min + (character - min + numberOfRotate) % 26
    }
}
