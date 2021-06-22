package pt.pedronnr.teste.SQLite

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cursoradapter.widget.CursorAdapter
import pt.pedronnr.teste.R

class CommentsCursorAdapter(context: Context?, cursor: Cursor?) : CursorAdapter(context, cursor, 0) {

    override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.simplelistitem, parent, false)
    }

    override fun bindView(view: View, context: Context?, cursor: Cursor?) {
        val commentsDataSource = CommentsDataSource(context)

        val tvComment = view.findViewById(R.id.tvSimpleListItemName) as TextView
        if (cursor == null) {
            return
        }

        val comment: Comment? = commentsDataSource.cursorToComment(cursor)
        tvComment.text = comment.toString()
    }
}