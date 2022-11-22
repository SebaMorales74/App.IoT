package com.sebastian.iot

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyDBHelper(applicationContext)
        var db = helper.readableDatabase

        val userData = Data()

        val usernameInput: EditText = findViewById(R.id.login_input_name)
        val passwordInput: EditText = findViewById(R.id.login_input_password)

        var botonSubmit: Button = findViewById(R.id.login_button_login)
        botonSubmit.setOnClickListener(View.OnClickListener {
            userData.setName(usernameInput.text.toString())
            userData.setPass(passwordInput.text.toString())
            var rs = db.rawQuery(
                "SELECT * FROM USUARIOS WHERE " +
                        "username=${userData.getName()}" +
                    " AND " +
                        "password=${userData.getPass()}",
                null
            )
            if (rs.moveToNext()) {
                var intent = Intent(this, MenuActivity::class.java).apply {
                    putExtra("datos", "correcto")
                }
                startActivity(intent)
            }
            else{
                var intent = Intent(this, MenuActivity::class.java).apply {
                    putExtra("datos", "incorrecto")
                }
                startActivity(intent)
            }
        })
    }

    class Data{

        private var username = ""
        private var password = ""

        fun setName(usernameData:String){
            if (";" !in usernameData || usernameData == "") this.username = usernameData
            else this.username = "!Failed"}

        fun setPass(passwordData:String){
            if (";" !in passwordData || passwordData == "") this.password = passwordData
            else this.password = "!Failed" }

        fun getName():String{ return(this.username) }
        fun getPass():String{ return(this.password) }

    }
}
