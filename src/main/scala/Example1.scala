import de._
import scala.collection._
class ProducerConsumerMonitorWithoutLimit [T] {
  private val buffer = mutable.Queue[T]()
  def append (v: T): Unit = synchronized {
    buffer.enqueue(v)
    notify()
  }
  def take (): T = synchronized {
    while(buffer.isEmpty) wait()
    buffer.dequeue()
  }
}
object Example1 extends App {
  var b = new ProducerConsumerMonitorWithoutLimit [Int]
  val producer1 = thread {for (i<-1 to 15) b.append (i)}
  val producer2 = thread {for (i<-16 to 30) b.append (i)}
  val consumer1 = thread {for (i<-1 to 30) println (b.take())}
  producer1.join(); producer2.join(); consumer1.join()
  log ("End")
}