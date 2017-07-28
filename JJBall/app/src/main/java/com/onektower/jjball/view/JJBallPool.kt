package com.onektower.jjball.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.onektower.jjball.entity.Ball
import java.util.*

/**
 * Created by zhwilson on 2017/7/28.
 * 跳跳球活动区域，姑且就叫池子吧
 */
class JJBallPool : View {
    var balls: List<Ball> = listOf(
    )

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, def: Int) : super(context, attributeSet, def)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (balls.isEmpty())
            return
        for (ball in balls) {
            canvas?.drawCircle(ball.cx, ball.cy, ball.radius, ball.paint)
        }
    }

    fun addBalls(ballLists: List<Ball>) {
        for (ball in ballLists) {
            ball.cx = Random().nextFloat() * 720
            ball.cy = Random().nextFloat() * 1080
            ball.paint.style = Paint.Style.STROKE
            ball.paint.strokeWidth = 10f
            ball.paint.color = ball.stokeColor
        }
        balls = balls.plus(ballLists)
        postInvalidate()
    }
}