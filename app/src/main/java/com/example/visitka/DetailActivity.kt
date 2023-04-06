package com.example.visitka

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.visitka.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDoctorsSurname.text = "Dr. ${intent.getStringExtra(MainActivity.SURNAME)}"

        binding.callLayout.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:" + "0 700 330 200")
            startActivity(callIntent)
        }

        binding.emailLayout.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.setDataAndType(Uri.parse("mailto:" + "dentistkg@gmail.com"), null)
            startActivity(emailIntent)
        }

        binding.openMap.setOnClickListener {
            val gmmIntentUri = Uri.parse("http://maps.google.com/maps?q=loc:"
                    +40.5241845+","+72.8032641+" (" + "Dental clinic" + ")")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }


    }

}


