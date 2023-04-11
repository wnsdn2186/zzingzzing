package com.example.zzingzzing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zzingzzing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CollectFragment()).commit()

        binding.btnMoveHome.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CollectFragment()).commit()
        }

        binding.btnMoveMessageList.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, MessageListFragment()).commit()
        }

        binding.btnMoveTelList.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, TelListFragment()).commit()
        }
    }
}