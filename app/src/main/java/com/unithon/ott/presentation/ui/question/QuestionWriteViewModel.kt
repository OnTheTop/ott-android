package com.unithon.ott.presentation.ui.question

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionWriteViewModel : ViewModel() {

    var nickname : MutableLiveData<String> = MutableLiveData()
    var answer : MutableLiveData<String> = MutableLiveData()

    init {
        nickname.value = "로컬에서 가져올 예정"
    }
}