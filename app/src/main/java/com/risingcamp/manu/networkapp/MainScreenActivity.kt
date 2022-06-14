package com.risingcamp.manu.networkapp

import android.app.Fragment
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.risingcamp.manu.networkapp.databinding.ActivityMainScreenBinding
import com.risingcamp.manu.networkapp.fragment.*

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding
    private var AdImageList = ArrayList<ImageData>()
    private lateinit var AdViewPagerAdapter : AdViewPagerAdapter
    private val fragmentOne by lazy { MainFragment() }
    private val fragmentTwo by lazy { DiscountResFragment() }
    private val fragmentThree by lazy { PlusFragment() }
    private val fragmentFour by lazy { NoticeFragment() }
    private val fragmentFive by lazy { MypageFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        AdImageList.add(ImageData(R.drawable.mango_ad1))
        AdImageList.add(ImageData(R.drawable.manggo_ad2))
        AdImageList.add(ImageData(R.drawable.manggo_ad3))
        AdImageList.add(ImageData(R.drawable.manggo_ad4))
        AdImageList.add(ImageData(R.drawable.manggo_ad5))
        AdImageList.add(ImageData(R.drawable.manggo_ad6))

        AdViewPagerAdapter = AdViewPagerAdapter(AdImageList)

        initNavigationBar()



    }

    fun initNavigationBar() {

        binding.btmNavi.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.find_res_btn -> {
                        changeFragment(fragmentOne)

                    }
                    R.id.discount_res_btn -> {
                        changeFragment(fragmentTwo)

                    }

                    R.id.notice_res_btn -> {
                        changeFragment(fragmentFour)

                    }

                    R.id.mypage_res_btn -> {
                        changeFragment(fragmentFive)

                    }

                    R.id.btm_plus_btn -> {
                        changeFragment(fragmentThree)

                    }

                }
                true
            }
            selectedItemId = R.id.find_res_btn
        }
    }

    private fun changeFragment(fragment: androidx.fragment.app.Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment)
            .commit()
    }

}