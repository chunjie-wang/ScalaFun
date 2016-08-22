<<<<<<< HEAD:src/Main.scala
package src

object TestApp {
  def main(args: Array[String]) {

    val bbb = "2.4".toFloat.toLong
    println(bbb)
    val s = Singleton.getInstance()
    val tab = Tab
/*
    testFunctions();
    testClass();
    testLoop();
    testClosures();
    testHigherOrder();

    val x = 10
    val y = x match {
      case 1 => 2
      case 3 => 4
      case _ => 5
    }
    println(y)

    def get(t : Any) = {
      t match {
        case 1 => 3
        case _ => 5
      }
    }
    println("output : " + get(1))

    val testpartial : PartialFunction[Int, String] = {
      case 3 => "xyz"
    }
    val numbers = Map("one" -> 1, "two" -> 2)
    val res = numbers.get("one2")
    println(res.getOrElse(3))
    */
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s))
    } catch {
      case e: Exception => None
    }
  }
=======
package cj.playground.features
>>>>>>> 3ffda871eaf133cadeb0c143c6b007a2985c2e8d:src/main/scala/cj/playground/features/Functions.scala

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


    // foldleft
    val list1: List[Int] = List(1, 2, 3, 4)
    val res = list1.foldLeft(0)((r, c) =>r + c)
    println("fold left result : " + res)
  }

<<<<<<< HEAD:src/Main.scala

  def testClass() {

    class A(val aa: Int, val bb: Int) {
      def a = aa
      def b = bb
      def foo(x: Int): Int = {
        return x + 1;
      }

    }

    trait AA {
      val id: Int
      val name: String
    }

    class B(aa: Int,  bb: Int,  cc: Int) extends A(aa, bb) {
      def c = cc
      override def foo(x: Int): Int = {
        return x + 2;
      }
    }

    val x = new B(1, 0, 2);
    println("Values: %d %d".format(x.a, x.b))
    println("call function foo: %d ".format(x.foo(3)))
  }
  
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
    
    // get a list of number via yield
    var ret = for {x <- l if x < 7; if x % 2 == 0} yield x
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
  
  /**
   * Test closure in Scala
   */
  def testClosures() {
    val factor = 10
    val fac = (i: Int) => i * factor
    println("factor as 10 " + fac(10))
  }
  
=======
>>>>>>> 3ffda871eaf133cadeb0c143c6b007a2985c2e8d:src/main/scala/cj/playground/features/Functions.scala
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

<<<<<<< HEAD:src/Main.scala
  val taaa = Tab("ddd")
}


case class testabc(x: String) {

}

class Tab {
  def ppp() = {}

}
object Tab {
  var y: String = "d"
  def apply(x: String): Unit = {
    y = x
  }
}

// companion obj e c t
object Singleton {
  private val instance : Singleton = new Singleton
  def getInstance () = instance
=======
  def main(args: Array[String]): Unit = {
    testFunctions()
    testHigherOrder()
  }
>>>>>>> 3ffda871eaf133cadeb0c143c6b007a2985c2e8d:src/main/scala/cj/playground/features/Functions.scala
}
class Singleton private ()
