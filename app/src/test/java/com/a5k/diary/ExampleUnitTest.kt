package com.a5k.diary


import kotlinx.coroutines.yield
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.*
import java.time.LocalDateTime
import java.time.format.*
import java.util.*

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
        val t = textStringHHmm("1:40")
        val r = 0
    }

    private fun parseTimestampToString(times: Long, pattern: String): String =
        SimpleDateFormat(pattern).format(times)

    private fun textStringHHmm(text: String) : String{
        return  String.format(text, "%02d:%02d")
    }

}