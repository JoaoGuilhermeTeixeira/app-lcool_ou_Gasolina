package com.joaoguilhermeteixeira.lcoolougasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText


    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        incializarComponentesInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }



    private fun calcularMelhorPreco() {
        val precoAlcool  = editAlcool.text.toString()
        val precoGasolina  = editGasolina.text.toString()
        
        val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)
        if (resultadoValidacao){

            val resultado = (precoAlcool.toDouble() / precoGasolina.toDouble())

            if (resultado >= 0.7){
                textResultado.text = "Melhor utilizar Gasolina"
            }else{
                textResultado.text = "Melhor utilizar Álcool"
            }
        }
    }



    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if (pAlcool.isEmpty() && pGasolina.isEmpty()){

            textInputAlcool.error = "Digite o preço do álcool"
            textInputGasolina.error = "Digite o preço da gasolina"

            return false

        }

        return true
    }


    private fun incializarComponentesInterface() {

        textInputAlcool = findViewById(R.id.text_Input_Álcool)
        editAlcool = findViewById(R.id.edit_Álcool)

        textInputGasolina = findViewById(R.id.text_Input_Gasolina)
        editGasolina = findViewById(R.id.edit_Gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)



    }
}