package pt.pedronnr.teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import pt.pedronnr.teste.Adapters.CustomArrayAdapter
import pt.pedronnr.teste.Adapters.CustomRecyclerViewAdapter
import pt.pedronnr.teste.Adapters.SimpleArrayAdapter
import pt.pedronnr.teste.Models.Team

class RecyclerViewExample : AppCompatActivity() {
    private lateinit var rvTeams: RecyclerView
    private lateinit var spinTeams: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_example)

        rvTeams = findViewById(R.id.rvTeams)

        // Custom Recycler View
        val teams = mutableListOf(
            Team("Portugal", 3),
            Team("Alemanha", 6),
            Team("França", 4),
            Team("Hungria", 1)
        )

        val customAdapter = CustomRecyclerViewAdapter(this, teams)
        rvTeams.adapter = customAdapter


        // Spinner
        spinTeams = findViewById(R.id.spinTeams)
        spinTeams.adapter = ArrayAdapter(this, R.layout.simplelistitem, listOf("Marilda", "Pedro", "Abel"))
    }
}