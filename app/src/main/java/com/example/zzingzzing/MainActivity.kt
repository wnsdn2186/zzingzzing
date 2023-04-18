package com.example.zzingzzing

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.zzingzzing.Fragment.CollectFragment
import com.example.zzingzzing.Fragment.MessageListFragment
import com.example.zzingzzing.Fragment.TelListFragment
import com.example.zzingzzing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var backPressedTime: Long = 0

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CollectFragment())
            .commit()

        binding.btnMoveHome.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, CollectFragment())
                .commit()
        }

        binding.btnMoveMessageList.setOnClickListener {
            binding.tvToolBarText1.text = "메세지"
            binding.tvToolBarText2.text = " 목록"
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, MessageListFragment())
                .commit()
        }

        binding.btnMoveTelList.setOnClickListener {
            binding.tvToolBarText1.text = "연락처"
            binding.tvToolBarText2.text = " 목록"
            supportFragmentManager.beginTransaction().replace(R.id.mainFrame, TelListFragment())
                .commit()
        }
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedTime < 2000) {
            finish()
            return
        }

        Toast.makeText(this, "뒤로 버튼을 한번 더 누르면 앱이 종료됩니다", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }
}