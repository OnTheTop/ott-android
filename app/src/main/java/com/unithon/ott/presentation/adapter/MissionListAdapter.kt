package com.unithon.ott.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unithon.ott.data.model.Mission
import com.unithon.ott.databinding.BbibbiBinding

class MissionListAdapter(private val itemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<MissionListAdapter.ViewHolder>() {

    private var missionList: ArrayList<Mission> = arrayListOf()

    inner class ViewHolder(private val binding: BbibbiBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mission: Mission) {
            binding.title.text = "${mission.missionCategory} 미션 / ${mission.memberCount}명"
            binding.date.text = mission.date
            binding.root.setOnClickListener { itemClickListener(mission.missionId) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BbibbiBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(missionList[position])
    }

    override fun getItemCount(): Int = missionList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setMissionList(newMissionList: ArrayList<Mission>) {
        missionList.clear()
        missionList.addAll(newMissionList)
        notifyDataSetChanged()
    }
}