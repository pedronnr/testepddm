package pt.pedronnr.teste.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import pt.pedronnr.teste.Models.Team
import pt.pedronnr.teste.R

class CustomRecyclerViewAdapter(context: Context, teams: MutableList<Team>) : Adapter<CustomRecyclerViewHolder>() {
    val mContext = context
    val mTeams = teams

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CustomRecyclerViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CustomRecyclerViewHolder, position: Int) {
        holder.bindData(mTeams[position])
    }

    override fun getItemCount(): Int {
        return mTeams.size
    }
}

class CustomRecyclerViewHolder(inflater: LayoutInflater, private val parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.customlistitem, parent, false)) {
    private var tvCLIName: TextView? = itemView.findViewById(R.id.tvCustomListItemName)
    private var tvCLIRating: TextView? = itemView.findViewById(R.id.tvCustomListItemRating)

    fun bindData(team: Team) {
        tvCLIName?.text = team.name
        tvCLIRating?.text = team.rating.toString()

        itemView.setOnClickListener {
            Toast.makeText(parent.context, team.name, Toast.LENGTH_LONG).show()
        }
    }
}