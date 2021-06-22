package pt.pedronnr.teste.SQLiteORM

import android.content.Context
import androidx.room.Room

class SQLiteORMExample {

    fun getAllComments(context: Context) : List<Comment> {
        // Creates the database
        val db = CommentDatabase.invoke(context)

        return db.commentDao().getAll()
    }
}