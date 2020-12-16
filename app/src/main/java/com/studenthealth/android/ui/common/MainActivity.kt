package com.studenthealth.android.ui.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.studenthealth.android.R
import com.studenthealth.android.ui.community.CommunityFragment
import com.studenthealth.android.ui.health.HealthFragment
import com.studenthealth.android.ui.individuality.IndividualityUnloginFragment
import com.studenthealth.android.ui.schedule.ScheduleFragment
import com.studenthealth.android.ui.shop.ShopFragment
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HealthFragment())
        health.setTextColor(resources.getColor(R.color.ripple_color))
        health.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang2), null ,null)

        health.setOnClickListener {
            health.setTextColor(resources.getColor(R.color.ripple_color))
            health.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang2), null ,null)
            community?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shequ), null, null)
            }
            shop?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shangcheng), null, null)
            }
            schedule?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jihua), null, null)
            }
            individuality?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.wode), null, null)
            }
            replaceFragment(HealthFragment())
        }

        community.setOnClickListener {
            community.setTextColor(resources.getColor(R.color.ripple_color))
            community.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shequ2), null ,null)
            health?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang), null, null)
            }
            shop?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shangcheng), null, null)
            }
            schedule?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jihua), null, null)
            }
            individuality?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.wode), null, null)
            }
            replaceFragment(CommunityFragment())
        }

        shop.setOnClickListener {
            shop.setTextColor(resources.getColor(R.color.ripple_color))
            shop.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shangcheng2), null ,null)
            health?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang), null, null)
            }
            community?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shequ), null, null)
            }
            schedule?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jihua), null, null)
            }
            individuality?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.wode), null, null)
            }
            replaceFragment(ShopFragment())
        }

        schedule.setOnClickListener {
            schedule.setTextColor(resources.getColor(R.color.ripple_color))
            schedule.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jihua2), null ,null)
            health?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang), null, null)
            }
            community?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shequ), null, null)
            }
            shop?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shangcheng), null, null)
            }
            individuality?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.wode), null, null)
            }
            replaceFragment(ScheduleFragment())
        }

        individuality.setOnClickListener {
            individuality.setTextColor(resources.getColor(R.color.ripple_color))
            individuality.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.wode2), null, null)
            health?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jiankang), null, null)
            }
            community?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shequ), null, null)
            }
            shop?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.shangcheng), null, null)
            }
            schedule?.let {
                it.setTextColor(resources.getColor(R.color.black))
                it.setCompoundDrawablesRelativeWithIntrinsicBounds(null, getDrawable(R.drawable.jihua), null, null)
            }
            replaceFragment(IndividualityUnloginFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun removeFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction =  fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment)
        fragmentTransaction.commit()
    }

}
