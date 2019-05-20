package com.shimhg02.hyogeunexample.artodo

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
/**
 * Created by Shimhg02.
 */
interface OnAzimuthChangedListener {
    fun onAzimuthChanged(azimuthFrom: Int, azimuthTo: Int){
        val list = listOf("onNext", "onErrror", "onComplete")
        list.toObservable()
    }
}