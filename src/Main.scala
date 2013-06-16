object Main extends App {
  override def main(args: Array[String]) {
    //testFunctions();
    testClass();
  }

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
  }

  def testClass() {
    class A(val aa: Int, val bb: Int) {
      def a = aa
      def b = bb
      def foo(x: Int):Int = {
        return x + 1;
      }
      
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
}
