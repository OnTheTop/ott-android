package com.unithon.ott.presentation.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {

    val familyNick : MutableLiveData<String> = MutableLiveData()
    val nickname : MutableLiveData<String> = MutableLiveData()
    val familyCode : MutableLiveData<String> = MutableLiveData()

}