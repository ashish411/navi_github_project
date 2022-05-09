package com.example.naviGithubProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.naviGithubProject.fragments.PrListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment()
    }

    private fun openFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fl_list,PrListFragment.newInstance(bundleOf()))
        ft.commit()
    }
}