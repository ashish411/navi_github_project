package com.example.naviGithubProject.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.naviGithubProject.R
import com.example.naviGithubProject.adapter.ClosedPrListAdapter
import com.example.naviGithubProject.network.ApiStatus.ERROR
import com.example.naviGithubProject.network.ApiStatus.LOADING
import com.example.naviGithubProject.network.ApiStatus.SUCCESS
import com.example.naviGithubProject.network.NaviApiHelper
import com.example.naviGithubProject.network.NaviModel
import com.example.naviGithubProject.network.RetrofitHelper
import com.example.naviGithubProject.utils.hide
import com.example.naviGithubProject.utils.show
import com.example.naviGithubProject.viewmodels.ClosedPrViewModel
import com.example.naviGithubProject.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_pr_list.*

class PrListFragment : Fragment() {

    private lateinit var adapter: ClosedPrListAdapter
    private lateinit var viewmodel: ClosedPrViewModel

    companion object{
        fun newInstance(bundle: Bundle): PrListFragment{
            val fragment = PrListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pr_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView(){
        viewmodel = ViewModelProvider(this,ViewModelFactory(NaviApiHelper(RetrofitHelper.apiService))).get(ClosedPrViewModel::class.java)
        adapter = ClosedPrListAdapter()
        rv_closed_pr?.adapter = adapter

        viewmodel.getClosedPrList().observe(viewLifecycleOwner) {
            when (it.apiStatus) {
                LOADING -> {
                    rv_closed_pr?.hide()
                    pb_loader?.show()
                }
                SUCCESS -> {
                    pb_loader?.hide()
                    rv_closed_pr?.show()
                    it.data?.let { closedPrList -> adapter.addData(closedPrList as ArrayList<NaviModel>) }
                }
                ERROR -> {
                    pb_loader?.hide()
                    Toast.makeText(activity, getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}