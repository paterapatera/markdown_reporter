package paterapatera.markdown_reporter

import org.scalatest._
import org.scalatest.events._
import scala.collection.mutable.Set
import paterapatera.markdown_reporter.service._
import paterapatera.markdown_reporter.model._

object Data {
  val directory: String = "./design_doc"
}
class MarkdownReporter extends Reporter {
  val testCases = Set.empty[TestCase]

  def apply(event: Event) {
    if (EventIsTestCase(event)) testCases += TestCase(event)
    val tso = CreateTestSuite(event, testCases)
    tso foreach { ts =>
      Output(
        Data.directory + "/" + ts.name + ".md",
        TestSuiteToMarkdown(ts) + TestCasesToMarkdown(ts)
      )
    }
  }
}
