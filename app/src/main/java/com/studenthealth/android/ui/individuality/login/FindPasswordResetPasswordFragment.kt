package com.studenthealth.android.ui.individuality.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_find_password_reset_password.*

class FindPasswordResetPasswordFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_find_password_reset_password, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        resetPasswordNextStepMaterialButton.setOnClickListener {
            replaceFragment(FindPasswordResetSuccessFragment())
        }
        newPasswordEditText.addTextChangedListener {
            val textCount = newPasswordEditText.text?.length
            when(textCount) {
                !in 6..16 -> {
                    newPasswordTextLayout.boxStrokeColor = resources.getColor(R.color.error_color)
                    newPasswordTextLayout.setEndIconTintList(resources.getColorStateList(R.color.error_color))
                }
                in 6..16 -> {
                    newPasswordTextLayout.boxStrokeColor = resources.getColor(R.color.ripple_color)
                    newPasswordTextLayout.setEndIconTintList(resources.getColorStateList(R.color.ripple_color))
                }
            }
        }
        newPasswordConfirmEditText.addTextChangedListener {
            val textCount = newPasswordEditText.text?.length
            when(textCount) {
                !in 6..16 -> {
                    newPasswordConfirmTextLayout.boxStrokeColor = resources.getColor(R.color.error_color)
                }
                in 6..16 -> {
                    newPasswordConfirmTextLayout.boxStrokeColor = resources.getColor(R.color.ripple_color)
                }
            }
            val newPasswordText = newPasswordEditText.text.toString()
            val newPasswordConfirmText = newPasswordConfirmEditText.text.toString()
            if (newPasswordText != newPasswordConfirmText) {
                newPasswordConfirmTextLayout.boxStrokeColor = resources.getColor(R.color.error_color)
                newPasswordConfirmTextLayout.endIconDrawable = activity?.getDrawable(R.drawable.cuowu)
                newPasswordConfirmTextLayout.setEndIconTintList(resources.getColorStateList(R.color.error_color))
                reInputHint.text = getText(R.string.error_reset_password)
            } else {
                newPasswordConfirmTextLayout.boxStrokeColor = resources.getColor(R.color.ripple_color)
                newPasswordConfirmTextLayout.endIconDrawable = activity?.getDrawable(R.drawable.zhengque)
                newPasswordConfirmTextLayout.setEndIconTintList(resources.getColorStateList(R.color.ripple_color))
                reInputHint.text = ""
            }
        }
        resetPasswordNextStepMaterialButton.setOnClickListener {
            //重置密码
            replaceFragment(FindPasswordResetSuccessFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.forgetPasswordLayout, fragment)
        fragmentTransaction.commit()
    }
}