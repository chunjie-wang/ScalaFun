package cj.playground.features



object ImplicitTest {



  def main(args: Array[String]): Unit = {
    implicitConversion
    immplicitArgument

  }

  /**
   * Test implicit arguments lookup
   */
  def immplicitArgument = {
    abstract class SemiGroup[A] {
      def add(x: A, y: A): A
    }
    abstract class Monoid[A] extends SemiGroup[A] {
      def unit: A
    }

    implicit object StringMonoid extends Monoid[String] {
      def add(x: String, y: String): String = x concat y
      def unit: String = ""
    }

    implicit object IntMonoid extends Monoid[Int] {
      def add(x: Int, y: Int): Int = x + y
      def unit: Int = 0
    }

    def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
      if (xs.isEmpty) m.unit
      else m.add(xs.head, sum(xs.tail))

    println(sum(List(1, 2, 3)))
    println(sum(List("a", "b", "c")))

    //
    def maxListImpParm[T](elements: List[T])
                         (implicit orderer: T => Ordered[T]): T =

    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(orderer)
        if (orderer(x) > maxRest) x
        else maxRest
    }

    println(maxListImpParm(List(1,5,10,3)))
  }
  /**
   * Implicit conversion from type A to type B
   */
  def implicitConversion = {
    // 1. In same scope
    class KoanIntWrapper(val original: Int) {
      def isOdd = original % 2 != 0
    }

    implicit def thisMethodNameIsIrrelevant(value: Int) = new KoanIntWrapper(value)

    println(1.isOdd)
    println(2.isOdd)

    // 2. Different scope
    // import it since we can not access thisMethodNameIsIrrelevant2 directly.
    import TestPref._
    println(3.isEven)

    // 3. Implicit conversion to an expected type
    implicit def doubleToInt(x: Double) = x.toInt
    val x: Int = 13.5
    println(x)

  }
}

object TestPref {
  class KoanIntWrapper2(val original: Int) {
    def isEven = original % 2 == 0
  }

  implicit def thisMethodNameIsIrrelevant2(value: Int): KoanIntWrapper2 = new KoanIntWrapper2(value)
}