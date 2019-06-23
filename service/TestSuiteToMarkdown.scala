package paterapatera.markdown_reporter.service

import java.text.SimpleDateFormat
import paterapatera.markdown_reporter.model._

object TestSuiteToMarkdown {
  def apply(
      ts: TestSuite,
      failCol: String = "red",
      penCol: String = "orange"
  ): String = {
    s"# ${ts.name}\n" +
      failedPut(ts.failedCount, s"""<font color="${failCol}">実装エラー</font>""") +
      failedPut(ts.pendingCount, s"""<font color="${penCol}">未実装</font>""") +
      s"更新日： ${formatTimeStamp(ts.updated)}   \n" +
      s"物理名： ${ts.className.replaceAll("Spec", "")}   \n"
  }

  val failedPut = (cnt: Int, name: String) =>
    if (cnt > 0)
      s"${name}：${cnt}件   \n"
    else ""

  val formatTimeStamp = (timeStamp: Long) => {
    val dateFmt = new SimpleDateFormat("yyyy/MM/dd")
    val timeFmt = new SimpleDateFormat("HH:mm:ss")
    dateFmt.format(timeStamp) + " " + timeFmt.format(timeStamp)
  }
}
