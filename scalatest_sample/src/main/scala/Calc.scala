class Calc {

  def sum(seq: Seq[Int]): Int = seq.foldLeft(0){_ + _}

  def div(numerator: Int, denominator: Int): Double = {
    if (denominator == 0)
      throw new ArithmeticException("Division by zero")
    numerator.toDouble / denominator
  }

  def isPrime(n: Int): Boolean = {
    if (n < 2) false else !((2 to Math.sqrt(n).toInt) exists (n % _ == 0))
  }
}
