import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

object ToDate {
  def apply(magnet: DateMagnet): magnet.Result = magnet.convert()
}

trait DateMagnet {
  type Result

  def convert(): Result
}

// DateMagnetにimplicit conversionさせる
object DateMagnet {
  implicit def fromInt(triple: (Int, Int, Int)): DateMagnet = new DateMagnet {
    override type Result = Calendar

    override def convert(): this.Result = {
      val (year, month, day) = triple
      val calendar = Calendar.getInstance()
      calendar.set(year, month - 1, day)
      calendar
    }
  }

  implicit def fromString(str: String): DateMagnet = new DateMagnet {
    override type Result = Date

    override def convert(): this.Result = new SimpleDateFormat("yyyy/mm/dd").parse(str)
  }
}
