package pt.pedronnr.teste.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import pt.pedronnr.teste.R

class SimpleArrayAdapter(context: Context, values: MutableList<String>) : ArrayAdapter<String>(context, R.layout.simplelistitem, values) {
    private val mResource: Int = R.layout.simplelistitem
    private val mContext: Context = context
    private val mValues: MutableList<String> = values

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = LayoutInflater.from(mContext).inflate(mResource, parent, false)
        val tvSLIName = rowView.findViewById<TextView>(R.id.tvSimpleListItemName)

        val currentName = mValues[position]
        tvSLIName.text = currentName

        return super.getView(position, convertView, parent)
    }
}