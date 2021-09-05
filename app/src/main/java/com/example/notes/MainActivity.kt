package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.utilits.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar
    lateinit var mNavController: NavController
    private var _binding:ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this
        mToolbar = mBinding.toolbar
        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title = getString(R.string.title)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}