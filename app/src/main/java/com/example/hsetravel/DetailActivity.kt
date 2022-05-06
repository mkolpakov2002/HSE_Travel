package com.example.hsetravel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.example.hsetravel.data.ExcursionObject
import com.example.hsetravel.ui.adapter.TravelViewPagerAdapter

class DetailActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val args: DetailActivityArgs by navArgs()
        val selectedObjPosition = args.selectedPosition
        val objArray = args.excursionArray

        val sportsList = objArray.asList()

        viewPager2 = findViewById(R.id.detail_view_pager)

        val viewPagerAdapter = TravelViewPagerAdapter(sportsList, this, viewPager2)
        viewPager2.adapter = viewPagerAdapter
        viewPager2.setCurrentItem(selectedObjPosition, false)
    }
}