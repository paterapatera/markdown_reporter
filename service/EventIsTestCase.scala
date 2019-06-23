package paterapatera.markdown_reporter.service

import org.scalatest.events._

object EventIsTestCase {
  def apply(event: Event): Boolean = event match {
    case _: TestStarting | _: TestSucceeded | _: TestIgnored | _: TestFailed |
        _: TestPending | _: TestCanceled | _: InfoProvided | _: AlertProvided |
        _: NoteProvided | _: MarkupProvided | _: ScopeOpened | _: ScopeClosed |
        _: ScopePending | _: SuiteStarting =>
      true
    case _ => false
  }
}
