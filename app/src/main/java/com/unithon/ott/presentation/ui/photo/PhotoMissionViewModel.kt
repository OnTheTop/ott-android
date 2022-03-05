package com.unithon.ott.presentation.ui.photo

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhotoMissionViewModel : ViewModel() {

    private var _pastImage : MutableLiveData<Uri> = MutableLiveData()
    val pastImage : LiveData<Uri> get() = _pastImage

    private var _recentImage : MutableLiveData<Uri> = MutableLiveData()
    val recentImage : LiveData<Uri> get() = _recentImage

    var photoComment : MutableLiveData<String> = MutableLiveData()

    fun setPastImage(img : Uri){
        _pastImage.value = img
        Log.d("pastImg","past : ${pastImage}, new : $img")
    }

    fun setRecentImage(img : Uri){
        _recentImage.value = img
    }
}