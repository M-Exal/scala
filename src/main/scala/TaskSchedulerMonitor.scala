import TaskSchedulerMonitor.myMonitor
import de._
import scala.collection.mutable.ArrayBuffer

case class Data (val t:() => Unit, val period: Int, var pendingTime: Int)
class Monitor {
  var task = new ArrayBuffer[Data]()
  def register (t:() => Unit, period: Int): Unit = synchronized{
    val data = Data(t, period, period)
    task += data
  }
  def updateTimes (amount: Int): Unit = synchronized {
    task.foreach(element => {
      element.pendingTime -= amount
      if (element.pendingTime <= 0){
        element.pendingTime = element.period
        var thread = new Thread() {override def run(): Unit = element.t()}
        thread.start()
      }
    })
  }
}

object TaskSchedulerMonitor extends App {
  val myMonitor = new Monitor
  val clock = new Thread {
    var elapsedSeconds: Int = 0
    override def run() = { while (elapsedSeconds < 10) { // 10 seconds
      Thread.sleep (1000)
      elapsedSeconds+= 1
      println (s"Current time :$elapsedSeconds")
      myMonitor.updateTimes(1)
    }}
  }
  def task1 = println("I’m task1 and runs every 2 s")
  myMonitor.register (() => task1, 2)
  def task2 = println("I’m task2 and runs every 3 s")
  myMonitor.register (() => task2, 3)
  Thread.sleep (12000)
  log ("End")