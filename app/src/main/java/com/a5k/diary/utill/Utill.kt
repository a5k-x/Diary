package com.a5k.diary.utill

import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object Utill{

    const val PATTERN_HH_MM = "HH:mm"

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
}

