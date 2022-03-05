package com.unithon.ott.presentation.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentAlbumBinding

class AlbumFragment : BaseFragment<FragmentAlbumBinding>(R.layout.fragment_album) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(SearchRecipeViewModel::class.java)
//        binding.viewModel = viewModel
//    }

}