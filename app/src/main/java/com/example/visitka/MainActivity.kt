package com.example.visitka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.visitka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCLicks()

    }

    private fun onClick(text: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(SURNAME, text)
        startActivity(intent)
    }

    private fun initCLicks() {
        binding.card1.setOnClickListener { onClick(getString(R.string.Novikov)) }
        binding.card2.setOnClickListener { onClick(getString(R.string.Nurmatov)) }
        binding.card3.setOnClickListener { onClick(getString(R.string.Khalilova)) }
        binding.card4.setOnClickListener { onClick(getString(R.string.Alieva)) }
        binding.card5.setOnClickListener { onClick(getString(R.string.Kolesova)) }
    }

    companion object {
        const val SURNAME = "surname"
    }

}