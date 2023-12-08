package com.example.tugasandroid

import android.icu.util.Calendar
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.home -> selectedFragment = Fragment_Home()
                R.id.profile -> selectedFragment = Fragment_Profile()
                R.id.calendar -> selectedFragment = Fragment_Calender()
                R.id.notification -> selectedFragment = Fragment_Calender()
            }

            if (selectedFragment != null) {
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.framelayout, selectedFragment)
                    .commit()
            }

            true
        }
    }
}