package com.studenthealth.android.ui.individuality.mycollection

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyCollectionPagerAdapter(val fragmentManager: FragmentManager, val fragmentList: List<Fragment>, val titles: ArrayList<String>) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = fragmentList.size

    override fun getItem(position: Int) = fragmentList.get(position)

    override fun getPageTitle(position: Int) = titles.get(position)

}