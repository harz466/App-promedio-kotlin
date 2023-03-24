package com.example.first_project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnAppPromedio:Button= findViewById(R.id.btnApp)
        btnAppPromedio.setOnClickListener { onClick(1) }

        var txtpromedio:TextView = findViewById(R.id.resultado)
        var miBundle:Bundle? =this.intent.extras
        if(miBundle != null){
            txtpromedio.text="${miBundle.getString("Mensaje")}"
        }
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private fun onClick(boton:Int){
        when(boton){
            1 ->{
                val intent = Intent(this,promedioNotas::class.java)
                startActivity(intent)
            }
        }

    }

}
