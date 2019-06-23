package patera.markdown_reporter.service

import java.io.File;
import java.io.PrintWriter

object Output {
  def apply(filespec: String, text: String) {
    val dir = (new File(filespec)).getParentFile();

    if (!dir.exists) dir.mkdirs

    val out = new PrintWriter(filespec, "UTF-8")
    out.print(text)
    out.close()
  }
}
