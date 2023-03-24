package com.example.first_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.first_project.R.color.green
import com.example.first_project.R.color.red

@Suppress("DEPRECATION")
class promedioNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio_notas)

        val btnCalcular:Button=findViewById(R.id.btnCalculate)
        btnCalcular.setOnClickListener{ onClick(1) }

        val btnVolver:Button=findViewById(R.id.btnReturn)
        btnVolver.setOnClickListener { onClick(2) }
    }

    private fun onClick(btn:Int){
        when(btn){
            1->{
                var txtnombreEstudiante:EditText= findViewById(R.id.txtStudentName)
                var nombreEstudiante:String= txtnombreEstudiante.text.toString()

                var txtMateria:EditText = findViewById(R.id.nameSubject)
                var materia:String= txtMateria.text.toString()

                var txtNota1:EditText= findViewById(R.id.note)
                var nota1:Double = txtNota1.text.toString().toDouble()
                var txtNota2:EditText= findViewById(R.id.note2)
                var nota2:Double = txtNota2.text.toString().toDouble()
                var txtNota3:EditText= findViewById(R.id.note3)
                var nota3:Double = txtNota3.text.toString().toDouble()

                var promedio: Double = (nota1+nota2+nota3)/3

                val txtResultado:TextView = findViewById(R.id.txtResult)

                var estado:String = ""

                if(promedio >= 3.5){
                    txtResultado.setBackgroundColor(resources.getColor(green));
                    estado = "APROBO la materia"
                }else{
                    txtResultado.setBackgroundColor(resources.getColor(red))
                    estado = "REPROBO la materia "
                }

                var resultado:String="Usted $nombreEstudiante obtuvo un promedio de $promedio en la materia $materia y $estado"

                txtResultado.text=resultado

                val intent = Intent(this,MainActivity::class.java)
                val miBundle:Bundle = Bundle()
                miBundle.putString("Mensaje", "$resultado" )
                intent.putExtras(miBundle)
                startActivity(intent)

            }

            2->{
                finish()
            }
        }
    }
}