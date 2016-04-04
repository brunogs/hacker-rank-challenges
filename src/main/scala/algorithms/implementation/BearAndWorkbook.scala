package algorithms.implementation

import java.util.Scanner

object BearAndWorkbook {

    case class Page(chapter:Int, problems:Seq[Int])

    def buildPages(maxOfProblems: Int)(chapter: Int, problems: Int): Seq[Page] = {
        ( 1 to problems ).by( maxOfProblems )
            .map { p =>
                problems - p match {
                    case result if result >= maxOfProblems => Page(chapter, p until (p + maxOfProblems))
                    case result => Page(chapter, p to problems)
                }
            }
    }

    def main(args: Array[String]) {
        val scanner = new Scanner(System.in)
        val chapters = scanner.nextInt()
        val createPages = buildPages(scanner.nextInt()) _
        val pages = ( 1 to chapters ).flatMap(createPages( _ , scanner.nextInt()))
        val specialProblems = pages.zipWithIndex.count {
            case ( page, index ) => page.problems.contains(index + 1)
        }
        println(specialProblems)
    }
}
