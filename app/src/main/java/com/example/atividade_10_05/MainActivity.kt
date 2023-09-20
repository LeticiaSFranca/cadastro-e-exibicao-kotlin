package com.example.atividade_10_05

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nome : EditText
    lateinit var cpf : EditText
    lateinit var email : EditText
    lateinit var senha : EditText

    lateinit var tNome : TextView
    lateinit var tCpf : TextView
    lateinit var tEmail : TextView
    lateinit var tSenha : TextView

    lateinit var add : Button
    lateinit var load : Button

    lateinit var share : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nome = findViewById(R.id.edtNome)
        cpf = findViewById(R.id.edtCPF)
        email = findViewById(R.id.edtEmail)
        senha = findViewById(R.id.edtSenha)

        add = findViewById(R.id.btnADD)
        load = findViewById(R.id.btnLOAD)

        tNome = findViewById(R.id.txtNome)
        tCpf = findViewById(R.id.txtCPF)
        tEmail = findViewById(R.id.txtEmail)
        tSenha = findViewById(R.id.txtSenha)

        share = getSharedPreferences("Dados", Context.MODE_PRIVATE)
        add.setOnClickListener{
            val editar = share.edit()
            editar.apply{
                putString("Nome", nome.text.toString())
                putString("CPF", cpf.text.toString())
                putString("EMAIL", email.text.toString())
                putString("SENHA", senha.text.toString())
                apply()
            }
        }

        load.setOnClickListener {
            val nome = share.getString("Nome", null)
            val cpf = share.getString("CPF", null)
            val email = share.getString("EMAIL", null)
            val senha = share.getString("SENHA", null)

            tNome.setText(nome)
            tCpf.setText(cpf)
            tEmail.setText(email)
            tSenha.setText(senha)
        }
    }
}