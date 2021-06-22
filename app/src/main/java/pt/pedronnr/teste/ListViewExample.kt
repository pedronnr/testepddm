package pt.pedronnr.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import pt.pedronnr.teste.Adapters.CustomArrayAdapter
import pt.pedronnr.teste.Adapters.SimpleArrayAdapter
import pt.pedronnr.teste.Models.Team

class ListViewExample : AppCompatActivity() {
    private lateinit var lvNames: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_example)

        // Simple list item
        val names = mutableListOf("Marilda", "Pedro", "Abel")
        lvNames = findViewById(R.id.lvNames)

        var simpleArrayAdapter = ArrayAdapter(this, R.layout.simplelistitem, names)
        val simpleAdapter = SimpleArrayAdapter(this, names)
        lvNames.adapter = simpleAdapter


        // Custom list item
        val teams = mutableListOf(
            Team("Portugal", 3),
            Team("Alemanha", 6),
            Team("França", 4),
            Team("Hungria", 1))

        lvNames = findViewById(R.id.lvNames)

        val customAdapter = CustomArrayAdapter(this, teams)
        lvNames.adapter = customAdapter
    }
}