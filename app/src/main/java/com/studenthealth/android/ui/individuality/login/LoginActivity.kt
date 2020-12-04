package com.studenthealth.android.ui.individuality.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginMaterialButton.setOnClickListener { 
            //这里实现登录逻辑
        }
        
        rememberPasswordCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            //实现记住密码逻辑
        }

        forgetPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}