package com.sebastian.iot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val UserData = Data()
        UserData.username = "Poggers"
        var elboton: Button = findViewById(R.id.login_button_login)
        elboton.setOnClickListener(View.OnClickListener {
            val intent  = Intent(this, MenuActivity::class.java).apply {
                putExtra("datos", UserData.username)
            }
            startActivity(intent)
        })
    }
    class Data{
        var username = ""
        var password = ""
        var email = ""
        @JvmName("setName")
        fun setName(usernameData:String){
            if (!usernameData.equals(""))
                this.username = usernameData
        }
        @JvmName("getName")
        fun getName():String{
            return(this.username)
        }
    }
}
