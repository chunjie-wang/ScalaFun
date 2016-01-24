package cj.playground.features

/**
 * Created by lovefly1983.
 */
class ClosureTest {
  /**
   * Test closure in Scala
   */
  def testClosures() {
    val factor = 10
    val fac = (i: Int) => i * factor
    println("factor as 10 " + fac(10))
  }


}

object ClosureTest {
  val t = new ClosureTest

  def main(args: Array[String]): Unit = {
    t.testClosures()
  }
}