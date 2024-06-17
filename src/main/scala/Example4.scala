object Example4 extends App {
  def removeNegatives(a: Array[Int]) : Array[Int] = {
    // for(e <- a if e >= 0) yield e
    a.filter(_ > 0)
  }
  val b = Array (2, -1, 3, 4, -5)
  val res = removeNegatives(b)
  res.foreach(println)
}