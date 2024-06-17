case class Point(x:Int,y:Int){
  def +(newpt:Point)=Point(x+newpt.x,y+newpt.y)
  def -(newpt:Point)=Point(x-newpt.x,y-newpt.y)
  override def toString="Point("+x+","+y+")"
}
object PPoint {
  def main(args: Array[String]) {
    val p1=Point(3,4)
    val p2=Point(7,2)
    val p3=Point(-2,2)
    val p4=p1+p2-p3
    println(p4)
  }
}