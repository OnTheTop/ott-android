package com.unithon.ott.presentation.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseDialog
import com.unithon.ott.databinding.DialogLoadingBinding

class LoadingDialog : BaseDialog<DialogLoadingBinding>(R.layout.dialog_loading) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        isCancelable = false
        return binding.root
    }
}