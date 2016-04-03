package algorithms.implementation

import java.util.Scanner

object SherlockAndSquares {

    def main(args: Array[String]) {
        val scanner = new Scanner(System.in)
        val numberOfTests = scanner.nextInt()
        (1 to numberOfTests).foreach { _ =>
            val startNumber = scanner.nextInt()
            val endNumber = scanner.nextInt()
            var step = 1
            var diff = 3
            var count = 0
            while (step <= endNumber) {
                if (step >= startNumber) {
                    count += 1
                }
                step += diff
                diff += 2
            }
            println(count)
        }
    }

    /*
    Solucao mais inteligente:
    Escrita em python

    import math

    T = int( input() )
    for t in range(T):
        A, B = [ int(v) for v in input().split() ]
        ar = math.ceil( math.sqrt(A) )
        br = math.floor( math.sqrt(B) )
        print( br-ar+1 )
     */
}
