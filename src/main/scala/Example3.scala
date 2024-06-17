object Example3 extends App {
  def power(x: Double, n: Int): Double = {
    n match {
      case 0 => 1
      case n: Int if (n > 0) => if(n % 2 == 0) {
       power(x,n/2) * power(x,n/2)
      } else {
        x * power(x, n-1)
      }
      case n: Int if (n < 0) => 1/power(x,-n)
    }
  }
  println(" 4 to the power -1: ", power(4, -1))
  println(" 4 to the power 0: ", power(4, 0))
  println(" 4 to the power 3: ", power (4, 3))
  println(" 4 to the power 2: ", power(4, 2))
}