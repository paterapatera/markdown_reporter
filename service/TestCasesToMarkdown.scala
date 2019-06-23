package patera.markdown_reporter.service

import patera.markdown_reporter.model._

object TestCasesToMarkdown {
  def apply(
      ts: TestSuite,
      penCol: String = "orange",
      failCol: String = "red"
  ): String = {
    (for (tc <- ts.testCases.tail) yield {
      val testcaseName = (color: String) =>
        "    " * tc.indent + s"""- <font color="${color}">■</font>""" +
          tc.name.replaceAll("should", "") + "\n"

      if (tc.isSucceeded) testcaseName("lightcyan")
      else if (tc.isFailed)
        testcaseName(failCol) + "    " * tc.indent +
          s"""  - <font color="${failCol}">エラー内容： ${tc.failedMessge}</font>""" + "\n"
      else if (tc.isPending)
        testcaseName(penCol) + s"""<font color="${penCol}">(未実装)</font>""" + "\n"
      else if (tc.isEmpty) ""
      else
        "    " * tc.indent + "- " + tc.name
          .replaceAll("should", "") + "\n"
    }).foldLeft("")((rs, v) => rs + v)
  }
}
