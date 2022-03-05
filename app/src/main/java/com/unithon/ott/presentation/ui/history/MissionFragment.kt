package com.unithon.ott.presentation.ui.history

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.unithon.ott.R
import com.unithon.ott.common.base.BaseFragment
import com.unithon.ott.databinding.FragmentMissionBinding
import com.unithon.ott.presentation.adapter.MissionListAdapter
import com.unithon.ott.presentation.ui.question.QuestionActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MissionFragment : BaseFragment<FragmentMissionBinding>(R.layout.fragment_mission) {



    private val viewModel by lazy { ViewModelProvider(requireActivity()).get(HistoryViewModel::class.java) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.missionRvMission.adapter = MissionListAdapter { it ->
            val intent = Intent(requireContext(), QuestionActivity::class.java)
            intent.putExtra("missionId", it)
            startActivity(intent)
        }

    }

}