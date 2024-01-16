package imt.bigcicd.back.bigcicdback.domain.utils

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.getZonedDate(): ZonedDateTime = ZonedDateTime.parse(this)

fun ZonedDateTime.getStringDate(): String = this.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)