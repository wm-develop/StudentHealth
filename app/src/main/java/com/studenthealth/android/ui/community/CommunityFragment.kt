package com.studenthealth.android.ui.community

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.fragment_community.*

class CommunityFragment : Fragment() {

    lateinit var contextView: View
    lateinit var communityTabLayout: TabLayout
    lateinit var communityViewPager: ViewPager
    lateinit var communityToolbar: Toolbar
    val fragmentList: List<Fragment> = mutableListOf(
        CommunityNewestFragment(),
        CommunityChoiceFragment()
    )
    val titles = mutableListOf("最新", "精选")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contextView = inflater.inflate(R.layout.fragment_community, container, false)
        communityTabLayout = contextView.findViewById(R.id.communityTabLayout)
        communityViewPager = contextView.findViewById(R.id.communityViewPager)
        communityToolbar = contextView.findViewById(R.id.communityToolbar)
        communityToolbar.title = ""
        (activity as AppCompatActivity).setSupportActionBar(communityToolbar)
        return contextView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val communityFragmentPagerAdapter = CommunityFragmentPagerAdapter(
            childFragmentManager,
            fragmentList,
            titles
        )
        communityTabLayout.setupWithViewPager(communityViewPager)
        communityViewPager.adapter = communityFragmentPagerAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        issueTopicFloatingActionButton.setOnClickListener {
            val intent = Intent(activity, IssueTopicActivity::class.java)
            startActivity(intent)
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        menu.clear()
////        inflater.inflate(R.menu., menu)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        when(item.itemId) {
//////      处理菜单单击逻辑
////        }
//    }

}