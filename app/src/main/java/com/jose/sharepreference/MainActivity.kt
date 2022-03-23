package com.jose.sharepreference


import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.jose.sharepreference.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences("login",Context.MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val oriString = "tutorial"
        val encodedString: String = Base64.getEncoder().encodeToString(oriString.toByteArray())


        val codificada = "dHV0b3JpYWw="
        val decodedBytes = Base64.getDecoder().decode(encodedString)
        val decodedString = String(decodedBytes)
        //binding.respuesta.text=decodedString


        binding.btnEnviar.setOnClickListener {
            if(binding.verificar.isChecked){
                val editor = sharedPreferences.edit()
                editor.putString("usuario","adsi")
                editor.putString("clave","2022")
                editor.apply()
            }
        }
        binding.btnValidar.setOnClickListener {
            val usuario = sharedPreferences.getString("usuario","")
            val clve = sharedPreferences.getString("clave","")
            val user = binding.username.text.toString()
            val password = binding.pws.text.toString()

            if (usuario.equals(user)) {
                binding.respuesta.text = "nombre de usuario: $user"
            }else{
                binding.respuesta.text = ""
            }
        }


    }




}