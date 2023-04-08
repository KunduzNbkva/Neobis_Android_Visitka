package com.example.visitka

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.visitka.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setOnClickListeners()
    }


    private fun initViews() {
        binding.tvDoctorsSurname.text =
            getString(R.string.dr, intent.getStringExtra(MainActivity.SURNAME))
    }

    private fun setOnClickListeners() {
        binding.callLayout.setOnClickListener { actionCall() }
        binding.emailLayout.setOnClickListener { actionEmail() }
        binding.openMap.setOnClickListener { actionMap() }

    }


    private fun actionCall() {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse(getString(R.string.tel) + getString(R.string.phone_num))
        try {
            startActivity(callIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.no_app), Toast.LENGTH_SHORT).show()
        }
    }

    private fun actionEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.setDataAndType(
            Uri.parse(getString(R.string.mailto) + getString(R.string.gmail)),
            null
        )
        startActivity(emailIntent)
    }

    private fun actionMap() {
        val gmmIntentUri = Uri.parse(
            getString(R.string.google_link)
                    + 40.5241845 + "," + 72.8032641 + " (" + getString(R.string.dental_clinic) + ")"
        )
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage(getString(R.string.google_maps_package))
        startActivity(mapIntent)
    }


}


