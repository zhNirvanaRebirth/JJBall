package com.onektower.jjball

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.onektower.jjball.entity.Ball
import com.onektower.jjball.view.JJBallPool


class MainActivity : AppCompatActivity() {
    var balls: List<Ball> = listOf(
            Ball(Color.RED),
            Ball(Color.GREEN),
            Ball(Color.BLUE),
            Ball(Color.MAGENTA),
            Ball(Color.LTGRAY),
            Ball(Color.DKGRAY)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var jjBallPool: JJBallPool = findViewById(R.id.jjBallPool) as JJBallPool
        jjBallPool.addBalls(balls)
    }
}
