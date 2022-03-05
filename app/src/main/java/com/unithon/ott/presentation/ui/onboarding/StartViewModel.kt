package com.unithon.ott.presentation.ui.onboarding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unithon.ott.data.model.FamilyModel
import com.unithon.ott.data.remote.response.FamilyResponse
import com.unithon.ott.data.repository.FamilyRepositoryImpl
import retrofit2.Response
import java.lang.Exception

class StartViewModel : ViewModel() {
    private val familyRepository = FamilyRepositoryImpl()

    val familyNick: MutableLiveData<String> = MutableLiveData()
    val nickname: MutableLiveData<String> = MutableLiveData()
    val familyCode: MutableLiveData<String> = MutableLiveData()

    suspend fun postFamily() {
        try {
            val familyModel = FamilyModel(familyNick.value ?: "",nickname.value ?: "")
            val response: Response<FamilyResponse> = familyRepository.postFamily(familyModel)
            Log.d("ViewModel: ", "가족 만들기! : ${response.body()}")
            if (response.isSuccessful) {
                familyCode.value = response.body()?.familyCode
            }
        } catch (e: Exception) {
            Log.d("Error",e.message.toString())
        }
    }

    suspend fun postFamilyMember(){
        try {
            val response: Response<FamilyResponse> = familyRepository.postFamilyMember(
                nickname.value?:"",familyCode.value?:""
            )
            Log.d("ViewModel: ", "가족 구성원 가입하기!! : ${response.errorBody()}")
            Log.d("ViewModel: ", "가족 구성원 가입하기!! : ${response.headers()}")
            Log.d("ViewModel: ", "가족 구성원 가입하기!! : ${response.message()}")
            if (response.isSuccessful) {
                Log.d("ViewModel: ", "가족 구성원 가입하기!! : ${response.body()?.memberNickname}")
            }
        } catch (e: Exception) {
            Log.d("Error",e.message.toString())
        }
    }
}