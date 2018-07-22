package puzzle

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun getDifference(begin: String, end: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val first = LocalDate.parse(begin, formatter)
    val second = LocalDate.parse(end, formatter)

    val years = ChronoUnit.YEARS.between(first, second)
    val months = ChronoUnit.MONTHS.between(first.plusYears(years), second)
    val days = ChronoUnit.DAYS.between(first, second)

    val toStr = { v: Long, key: String ->
        if (v > 0) "$v $key${if (v > 1) "s" else ""}, " else ""
    }
    return "${toStr(years, "year")}${toStr(months, "month")}total $days days"
}