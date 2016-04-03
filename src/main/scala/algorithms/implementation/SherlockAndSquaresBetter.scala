package algorithms.implementation

object SherlockAndSquaresBetter {

    def main(args: Array[String]) {
        val t = readLine.toInt;
        for(i <- 1 to t) println(f(readLine.split(" ")));
    }

    def f(n:Array[String]):Long = {
        return Math.sqrt(n(1).toInt).toLong - Math.sqrt(n(0).toInt-1).toLong;
    }
}
