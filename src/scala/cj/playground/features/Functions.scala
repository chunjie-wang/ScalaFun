package cj.playground.features

/**
 * Created by lovefly1983.
 */
object Functions {
  /**
   * Functions test cases
   */
  def testFunctions() {
    /**
     * Anonymous functions
     */
    val addOne = (x: Int) => x + 1
    println("addOne result %d".format(addOne(3)));

    /**
     * no paramters, just like lambda
     */
    val noParam = () => println("no parameters");
    noParam();

    /**
     * With return type specified
     */
    def timesTwo(i: Int): Int = {
      println("times Two");
      i * 2;
    }
    println("timesTwo result %d".format(timesTwo(3)));

    /**
     * Return type is inferred by complier automatically.
     */
    def sum(m: Int, n: Int) = m + n
    println("sum result %d".format(sum(3, 4)));

    /**
     * Partial application
     */
    val sum10 = sum(10, _: Int)
    println("sum10 result %d".format(sum10(4)));

    def capitalizeAll(args: String*) = {
      args.map { arg =>
        arg.capitalize
      }
    }

    capitalizeAll("abc", "cde");
    /**
     * var is mutable and val is immutable
     */
    def add(a: Int, b: Int): Int = {
      println("add...")
      var sum2: Int = 0
      sum2 = a + b;
      return sum2
    }
    println("add result: %d".format(add(10, 11)))

    def sub(a: Int, b: Int): Int = a - b;

    def whichDay(month: Int, leap: Boolean) = {
      month match {
        case 2 if leap        => 29
        case 2                => 28
        case 4 | 6 | 9 | 11   =>  30
        case _                => 31
      }

    }

    printf("Which day it is: %d \n", whichDay(2, false))
  }

  /**
   * Test higher-order functions
   */
  def testHigherOrder() {
    trait x[a] {
      def map[b](func: a=>b):x[b]
    }

    val ans = (1 to 10) map (x => x * 2)
    val ans2 = (1 to 10) map (_*2)
    println(ans)

    def apply(f: Int => String, v: Int) = f(v)
    def layout[A](x: A) = "[" + x.toString() + "]"
    println(apply(layout, 10))

    // Define filter and take predicate
    val even = (x: Int) => x % 2 == 0
    val odd = (x: Int) => x % 2 == 1
    def filter(predicate: Int=>Boolean, arr: List[Int]) = {
      for (x <- arr; if predicate(x)) yield x
    }

    val arr = List[Int](1, 3, 4)
    val res = filter(even, arr)
    println(res)
  }

  def main(args: Array[String]): Unit = {
    testFunctions()
    testHigherOrder()
  }
}
