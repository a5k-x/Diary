package com.a5k.diary.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.a5k.diary.R

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), TypeCustomView {

    //размеры графа
    private val contentWidth = resources.getDimensionPixelSize(R.dimen.graph_width)
    private var contentHeight = resources.getDimensionPixelSize(R.dimen.graph_height)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val resolveWidth = resolveSize(contentWidth, widthMeasureSpec)
        val resolveHeight = resolveSize(contentHeight, heightMeasureSpec)
        setMeasuredDimension(resolveWidth, resolveHeight)
    }

    override fun onDraw(canvas: Canvas) = with(canvas) {
        drawTasks()
    }

    private fun Canvas.drawTasks() {

    }

    override fun getType() = CustomType.TASK

}