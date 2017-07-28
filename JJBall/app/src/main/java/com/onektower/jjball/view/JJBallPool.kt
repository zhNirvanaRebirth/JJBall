package com.onektower.jjball.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.onektower.jjball.entity.Ball
import com.onektower.jjball.entity.Constant

/**
 * Created by zhwilson on 2017/7/28.
 * 跳跳球活动区域，姑且就叫池子吧
 */
class JJBallPool : View {
    var currentBallXP: Float = Constant.RADIUS_WITH_BOUND
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
            ball.cx = location(ball.cx)
            ball.cy = location(ball.cy, false)
            canvas?.drawCircle(ball.cx, ball.cy, ball.radius, ball.paint)
            postInvalidate()
        }
    }

    fun addBalls(ballLists: List<Ball>) {
        for (ball in ballLists) {
            ball.paint.style = Paint.Style.STROKE
            ball.paint.strokeWidth = Constant.STOKE_WIDTH
            ball.paint.color = ball.stokeColor
        }
        balls = balls.plus(ballLists)
        postInvalidate()
    }

    fun location(coordinate: Float, isHorizontal: Boolean = true): Float {
        if (coordinate == 0f) {
            var xPosition: Float = Constant.RADIUS_WITH_BOUND
            if (isHorizontal) {
                xPosition = currentBallXP
                currentBallXP += Constant.RADIUS_WITH_BOUND * 2
            }
            return xPosition
        } else
            return coordinate
    }

    fun boundary(origin: Float, max: Float): Float {
        if (origin < Constant.RADIUS_WITH_BOUND)
            return Constant.RADIUS_WITH_BOUND
        if (origin + Constant.RADIUS_WITH_BOUND > max)
            return max - Constant.RADIUS_WITH_BOUND
        else
            return origin
    }
}