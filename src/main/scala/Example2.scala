object Example2 extends App {
  def obtainSum(args: Int *) : Int = {
    var sum : Int = 0
    for (num <- args) {
      sum += num
    }
    sum
  }
  println ("Sum obtained " + obtainSum(1,2,3,4,5,6))
}