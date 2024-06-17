object Periodically extends App {
  def periodically(duration: Long, f: => Unit): Unit = {
    val worker = new Thread {
      override def run(): Unit = {
        Thread.sleep(duration)
        f
      }
    }
    worker.setName("Worker")
    worker.start()
  }
  periodically (1000,{println("1 second has passed")})
  }