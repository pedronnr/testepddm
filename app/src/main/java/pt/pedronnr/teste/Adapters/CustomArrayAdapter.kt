package pt.pedronnr.teste.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.pedronnr.teste.Models.Team
import pt.pedronnr.teste.R

class CustomArrayAdapter(context: Context, teams: MutableList<Team>) : ArrayAdapter<Team>(context, -1) {
    private val mResource: Int = R.layout.simplelistitem
    private val mContext: Context = context
    private val mTeams: MutableList<Team> = teams

    override fun getItem(position: Int): Team? {
        return mTeams[position]
    }

    override fun getCount(): Int {
        return mTeams.count()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /*
        // INIT Reutilizacao 1
        val rowView = convertView ?: LayoutInflater.from(mContext).inflate(mResource, parent, false)
        val tvCLIName = rowView.findViewById<TextView>(R.id.tvCustomListItemName)
        val tvCLIRating = rowView.findViewById<TextView>(R.id.tvCustomListItemRating)

        val currentTeam = mTeams[position]
        tvCLIName.text = currentTeam.name
        tvCLIRating.text = currentTeam.rating.toString()
        // END
        */

        // INIT Reutilizacao 2
        val rowView: View
        val viewHolder: MyViewHolder

        if (convertView != null) {
            rowView = convertView
        } else {
            rowView = LayoutInflater.from(mContext).inflate(mResource, parent, false)
            rowView.tag = MyViewHolder(rowView)
        }
        viewHolder = rowView.tag as MyViewHolder

        val currentTeam = mTeams[position]
        viewHolder.tvCLIName?.text = currentTeam.name
        viewHolder.tvCLIRating?.text = currentTeam.rating.toString()
        // END

        return super.getView(position, convertView, parent)
    }

    private class MyViewHolder(view: View?) {
        val tvCLIName = view?.findViewById<TextView>(R.id.tvCustomListItemName)
        val tvCLIRating = view?.findViewById<TextView>(R.id.tvCustomListItemRating)
    }
}