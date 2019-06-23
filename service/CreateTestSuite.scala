package patera.markdown_reporter.service

import org.scalatest.events._
import scala.collection.mutable.Set
import patera.markdown_reporter.model._

object CreateTestSuite {
  def apply(
      event: Event,
      testCases: Set[TestCase]
  ): Option[TestSuite] =
    event match {
      case e: SuiteCompleted =>
        Some(
          TestSuite(
            name = e.suiteName,
            className = e.suiteClassName getOrElse "不明",
            updated = e.timeStamp,
            testCases = testCases
              .filter(SameSuiteId(e.suiteId))
              .toList
              .sortBy(_.event.ordinal)
          )
        )
      case e: SuiteAborted =>
        Some(
          TestSuite(
            name = e.suiteName,
            className = e.suiteClassName getOrElse "不明",
            updated = e.timeStamp,
            testCases = testCases
              .filter(SameSuiteId(e.suiteId))
              .toList
              .sortBy(_.event.ordinal)
          )
        )
      case _ => None
    }
}
