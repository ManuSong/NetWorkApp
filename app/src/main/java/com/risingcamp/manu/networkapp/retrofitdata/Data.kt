package com.risingcamp.manu.networkapp.retrofitdata

import com.google.gson.annotations.SerializedName

data class Data(
    val 경도: String,
    val 사장님이자랑하는내가게한마디: String,
    val 업소명: String,
    val 위도: String,
    val 전화번호: String,
    val 종류: Int,
    val 주소1: String ,
    val 주소2: String,
    val 주요요리: String,
    val 테마: String

){
    constructor(사장님이자랑하는내가게한마디: String, 업소명: String, 종류: Int)
            : this( "",사장님이자랑하는내가게한마디,업소명,"","", 종류, "", "","", "")
}