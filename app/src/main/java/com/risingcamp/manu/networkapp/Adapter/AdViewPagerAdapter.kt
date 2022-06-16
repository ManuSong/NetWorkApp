package com.risingcamp.manu.networkapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.risingcamp.manu.networkapp.DataClass.ImageData
import com.risingcamp.manu.networkapp.R

class AdViewPagerAdapter(var adImageList : ArrayList<ImageData>) : RecyclerView.Adapter<AdViewPagerAdapter.AdPagerAdapter>() {

    inner class AdPagerAdapter(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.main_ad_viewpager_item, parent, false)
    ){
        val adImages = itemView.findViewById<ImageView>(R.id.ad_images)

        fun onBindWith(mainImageList : ImageData){
            adImages.setImageResource(mainImageList.imageSrc)
        }

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdPagerAdapter {
        return AdPagerAdapter((parent))
    }

    override fun onBindViewHolder(holder: AdPagerAdapter, position: Int) {
        holder.onBindWith(adImageList[position])
    }

    override fun getItemCount(): Int {
        return adImageList.size
    }


}