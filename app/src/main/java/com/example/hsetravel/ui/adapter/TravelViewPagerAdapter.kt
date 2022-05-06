package com.example.hsetravel.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.*
import com.example.hsetravel.R
import com.example.hsetravel.data.ExcursionObject
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TravelViewPagerAdapter(
    private val sportsList: List<ExcursionObject>,
    private val activity: Activity,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<TravelViewPagerAdapter.TravelViewHolder>(){

    class TravelViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val toolbar: MaterialToolbar = itemView.findViewById(R.id.detail_toolbar)
        val fab: FloatingActionButton = itemView.findViewById(R.id.fab_detail)
        private val banner: ImageView = itemView.findViewById(R.id.detail_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_detail_text_view)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_detail_text_view)
        private val about: TextView = itemView.findViewById(R.id.about_detail_text_view)

        fun bind(
            dataItem: ExcursionObject,
        ) {
            //banner.setImageResource(dataItem.banner)
            title.text = dataItem.title
            subtitle.text = dataItem.subtitle
            toolbar.title = dataItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        return TravelViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_detailed, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        val sportsArgs: ExcursionObject = sportsList[position]
        holder.bind(sportsArgs)

        holder.toolbar.setNavigationOnClickListener {
            activity.finish()
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                when (state) {
                    SCROLL_STATE_DRAGGING -> {
                        holder.fab.visibility = View.INVISIBLE
                    }
                    SCROLL_STATE_IDLE -> {
                        holder.fab.visibility = View.VISIBLE
                    }
                    SCROLL_STATE_SETTLING -> {
                        holder.fab.visibility = View.INVISIBLE
                    }
                }
            }
        })

    }

    override fun getItemCount() = sportsList.size

}