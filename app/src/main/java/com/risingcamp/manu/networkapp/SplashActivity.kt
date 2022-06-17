package com.risingcamp.manu.networkapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.widget.Toast
import androidx.core.os.HandlerCompat.postDelayed
import com.kakao.sdk.user.UserApiClient
import com.risingcamp.manu.networkapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    var handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)



        handler.postDelayed({
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error != null) {
                    val intent = Intent(this@SplashActivity, PreviewScreenActivity::class.java)
                    Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }
                else if (tokenInfo != null) {
                    Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainScreenActivity::class.java)
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
            startActivity(intent)
        },1500)

    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}