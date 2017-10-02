import java.io.{BufferedReader, FileReader}

def withClose(closeable: AutoCloseable)
             (action: => Unit): Unit = {
  try {
    action
  } finally {
    closeable.close()
  }
}

val reader = new BufferedReader(new FileReader(""))
withClose(reader) {

}