package com.risingcamp.manu.networkapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.risingcamp.manu.networkapp.R
import com.risingcamp.manu.networkapp.fragment.MainFragment
import com.risingcamp.manu.networkapp.retrofitdata.Data

class MainFragRecyclerFirstAdapter(var noticeResdataList : List<Data>) : RecyclerView.Adapter<MainFragRecyclerFirstAdapter.FirstAdapterView>() {

    inner class FirstAdapterView(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.main_frag_recyclerview_first_item, parent, false)
    ){
        val resName = itemView.findViewById<TextView>(R.id.recycle_res_name)
        val kindofMenu = itemView.findViewById<TextView>(R.id.recycle_kindof_menu)
        val noticeText = itemView.findViewById<TextView>(R.id.main_recycle_notice_text)
        val recycleChacter = itemView.findViewById<ImageView>(R.id.main_recycle_chacter)
        val chactertitle = itemView.findViewById<TextView>(R.id.main_recycle_chacter_title)
        val resImage = itemView.findViewById<ImageView>(R.id.res_imageView)


        fun bindWithView(noticeList : Data) {
            resName.text = noticeList.업소명
            kindofMenu.text = noticeList.종류.toString() ?: ""
            noticeText.text = noticeList.사장님이자랑하는내가게한마디
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainFragRecyclerFirstAdapter.FirstAdapterView {
        return FirstAdapterView((parent))
    }

    override fun onBindViewHolder(
        holder: MainFragRecyclerFirstAdapter.FirstAdapterView,
        position: Int
    ) {
        holder.bindWithView(noticeResdataList[position])
    }

    override fun getItemCount(): Int {
        return noticeResdataList.size
    }
}