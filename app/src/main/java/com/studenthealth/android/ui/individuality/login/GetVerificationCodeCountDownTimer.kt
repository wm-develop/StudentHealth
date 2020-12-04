package com.studenthealth.android.ui.individuality.login

import android.os.CountDownTimer
import android.widget.Button
import com.studenthealth.android.R
import com.studenthealth.android.StudentHealthApplication

class GetVerificationCodeCountDownTimer(button: Button, millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

    private val mButton: Button = button

    override fun onTick(millisUntilFinished: Long) {
        mButton.isEnabled = false
        mButton.text = "重新发送(${millisUntilFinished/1000})"
    }

    override fun onFinish() {
        mButton.isEnabled = true
        mButton.text = "获取验证码"
        mButton.backgroundTintList = StudentHealthApplication.context.resources.getColorStateList(R.color.ripple_color)
    }

}