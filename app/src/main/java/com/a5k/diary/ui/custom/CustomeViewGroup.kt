package com.a5k.diary.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_MOVE
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class CustomeViewGroup @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var maxHeight = 0

    private var positionScroll = 0
    private var maxDeltaScroll = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
       super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val countChild = childCount
        maxHeight = 0

        var maxWidth = 0
        var childState = 0

        for (i in 0 until countChild ) {
            val child = getChildAt(i)
            if ((child as TypeCustomView).getType() == CustomType.CALENDAR){
                maxWidth += child.width
                maxHeight += (child as CalendarView).heightLineVertical.toInt()
                childState = combineMeasuredStates(childState, child.measuredState)
            }
        }
        val resolveWidth = resolveSize(maxWidth, widthMeasureSpec)
        val resolveHeight = resolveSize(maxHeight, heightMeasureSpec)

        setMeasuredDimension(resolveWidth, maxHeight)
        maxDeltaScroll = maxHeight - resolveHeight
    }

    var ldf = 0
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        val count = childCount
        for (i in 1..count) {
            val child = getChildAt(i - 1)
            if ((child as TypeCustomView).getType() == CustomType.CALENDAR){
                child.id = i
                child.setOnClickListener {
                    Log.d("CLICK", "CLICK FROM VIEWGROUP id = ${child.id}")
                }
                ldf += (child as CalendarView).heightLineVertical.toInt()
                child.layout(l, ldf, r, b)
            } else if ((child as TypeCustomView).getType() == CustomType.TASK){
                child.id = i
                child.layout(l, t, r, b)
            }
        }
    }

    override fun dispatchTouchEvent(e: MotionEvent?): Boolean {
        if (e != null && e.action == ACTION_MOVE && e.pointerCount == 1) {
            if (positionScroll >= 0) {
                val historySize = e.historySize
                if (historySize > 0) {
                    val y = e.y
                    val index = e.actionIndex
                    val oldY = e.getHistoricalY(index)
                    val delta = (oldY - y).toInt()
                    positionScroll += delta
                    if (positionScroll in 0..maxDeltaScroll) {
                        scrollTo(0, positionScroll)
                    } else {
                        positionScroll -= delta
                    }
                }
            }
        }
        return super.dispatchTouchEvent(e)
    }

}

