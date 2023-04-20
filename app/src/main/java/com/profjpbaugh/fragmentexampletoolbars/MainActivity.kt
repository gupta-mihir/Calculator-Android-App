package com.profjpbaugh.fragmentexampletoolbars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.profjpbaugh.fragmentexampletoolbars.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ToolbarFragment.ToolbarListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
    override fun onButtonClick(text: String) {
        Log.i("MainActivity", "in onButtonClick with text " + text)
        val textFragment = supportFragmentManager.findFragmentById(R.id.textFragment) as TextFragment

        textFragment.changeTextProperties(text)

    }
}