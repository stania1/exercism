import java.time.{LocalDate, LocalDateTime}

object Gigasecond {
  def add(startDate: LocalDate): LocalDateTime = add(startDate.atStartOfDay

  def add(startDateTime: LocalDateTime): LocalDateTime = startDateTime.plusSeconds(1000000000)
}
