package com.studenthealth.android.ui.individuality.information

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.studenthealth.android.R
import kotlinx.android.synthetic.main.activity_personal_homepage.*

class PersonalHomePageActivity : AppCompatActivity() {

    private lateinit var homepagePagerAdapter: HomepagePagerAdapter
    private lateinit var views: ArrayList<View>
    private lateinit var titles: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_personal_homepage)
        setSupportActionBar(personalHomepageToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        views = ArrayList()
        views.add(layoutInflater.inflate(R.layout.viewpager_personalhomepage_homepage, null, false))
        views.add(layoutInflater.inflate(R.layout.viewpager_personalhomepage_topic, null, false))

        titles = ArrayList()
        titles.add("主页")
        titles.add("帖子")

        homepagePagerAdapter = HomepagePagerAdapter(views, titles)
        personalViewPager.adapter = homepagePagerAdapter

        personalViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                personalNestedScrollView.scrollTo(0,0)
            }
        })

        changeInformationMaterialButton.setOnClickListener {
            val intent = Intent(this, ChangeInformationActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}