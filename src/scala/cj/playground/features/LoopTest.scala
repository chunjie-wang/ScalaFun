package cj.playground.features

/**
 * Created by lovefly1983.
 */
object LoopTest {
  /**
   * Test loop: While, For etc.
   */
  def testLoop() {
    var a = 0
    var b = 0
    // for
    for (a <- 1 to 3; b <- a to 3) {
      println("a & b: " + a +" " + b)
    }

    val l = List(1, 2, 5, 7)
    // for with filters
    for(x <- l if x < 5; if x % 2 == 0)
      println("x in list: " + x);

    val ret = for {x <- l if x < 7; if x % 2 == 0} yield x
    println(ret)

    // while
    while (a < 3) {
      println("a = " + a);
      a += 1
    }

    // Array
    val arr = new Array[Int](5)
    for (i <- 0 to (arr.length - 1))
      arr(i) = i
    for (x <- arr) println("x = " + x + " ");

    val twoD = Array.ofDim[Int](2,3)


  }

  def main(args: Array[String]): Unit = {
    testLoop()
  }
}
