package com.example.naviGithubProject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.naviGithubProject.R
import com.example.naviGithubProject.network.NaviModel
import kotlinx.android.synthetic.main.item_closed_pr.view.*

class ClosedPrListAdapter(): RecyclerView.Adapter<ClosedPrListAdapter.MyViewholder>() {

    private var list: ArrayList<NaviModel> = arrayListOf()

    fun addData(data: ArrayList<NaviModel>){
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClosedPrListAdapter.MyViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_closed_pr,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: ClosedPrListAdapter.MyViewholder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewholder(itemView: View): ViewHolder(itemView){
        fun bindView(model: NaviModel){
            itemView.run{
                tv_created_on?.text = model.creationDate
                tv_closed_on?.text = model.closedDate
                tv_pr_title?.text = model.title
                tv_user_name?.text = model.user?.userName
                Glide.with(itemView.context)
                    .load(model.user?.userImage)
                    .into(iv_avatar)
            }
        }
    }
}