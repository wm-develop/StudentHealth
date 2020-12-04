package com.studenthealth.android.ui.individuality.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_find_password_get_verification_code.*

class FindPasswordGetVerificationCodeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_find_password_get_verification_code, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getVerificationCodeMaterialButton.setOnClickListener {
            Toast.makeText(activity, "验证码已发送到您的手机上，请注意查收", Toast.LENGTH_SHORT).show()
            //开始60秒计时，将按钮text改为重新获取(xx)，并设置为不可点击
            getVerificationCodeMaterialButton.backgroundTintList = resources.getColorStateList(R.color.text_hint)
            val mCountDownTimer = GetVerificationCodeCountDownTimer(getVerificationCodeMaterialButton, 6000, 1000)
            mCountDownTimer.start()
        }
        getVerificationCodeNextStepMaterialButton.setOnClickListener {
            replaceFragment(FindPasswordResetPasswordFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.forgetPasswordLayout, fragment)
        fragmentTransaction.commit()
    }
}