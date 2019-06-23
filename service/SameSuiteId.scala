package paterapatera.markdown_reporter.service

import org.scalatest.events._
import paterapatera.markdown_reporter.model._

object SameSuiteId {
  def apply(id: String)(testCase: TestCase): Boolean =
    testCase.event match {
      case e: TestStarting  => e.suiteId == id
      case e: TestSucceeded => e.suiteId == id
      case e: TestIgnored   => e.suiteId == id
      case e: TestFailed    => e.suiteId == id
      case e: TestPending   => e.suiteId == id
      case e: TestCanceled  => e.suiteId == id
      case e: InfoProvided  => e.nameInfo.map(_.suiteId == id) getOrElse false
      case e: AlertProvided => e.nameInfo.map(_.suiteId == id) getOrElse false
      case e: NoteProvided  => e.nameInfo.map(_.suiteId == id) getOrElse false
      case e: MarkupProvided =>
        e.nameInfo.map(_.suiteId == id) getOrElse false
      case e: ScopeOpened   => e.nameInfo.suiteId == id
      case e: ScopeClosed   => e.nameInfo.suiteId == id
      case e: ScopePending  => e.nameInfo.suiteId == id
      case e: SuiteStarting => e.suiteId == id
      case _                => false
    }
}
