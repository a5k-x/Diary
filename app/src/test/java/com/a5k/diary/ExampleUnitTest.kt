package com.a5k.diary

import org.junit.Assert.assertEquals
import org.junit.Test
import java.sql.Time
import java.sql.Timestamp
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.logging.SimpleFormatter


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun date(){
      val date = Instant.now().epochSecond
        //val dater = Instant.ofEpochSecond(date).
      val time = parseTimestampToString(date, "HH:mm")
        val ter = parseTimeToMilli(time, "HH:mm")
        val result = parseToCoordinate(ter, 2400)
        var r = 0
    }

    @Test
    fun date2(){
        val hours = 23
        var h = 1
        var jh = String.format("%02d:00", hours)
        var jk = String.format("%02d:00", h)
        var hj = 456
    }

    private fun parseTimestampToString(times: Long, pattern: String): String =
        SimpleDateFormat(pattern).format(times)

    private fun parseTimeToMilli(times: String, pattern: String): Int {
        val time = LocalTime.parse(times, DateTimeFormatter.ofPattern(pattern))
        return ((time.hour * 3600) + (time.minute * 60))
    }

    private fun parseToCoordinate(time: Int, heightView: Int): Int
    = (heightView * time) / 86_400


}