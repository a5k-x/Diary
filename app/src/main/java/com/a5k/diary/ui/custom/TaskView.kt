package com.a5k.diary.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.a5k.diary.R
import com.a5k.diary.domain.entity.Task
import com.a5k.diary.utill.Utill
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), TypeCustomView {

    //размеры графа
    private val contentWidth = resources.getDimensionPixelSize(R.dimen.graph_width)
    private var contentHeight = resources.getDimensionPixelSize(R.dimen.graph_height)

    private val rectPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = context.getColor(R.color.purple_700)
        strokeWidth = 3f
    }

    private var task: Task? = null
    private var heightCalendar: Int = 2400
    fun settingViewTask(task: Task, height: Int) {
        this.task = task
        this.heightCalendar = height
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val resolveWidth = resolveSize(contentWidth, widthMeasureSpec)
        val resolveHeight = resolveSize(contentHeight, heightMeasureSpec)
        setMeasuredDimension(resolveWidth, resolveHeight)
    }

    override fun onDraw(canvas: Canvas) = with(canvas) {
        drawTasks()
    }

    private fun Canvas.drawTasks() {
        if (task != null){
            val startYCoordinateTask = Utill.getCoordinate(task!!.date_start, pattern = Utill.PATTERN_HH_MM, heightCalendar)
            val endYCoordinateTask = Utill.getCoordinate(task!!.date_finish, pattern = Utill.PATTERN_HH_MM, heightCalendar)
            val rect = RectF(10f, startYCoordinateTask.toFloat(), 300f, endYCoordinateTask.toFloat())
            drawRect(rect, rectPaint)
        }
    }

    override fun getType() = CustomType.TASK

}

