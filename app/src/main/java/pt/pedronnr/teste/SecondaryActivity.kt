package pt.pedronnr.teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SecondaryActivity : AppCompatActivity() {
    private var email: String? = null
    private lateinit var btnClose: Button
    private lateinit var edtName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        btnClose = findViewById(R.id.btnClose)
        edtName = findViewById(R.id.edtName)

        email = intent.getStringExtra("email")

        if (email != null) {
            btnClose.text = email
        }
    }

    fun btnCloseOnClick(view: View) {
        val intent = Intent()
        intent.putExtra("name", edtName.text)
        setResult(RESULT_OK, intent)
        finish()
    }
}