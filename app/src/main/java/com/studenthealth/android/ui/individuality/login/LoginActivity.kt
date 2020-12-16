package com.studenthealth.android.ui.individuality.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            val userName = userName.text.toString()
            val accountPassword = accountPassword.text.toString()
            if ((userName == "15295751665" && accountPassword == "123456") || (userName == "15563432331" && accountPassword == "123456") || (userName == "15366583153" && accountPassword == "123456") || (userName == "13914368977" && accountPassword == "123456") || (userName == "18360379100" && accountPassword == "123456")) {
                Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
                finish()
            }
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