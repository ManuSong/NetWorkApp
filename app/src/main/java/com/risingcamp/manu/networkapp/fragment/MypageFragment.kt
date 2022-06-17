package com.risingcamp.manu.networkapp.fragment

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.text.style.TtsSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient
import com.risingcamp.manu.networkapp.MainScreenActivity
import com.risingcamp.manu.networkapp.PreviewScreenActivity
import com.risingcamp.manu.networkapp.R
import com.risingcamp.manu.networkapp.databinding.FragmentMypageBinding


class MypageFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val Mbinding = FragmentMypageBinding.inflate(inflater, container, false)



        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Mbinding.notLoginScreen.visibility = View.VISIBLE
                Mbinding.loginScreen.visibility = View.INVISIBLE
                Mbinding.mypageLoginBtn.setOnClickListener {
                    val intent = Intent(context, PreviewScreenActivity::class.java)
                    startActivity(intent)
                }
            }
            else if (tokenInfo != null) {
                UserApiClient.instance.me { user, error ->
                    if (error != null){
                        Log.e(TAG, "사용자 정보 요청 실패", error)
                    } else if (user != null){

                        Mbinding.notLoginScreen.visibility = View.INVISIBLE
                        Mbinding.loginScreen.visibility = View.VISIBLE
                        Glide.with(inflater.context).load(user.kakaoAccount?.profile?.thumbnailImageUrl).circleCrop().into(Mbinding.userProfile)
                        Mbinding.userNickname.text = user.kakaoAccount?.profile?.nickname

                        Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n프로필사진 : ${user.kakaoAccount?.profile?.thumbnailImageUrl}" +
                        "\n닉네임 : ${user.kakaoAccount?.profile?.nickname}")

                    }
                }
            }
        }


        return Mbinding.root
    }


}