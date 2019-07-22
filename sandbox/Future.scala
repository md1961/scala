import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object FutureSample extends App {

  /*
  val s = "Hello"
  val f: Future[String] = Future {
    Thread.sleep(1000)
    s + " future!"
  }

  f.foreach { case s: String => println(s) }

  println(f.isCompleted)

  Thread.sleep(5000)

  println(f.isCompleted)
  */

  val rand = new Random()

  val milliseconds = (1 to 10).toList.map(_ => rand.nextInt(5000) + 1)
  val futures = milliseconds.zipWithIndex.map { case (ms, index) => Future {
    Thread.sleep(ms)
    println(s"#${index + 1}: finished in ${ms} ms.")
    s"#${index + 1}: finished"
  }}

  for (f <- futures) {
    f.foreach { case s: String => println(s) }
  }
}
