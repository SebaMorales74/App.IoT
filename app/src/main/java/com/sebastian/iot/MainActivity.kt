package com.sebastian.iot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userData = Data()
        var botonSubmit: Button = findViewById(R.id.login_button_login)
        val usernameInput: EditText = findViewById(R.id.login_input_name)
        val passwordInput: EditText = findViewById(R.id.login_input_password)
        val emailInput: EditText = findViewById(R.id.login_input_email)

        botonSubmit.setOnClickListener(View.OnClickListener {
            userData.setName(usernameInput.text.toString())
            userData.setPass(passwordInput.text.toString())
            userData.setCorreo(emailInput.text.toString())
            val intent  = Intent(this, MenuActivity::class.java).apply {
                putExtra("datos", userData.getAll())
            }
            startActivity(intent)
        })

    }

    class Data{

        private var username = ""
        private var password = ""
        private var email = ""

        //Get n Set Nombre
        fun setName(usernameData:String){
            if (";" !in usernameData || usernameData == "") this.username = usernameData
            else this.username = "!Failed"}

        fun getName():String{ return(this.username) }

        //Get n Set Password
        fun setPass(passwordData:String){
            if (";" !in passwordData || passwordData == "") this.password = passwordData
            else this.password = "!Failed" }
        fun getPass():String{ return(this.password) }

        //Get n Set Email
        fun setCorreo(emailData:String){
            if (";" !in emailData) this.email = emailData
            else this.email = "!Failed" }
        fun getCorreo():String { return(this.email) }

        //Get all data
        fun getAll():String{ return(this.username+";"+this.password+";"+this.email) }

    }
}
