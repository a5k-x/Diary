package com.a5k.diary.utill

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

object Utill{

    const val TIME_PATTERN = "HH:mm"
    const val DATE_PATTERN = "dd.MM.yyyy"
    const val TIME_FORMAT = "%02d:%02d"

    fun parseTimestampToString(times: Long, pattern: String): String =
        SimpleDateFormat(pattern).format(times)

    fun parseTimeToSec(times: String, pattern: String): Int {
        val time = LocalTime.parse(times, DateTimeFormatter.ofPattern(pattern))
        return ((time.hour * 3600) + (time.minute * 60))
    }

    fun parseToCoordinate(time: Int, heightView: Int): Int
            = (heightView * time) / 86_400

    fun getCoordinate(times: Long, pattern: String, heightView: Int ): Int{
        val time = parseTimestampToString(times, pattern)
        val sec = parseTimeToSec(time, pattern)
        return parseToCoordinate(sec, heightView)
    }

    fun getTime(hours: Int, minutes: Int): String = String.format(TIME_FORMAT, hours, minutes)

    fun parseTimeAndDateToTimestamp(time: String, date: String, patternTime: String, patternDate: String): Long {
        val times = LocalTime.parse(time, DateTimeFormatter.ofPattern(patternTime))
        val dates = LocalDate.parse(date, DateTimeFormatter.ofPattern(patternDate))
        return times.toEpochSecond(dates, OffsetDateTime.now().offset)
    }
}

