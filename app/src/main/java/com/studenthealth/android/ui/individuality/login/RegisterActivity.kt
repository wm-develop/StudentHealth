package com.studenthealth.android.ui.individuality.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.studenthealth.android.R
import com.studenthealth.android.util.LogUtil
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerUserEditText.addTextChangedListener {
            val textCount = registerUserEditText.text?.length
            LogUtil.d("RegisterActivity", "$textCount")
            when(textCount) {
                !in 4..16 -> {
                    registerUserTextInputLayout.boxStrokeColor = resources.getColor(R.color.error_color)
                    registerUserTextInputLayout.endIconDrawable = getDrawable(R.drawable.cuowu)
                    registerUserTextInputLayout.setEndIconTintList(resources.getColorStateList(R.color.error_color))
                }
                in 4..16 -> {
                    registerUserTextInputLayout.boxStrokeColor = resources.getColor(R.color.ripple_color)
//                    registerUserTextInputLayout.endIconDrawable = getDrawable(R.drawable.zhengque)
//                    registerUserTextInputLayout.setEndIconTintList(resources.getColorStateList(R.color.ripple_color))
                }
            }
        }

        phoneNumberEditText.addTextChangedListener {
            //这里实现提示手机号是否可用的逻辑，不要忘记处理当手机号已被使用时找回密码的逻辑
        }

        registerMaterialButton.setOnClickListener {
            //这里实现注册逻辑
        }

        getVerificationCodeMaterialButton.setOnClickListener {
            //获取验证码
        }

        passwordEditText.addTextChangedListener {
            //处理密码是否符合格式要求逻辑
        }

        findPassword.setOnClickListener {
            finish();
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}