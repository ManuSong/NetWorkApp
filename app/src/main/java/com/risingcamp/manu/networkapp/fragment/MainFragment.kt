package com.risingcamp.manu.networkapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.risingcamp.manu.networkapp.*
import com.risingcamp.manu.networkapp.databinding.FragmentMainBinding
import com.risingcamp.manu.networkapp.retrofitdata.Data
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    private var AdImageList = ArrayList<ImageData>()
    private lateinit var AdViewPagerAdapter : AdViewPagerAdapter

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



        getRestrauentData()
        return binding.root
    }


    private fun getRestrauentData() {
        val resInterface = RetrofitClient.sRetrofit.create(RestaurantInterface::class.java)
        resInterface.getRestaurant(1,61,"oT9zyC/LGfZfmiomD0COKOzcKAEp6tXQC3V6dRg2QVd6JiW3QxSq7xzuAQiKSxvO6TrD52RTSKlEHEAcg64hpw==").enqueue(object :
            Callback<delicous_restrant> {
            override fun onResponse(
                call: Call<delicous_restrant>,
                response: Response<delicous_restrant>
            ) {
                if(response.isSuccessful) {
                    val result = response.body() as delicous_restrant
                    result.data.forEach {
                        Log.d("testt", " ${it.사장님이자랑하는내가게한마디}")
                    }

                } else {
                    Log.d("testt", "getRestraurant - onResponse : Error code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<delicous_restrant>, t: Throwable) {
                Log.d("testt", t.message ?: "통신 오류")
            }
        })

    }


}