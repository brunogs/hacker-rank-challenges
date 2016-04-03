package algorithms.string

import scala.io.StdIn

object Pangrans {

    def main(args: Array[String]) {
        val sentence = StdIn.readLine.toLowerCase()
        val isPangram = "abcdefghijklmnopqrstuvwxyz".forall(c => sentence.contains(c) )

        if (isPangram)
            println("pangram")
        else
            println("not pangram")
    }

}
