object Example5 extends App {
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    (values.filter(_ < v).length,values.filter(_ == v).length,values.filter(_ > v).length)
  }
  val values = Array (2, -1, 3, 4, -5)
  val value = 3
  val res = lteqgt(values, value)
  println (res.toString)
}