package paterapatera.markdown_reporter.model

import org.scalatest.events._

case class TestCase(event: Event) {
  val name = event.formatter match {
    case Some(IndentedText(_, rawText, _)) => rawText
    case _                                 => ""
  }
  val indent = event.formatter match {
    case Some(IndentedText(_, _, indentationLevel)) => indentationLevel
    case _                                          => 0
  }
  val isEmpty = name == ""
  val isPending = event match {
    case _: TestPending | _: TestIgnored | _: TestCanceled => true
    case _                                                 => false
  }
  val isFailed = event.isInstanceOf[TestFailed]
  val isSucceeded = event.isInstanceOf[TestSucceeded]
  val failedMessge = event match {
    case e: TestFailed => e.message
    case _             => ""
  }
}
