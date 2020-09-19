import java.util.{Calendar, Date}

object Main extends App {
  val date1 = ToDate(2020, 1, 1).asInstanceOf[Calendar].getTime
  val date2 = ToDate("2020/01/01").asInstanceOf[Date]

  dateAssert("year", date1.getYear, date2.getYear)
  dateAssert("month", date1.getMonth, date2.getMonth)
  dateAssert("day", date1.getDay, date2.getDay)

  def dateAssert(tag: String, v1: Int, v2: Int): Unit = {
    val message = s"'${tag}' assert failed: ${v1}, ${v2}"
    assert(v1 == v2, message)
  }
}
