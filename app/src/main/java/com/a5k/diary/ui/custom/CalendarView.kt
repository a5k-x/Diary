package com.a5k.diary.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.a5k.diary.R

class CalendarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), TypeCustomView {

    // Vertical line
    private var startLineVerticalY = 0f
    private val wightTextX = 100f
    val heightLineVertical = 100f

    //text
    val timeTextStartX = 10f
    var timeTextStartY = heightLineVertical / 2

    private var text = "12:30"

    // Horizontal line
    private val startLineHorizontalX = 100f
    private var startLineHorizontalY = heightLineVertical / 2
    val longHorizontal = 500f

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = context.getColor(R.color.black)
        strokeWidth = 3f
    }

    private var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = context.getColor(R.color.teal_700)
        textSize = 32f
    }

    //размеры графа
    private val contentWidth = resources.getDimensionPixelSize(R.dimen.graph_width)
    private var contentHeight = resources.getDimensionPixelSize(R.dimen.graph_height)

    private val marginTopGraph = resources.getDimensionPixelSize(R.dimen.margin_top_graph)


    fun setting(text: String) {
        this.text = text
        requestLayout()
        invalidate()
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
        val heightText = (textPaint.textSize / 3) + timeTextStartY
        //val wightTextX = textPaint.measureText(text) + 2 * timeTextStartX
        drawText(text, timeTextStartX, heightText, textPaint)
        drawLine(wightTextX, startLineVerticalY, wightTextX, heightLineVertical, linePaint)
        drawLine(wightTextX, startLineHorizontalY, longHorizontal, startLineHorizontalY, linePaint)
    }

    override fun getType() = CustomType.CALENDAR
}