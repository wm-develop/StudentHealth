package com.studenthealth.android.ui.individuality.information

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class HomepagePagerAdapter(val views: ArrayList<View>, val titles: ArrayList<String>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return views.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = views.get(position)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views.get(position))
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}