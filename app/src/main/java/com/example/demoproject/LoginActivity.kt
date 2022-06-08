package com.example.demoproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(LoginActivityViewModel::class.java)

        viewModel.authenticatedUser.observe(this, Observer {
            val i = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(i)
            finish()
        })
        viewModel.msg.observe(this, Observer {
            Toast.makeText(this, it.toString(), LENGTH_SHORT).show()

        })
        log_in_btn.setOnClickListener {

            viewModel.getResponse(
                email_edit_text.text.toString(),
                password_edit_text.text.toString(), applicationContext
            )
        }
    }
}