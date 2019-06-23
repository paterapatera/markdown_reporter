package paterapatera.markdown_reporter.model

case class TestSuite(
    name: String,
    className: String,
    updated: Long,
    testCases: List[TestCase]
) {
  val failedCount = testCases.count(_.isFailed)
  val pendingCount = testCases.count(_.isPending)
}
