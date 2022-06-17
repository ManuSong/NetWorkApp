package com.risingcamp.manu.networkapp

import android.annotation.SuppressLint
import android.app.Fragment
import android.media.Image
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager2.widget.ViewPager2
import com.risingcamp.manu.networkapp.databinding.ActivityMainScreenBinding
import com.risingcamp.manu.networkapp.fragment.*
import com.risingcamp.manu.networkapp.retrofitdata.delicous_restrant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    private val fragmentOne by lazy { MainFragment() }
    private val fragmentTwo by lazy { DiscountResFragment() }
    private val fragmentThree by lazy { PlusFragment() }
    private val fragmentFour by lazy { NoticeFragment() }
    private val fragmentFive by lazy { MypageFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)





        initNavigationBar()


//        getRestrauentData()


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

