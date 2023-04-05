package com.example.visitka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.example.visitka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.card1.setOnClickListener{onClick("Novikov")}
        binding.card2.setOnClickListener{onClick("Nurmatov")}
        binding.card3.setOnClickListener{onClick("Khalilova")}
        binding.card4.setOnClickListener{onClick("Alieva")}
        binding.card5.setOnClickListener{onClick("Kolesova")}

    }


     fun onClick(text: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(SURNAME, text)
        startActivity(intent)
    }

    companion object{
        const val SURNAME = "surname"
    }

}