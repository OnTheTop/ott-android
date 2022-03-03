package com.unithon.ott.common.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showLoading() {
    /**TODO :: 로딩 다이얼로그
       val loadingDialog = LoadingDialog()
       loadingDialog.show(supportFragmentManager,"LoadingDialog")
    **/
    }
}