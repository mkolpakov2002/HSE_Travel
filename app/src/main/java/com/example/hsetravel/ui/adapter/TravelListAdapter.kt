package com.example.hsetravel.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hsetravel.R
import com.example.hsetravel.data.ExcursionObject

class TravelListAdapter (
    private val excursionObjectList: List<ExcursionObject>,
    private val onClickListener: OnClickListener
) : ListAdapter<ExcursionObject, TravelListAdapter.TravelViewItemHolder>(ItemComparator()){

    class TravelViewItemHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val banner: ImageView = itemView.findViewById(R.id.banner_item_image_view)
        private val title: TextView = itemView.findViewById(R.id.title_item_text_view)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_item_text_view)

        fun bind(
            dataItem: ExcursionObject,
            onClickListener: OnClickListener,
        ) {
            banner.setImageResource(R.drawable.hse_travel)
            title.text = dataItem.title
            subtitle.text = dataItem.subtitle
            itemView.setOnClickListener {
                onClickListener.onClick(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewItemHolder {
        return TravelViewItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TravelViewItemHolder, position: Int) {
        val sports: ExcursionObject = excursionObjectList[position]
        holder.bind(sports, onClickListener)
    }

    override fun getItemCount() = excursionObjectList.size

    class OnClickListener(val clickListener: (selectedObj: Int) -> Unit) {
        fun onClick(selectedObj: Int) = clickListener(selectedObj)
    }

    class ItemComparator : DiffUtil.ItemCallback<ExcursionObject>() {
        override fun areItemsTheSame(oldItem: ExcursionObject, newItem: ExcursionObject): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ExcursionObject, newItem: ExcursionObject): Boolean {
            return oldItem.title == newItem.title &&
                    oldItem.subtitle == newItem.subtitle &&
                    oldItem.id == newItem.id
        }
    }

}