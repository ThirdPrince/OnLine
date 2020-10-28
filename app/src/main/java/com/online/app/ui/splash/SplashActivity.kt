package com.online.app.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.online.app.R
import com.online.app.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * 应用入口
 * @author dhl
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var animatorSet: AnimatorSet

    private val  splashTime:Long = 1800//ms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startAnimation()
        Handler().postDelayed({
            MainActivity.actionStart(this)
            finish()
        }, splashTime)
    }

    /**
     * 放大的动画
     */
    private fun startAnimation(){
        animatorSet = AnimatorSet()
        animatorSet.playTogether(
            ObjectAnimator.ofFloat(splash_img, "alpha", 0.88f, 1f),
            ObjectAnimator.ofFloat(splash_img, "scaleX", 1f, 1.12f),
            ObjectAnimator.ofFloat(splash_img, "scaleY", 1f, 1.12f)
        )
        animatorSet.duration = splashTime
        animatorSet.start()
    }
}