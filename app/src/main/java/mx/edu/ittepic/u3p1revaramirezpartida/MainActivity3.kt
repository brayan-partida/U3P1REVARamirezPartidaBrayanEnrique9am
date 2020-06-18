package mx.edu.ittepic.u3p1revaramirezpartida

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    var id = ""
    var basedatos = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        var extras = intent.extras

        id = extras!!.getString("id").toString()
        txtNombre2.setText(extras.getString("nombre"))
        txtDomicilio2.setText(extras.getString("domicilio"))
        txtCarrera2.setText(extras.getString("carrera"))
        txtSueldo2.setText(extras.getString("sueldo"))
        txtAntiguedad2.setText(extras.getString("antiguedad"))
        txtFecha2.setText(extras.getString("fecha"))



        btnActualizar2.setOnClickListener {
            basedatos.collection("evento").document(id)
                .update(
                    "nombre", txtNombre2.text.toString(),
                    "domicilio", txtDomicilio2.text.toString(),
                    "carrera", txtCarrera2.text.toString(),
                    "sueldo", txtSueldo2.text.toString(),
                    "antiguedad", txtAntiguedad2.text.toString(),
                    "fecha", txtFecha2.text.toString()

                )

                .addOnSuccessListener {
                    Toast.makeText(this, "se actualizo", Toast.LENGTH_LONG).show()
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this, "no se actualizo", Toast.LENGTH_LONG).show()
                    finish()
                }//falla
        }
    }
}