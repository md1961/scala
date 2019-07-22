import org.scalatest._
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._

class CalcSpec extends FlatSpec with DiagrammedAssertions with Timeouts {

  val calc = new Calc

  ".sum()" should "receive Seq[Int] and return sum" in {
    assert(calc.sum(Seq(1, 2, 3)) === 6)
    assert(calc.sum(Seq(0)) === 0)
    assert(calc.sum(Seq(-1, 1)) === 0)
    assert(calc.sum(Seq()) === 0)
  }

  it should "overflow when sum exceed Integer.MAX_VALUE" in {
    assert(calc.sum(Seq(Integer.MAX_VALUE, 1)) === Integer.MIN_VALUE)
  }

  ".div()" should "receive two integers and return former devided by latter in double" in {
    assert(calc.div(6, 3) === 2.0)
    assert(calc.div(1, 3) === 0.3333333333333333)
  }

  it should "throw ArithmeticException when denominator is zero" in {
    intercept[ArithmeticException] {
      calc.div(1, 0)
    }
  }

  ".isPrime()" should "return boolean whether value is prime number or not" in {
    assert(calc.isPrime(-1) == false)
    assert(calc.isPrime(0) == false)
    for (n <- Seq(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30))
      assert(calc.isPrime(n) == false)
    for (n <- Seq(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
      assert(calc.isPrime(n))
  }

  it should "finish within one second" in {
    failAfter(1000 millis) {
      assert(calc.isPrime(9999991))
    }
  }
}
