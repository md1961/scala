trait Additive[T] {
  def zero: T
  def plus(a: T, b: T): T
}

case class Point(x: Int, y: Int) {
  def +(p: Point): Point = {
    Point(x + p.x, y + p.y)
  }
}

object TestAdditive {

  implicit object IntAdditive extends Additive[Int] {
    def zero = 0
    def plus(a: Int, b: Int): Int = a + b
  }

  implicit object StringAdditive extends Additive[String] {
    def zero = ""
    def plus(a: String, b: String): String = a + b
  }

  implicit object PointAdditive extends Additive[Point] {
    def zero = Point(0, 0)
    def plus(a: Point, b: Point): Point = a + b
  }

  def sum[T](list: List[T])(implicit m: Additive[T]) = list.foldLeft(m.zero){(x, y) => m.plus(x, y)}

  def main0(args: Array[String]): Unit = {
    val list = (1 to 10).toList
    println("sum = " + sum(list))

    val list2 = List("Ab", "Cd", "Ef")
    println("sum = " + sum(list2))

    val list3 = List(Point(1, 2), Point(3, 5), Point(5, 8))
    println("sum = " + sum(list3))
  }
}
