package com.risingcamp.manu.networkapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.risingcamp.manu.networkapp.databinding.ActivityPreviewscreenBinding

class PreviewScreenActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPreviewscreenBinding
    private lateinit var roketAnimation : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipBtn.apply {
            setOnClickListener {
                val intent = Intent(this@PreviewScreenActivity, MainScreenActivity::class.java)
                startActivity(intent)
            }
        }

    }
}