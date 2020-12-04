package com.studenthealth.android.ui.individuality.mycollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_my_collection.*

class MyCollectionActivity : AppCompatActivity() {

    private lateinit var myCollectionPagerAdapter: MyCollectionPagerAdapter
    private lateinit var fragmentList: ArrayList<Fragment>
    private lateinit var titles: ArrayList<String>
    val healthList = mutableListOf(MyCollectionHealthData("123", "456", "789"), MyCollectionHealthData("321", "654", "987"), MyCollectionHealthData("987", "654", "321"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_collection)
        myCollectionToolbar.title = ""
        setSupportActionBar(myCollectionToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val layoutManager = LinearLayoutManager(this)
//        mycollectionHealthRecyclerView.layoutManager = layoutManager
//        val myCollectionHealthRecyclerViewAdapter = MyCollectionHealthRecyclerViewAdapter(this, healthList)
//        mycollectionHealthRecyclerView.adapter = myCollectionHealthRecyclerViewAdapter

        fragmentList = ArrayList()
        fragmentList.add(MyCollectionHealthFragment())
        fragmentList.add(MyCollectionTopicFragment())
        fragmentList.add(MyCollectionGoodFragment())

        titles = ArrayList()
        titles.add("健康")
        titles.add("帖子")
        titles.add("商品")

        myCollectionPagerAdapter = MyCollectionPagerAdapter(supportFragmentManager, fragmentList, titles)
        collectionViewPager.adapter = myCollectionPagerAdapter

        collectionViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
//                myCollectionNestedScrollView.scrollTo(0,0)
            }
        })



    }
}