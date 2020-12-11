package com.studenthealth.android.ui.community

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CommunityFragmentPagerAdapter(val fragmentManager: FragmentManager, val fragmentList: List<Fragment>, val titles: List<String>) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = fragmentList.size

    override fun getItem(position: Int) = fragmentList.get(position)

    override fun getPageTitle(position: Int) = titles.get(position)

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return super.instantiateItem(container, position)
    }

}