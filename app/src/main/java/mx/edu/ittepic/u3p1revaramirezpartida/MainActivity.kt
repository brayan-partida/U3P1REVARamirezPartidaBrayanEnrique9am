package mx.edu.ittepic.u3p1revaramirezpartida

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var baseDatos = FirebaseFirestore.getInstance()
    var dataLista = ArrayList<String>()
    var listaId = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alerta("Antes de Registrarte Recuerda tener \n tner una direccion valida")
        btnIngresar.setOnClickListener {
            Ingresar()
            //limpiar()
        }

        btnRegistrar.setOnClickListener {
            Registrar()
            limpiar()
        }


    }//todo------------------OnCreate---------------------->


    fun Ingresar() {


        title = "authentication"
        if (txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(
                    txtEmail.text.toString(),
                    txtPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {

                        val ingresar = Intent(this, MainActivity2::class.java)

                        startActivity(ingresar)

                    }//if
                    else {
                        alerta("no estas registrado, registrate o \n ya estas registrado")
                    }//else
                }

        }


    }//todo--------------------Ingresar--------------------->

    fun Registrar() {


        title = "authentication"
        if (txtEmail.text.isNotEmpty() && txtPassword.text.isNotEmpty()) {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                txtEmail.text.toString(),
                txtPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {

                    alerta("se registro")
                }//if
                else {
                    alerta("no estas, registrado registrate")
                }//else
            }

        }


        // val ingresar = Intent(this, MainActivity4::class.java)

//        startActivity(ingresar)


    }//todo--------------------Registrar--------------------->


    fun limpiar() {
        txtEmail.setText("")
        txtPassword.setText("")

    }//todo------------------Limpiar------------------------>

    fun alerta(alerta: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alerta")
        builder.setMessage(alerta)
        builder.setPositiveButton("aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }//todo:----------------Alerta-------------------------->

    fun showHome(email: String, provider: ProviderType) {
        val homeIntent: Intent = Intent(this, MainActivity4::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)

        }
        startActivity(homeIntent)
    }//todo----------------------showHome-------------------->
}