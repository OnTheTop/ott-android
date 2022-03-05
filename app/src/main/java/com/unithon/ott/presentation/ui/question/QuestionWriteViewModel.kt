package com.unithon.ott.presentation.ui.question

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionWriteViewModel : ViewModel() {

    var nickname : String = "getNickName()"
    var answer : MutableLiveData<String> = MutableLiveData()

}