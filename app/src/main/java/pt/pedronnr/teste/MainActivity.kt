package pt.pedronnr.teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private val requestSecActivityCode = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
    }

    /**
     * Authenticate user
     */
    fun btnAuthenticateOnClick(view: View) {
        if (edtEmail.text.trim().isNullOrEmpty() && edtPassword.text.trim().isNullOrEmpty()) {
            Toast.makeText(this, "Preencha email e password.", Toast.LENGTH_SHORT)
            return
        }

        if (edtEmail.text.equals("admin") && edtPassword.text.equals("pass")) {
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("email", edtEmail.text)
            startActivityForResult(intent, requestSecActivityCode)
            //startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == requestSecActivityCode) {
            if (resultCode == RESULT_OK) {
                val name = data?.getStringExtra("name")
                if (name != null) {
                    Toast.makeText(this, name, Toast.LENGTH_LONG)
                }
            }
        }
    }
}