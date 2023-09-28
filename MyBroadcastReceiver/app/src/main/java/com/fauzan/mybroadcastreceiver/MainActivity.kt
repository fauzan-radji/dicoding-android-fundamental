package com.fauzan.mybroadcastreceiver

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import com.fauzan.mybroadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    private var requestPermissionLauncher = registerForActivityResult(RequestPermission()) { isGranted ->
        Toast.makeText(
            this,
            if (isGranted) {
                "Sms receiver permission diterima"
            } else {
                "Sms receiver permission ditolak"
            },
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnPermission?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_permission -> requestPermissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}