package nha.tmn.tromyno.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import nha.tmn.tromyno.R

class WelcomeActivity : AppCompatActivity() {
    lateinit var loginBtn: Button
    lateinit var registerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        loginBtn = findViewById(R.id.loginBtn)
        registerBtn = findViewById(R.id.registerBtn)

        loginBtn.setOnClickListener {
            toLoginScreen()
        }
    }

    private fun toLoginScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}