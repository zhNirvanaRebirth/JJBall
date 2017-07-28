package com.onektower.jjball.entity

import android.graphics.Paint

/**
 * Created by zhwilson on 2017/7/28.
 * 跳跳球的相关属性
 */

/**
 * radius:半径
 * cx,cy:圆中心坐标
 * stokeColor:圆边框颜色
 * paint:画笔
 */
data class Ball(var stokeColor: Int, var radius: Float = 60f, var cx: Float = 0f, var cy: Float = 0f, var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)) {
}

