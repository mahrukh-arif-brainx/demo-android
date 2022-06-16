package com.example.demoproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.demoproject.databinding.ActivitySplashScreenBinding
import com.example.demoproject.models.AppSharedPreference


class SplashScreenActivity : AppCompatActivity() {
    lateinit var dBinding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dBinding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(dBinding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            if (isLogin()) {
                val i = Intent(this@SplashScreenActivity, HomeActivity::class.java)
                startActivity(i)

            } else {
                val i = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                startActivity(i)
            }
            finish()


        }, 3000)

    }

    private fun isLogin(): Boolean {
        var status: Boolean = false
        if (AppSharedPreference.getAppSharedPreferences(this)?.getValue("is_login", false) == true) {
                    status = true
        }

        return status

    }

}