package mx.edu.ittepic.u3p1revaramirezpartida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main4.*

enum class ProviderType {
    Basic
}

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
//todo(setup)
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")


    }//todo--------------->onCreate<----------------------


  private  fun setup(email: String, provider: String) {
        title = "Inicio"
         // txtEmail2!!.text=email
        //txtPassword2!!.text = provider

    }//todo----------setup--------------------->
}