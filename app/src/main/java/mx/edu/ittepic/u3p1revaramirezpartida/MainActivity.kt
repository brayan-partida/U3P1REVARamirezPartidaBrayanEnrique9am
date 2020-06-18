package mx.edu.ittepic.u3p1revaramirezpartida

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var baseDatos = FirebaseFirestore.getInstance()
    var dataLista = ArrayList<String>()
    var listaId = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIngresar.setOnClickListener {
            Ingresar()
            limpiar()
        }


    }//todo------------------OnCreate---------------------->


    fun Ingresar() {
        val ingresar = Intent(this, MainActivity2::class.java)

        startActivity(ingresar)


    }//todo--------------------Ingresar--------------------->


    fun limpiar() {
        txtUsuario.setText("")
        txtPassword.setText("")

    }
}