package com.risingcamp.manu.networkapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.risingcamp.manu.networkapp.*
import com.risingcamp.manu.networkapp.Adapter.AdViewPagerAdapter
import com.risingcamp.manu.networkapp.Adapter.MainFragRecyclerFirstAdapter
import com.risingcamp.manu.networkapp.DataClass.ImageData
import com.risingcamp.manu.networkapp.databinding.FragmentMainBinding
import com.risingcamp.manu.networkapp.retrofitdata.Data
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.System.load


class MainFragment : Fragment() {

    private var AdImageList = ArrayList<ImageData>()
    private lateinit var AdViewPagerAdapter : AdViewPagerAdapter
    private var noticeDataList = ArrayList<Data>()
    private lateinit var MainFragRecyclerFirstAdapter : MainFragRecyclerFirstAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        AdImageList.add(ImageData(R.drawable.mango_ad1))
        AdImageList.add(ImageData(R.drawable.manggo_ad2))
        AdImageList.add(ImageData(R.drawable.manggo_ad3))
        AdImageList.add(ImageData(R.drawable.manggo_ad4))
        AdImageList.add(ImageData(R.drawable.manggo_ad5))

        AdViewPagerAdapter = AdViewPagerAdapter(AdImageList)

        binding.mainFrgViewpager2.apply {
            adapter = AdViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(
            binding.tabMainBanner,
            binding.mainFrgViewpager2
        ){
            tab, position ->
            binding.mainFrgViewpager2.setCurrentItem(tab.position)
        }.attach()


        val noticeList = binding.noticeRecycler

        val resInterface = RetrofitClient.sRetrofit.create(RestaurantInterface::class.java)
        resInterface.getRestaurant(1,61,"oT9zyC/LGfZfmiomD0COKOzcKAEp6tXQC3V6dRg2QVd6JiW3QxSq7xzuAQiKSxvO6TrD52RTSKlEHEAcg64hpw==").enqueue(object :
            Callback<delicous_restrant> {
            @SuppressLint("SetText18n")
            override fun onResponse(
                call: Call<delicous_restrant>,
                response: Response<delicous_restrant>
            ) {
                if(response.isSuccessful) {
                    val result = response.body() as delicous_restrant
                    if (result != null){
                        MainFragRecyclerFirstAdapter = MainFragRecyclerFirstAdapter(result.data)
                        noticeList.adapter = MainFragRecyclerFirstAdapter

                    }

                } else {
                    Log.d("testt", "getRestraurant - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<delicous_restrant>, t: Throwable) {
                Log.d("testt", t.message ?: "통신 오류")
            }
        })



        return binding.root
    }


    private fun getRestrauentData() {
//        val resInterface = RetrofitClient.sRetrofit.create(RestaurantInterface::class.java)
//        resInterface.getRestaurant(1,61,"oT9zyC/LGfZfmiomD0COKOzcKAEp6tXQC3V6dRg2QVd6JiW3QxSq7xzuAQiKSxvO6TrD52RTSKlEHEAcg64hpw==").enqueue(object :
//            Callback<delicous_restrant> {
//            override fun onResponse(
//                call: Call<delicous_restrant>,
//                response: Response<delicous_restrant>
//            ) {
//                if(response.isSuccessful) {
//                    val result = response.body() as delicous_restrant
//
//                } else {
//                    Log.d("testt", "getRestraurant - onResponse : Error code ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<delicous_restrant>, t: Throwable) {
//                Log.d("testt", t.message ?: "통신 오류")
//            }
//        })

    }



}