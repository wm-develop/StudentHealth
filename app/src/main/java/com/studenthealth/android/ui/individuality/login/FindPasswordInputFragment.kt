package com.studenthealth.android.ui.individuality.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_find_password_input.*

class FindPasswordInputFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_find_password_input, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        inputNextStepMaterialButton.setOnClickListener {
            //判断用户名或手机号是否已在数据库中，如果存在，正常替换fragment
            replaceFragment(FindPasswordGetVerificationCodeFragment())
            //如果不存在，弹出Toast提示
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.forgetPasswordLayout, fragment)
        fragmentTransaction.commit()
    }

    //backgroundtint
    //
}