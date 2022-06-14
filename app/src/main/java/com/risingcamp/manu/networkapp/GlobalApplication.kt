package com.risingcamp.manu.networkapp

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "34c8ef422aff7c99d323b0cb931a3cee")
    }
}