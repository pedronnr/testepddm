package pt.pedronnr.teste.SQLite

import android.content.Context

class SQLLiteExample {

    fun getAllComments(context: Context) : List<Comment>? {
        val mDatasource = CommentsDataSource(context)
        mDatasource?.open()
        return mDatasource?.getAllComments()
    }
}