package com.studenthealth.android.util

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import java.lang.reflect.Field


object IndicatorLineUtil {

    fun setIndicator(tabs: TabLayout, leftDip: Int, rightDip: Int) {
        val tabLayout = tabs::class.java
        lateinit var tabStrip: Field
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip")
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        }

        tabStrip.isAccessible = true
        lateinit var llTab: LinearLayout
        try {
            llTab = tabStrip.get(tabs) as LinearLayout
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        val left = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip.toFloat(), Resources.getSystem().displayMetrics) as Int
        val right = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip.toFloat(), Resources.getSystem().displayMetrics) as Int

        for (i in 0 until llTab.childCount) {
            val child: View = llTab.getChildAt(i)
            child.setPadding(0, 0, 0, 0)
            val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1F)
            params.leftMargin = left
            params.rightMargin = right
            child.layoutParams = params
            child.invalidate()
        }
    }

}