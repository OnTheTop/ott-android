package com.unithon.ott.presentation.ui.question

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unithon.ott.data.model.FamilyModel
import com.unithon.ott.data.remote.response.FamilyResponse
import com.unithon.ott.data.remote.response.MissionResponse
import com.unithon.ott.data.repository.QuestionRepositoryImpl
import retrofit2.Response
import java.lang.Exception

class QuestionViewModel:ViewModel() {
    private val questionRepository = QuestionRepositoryImpl()

    private val _missionContent : MutableLiveData<String> = MutableLiveData()
    val missionContent : LiveData<String> get() = _missionContent

    private val _date : MutableLiveData<String> = MutableLiveData()
    val date : LiveData<String> get() = _date

    suspend fun getMission(missionId : Int){
        try {
            val response: Response<MissionResponse> = questionRepository.getQuestionMission(1,31)
            Log.d("ViewModel: ", "미션 가져오기 : ${response.body()}")
            if (response.isSuccessful) {
                _missionContent.value = response.body()?.content
                _date.value = response.body()?.date
            }
        } catch (e: Exception) {
            Log.d("Error",e.message.toString())
        }
    }


}