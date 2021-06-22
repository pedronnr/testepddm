package pt.pedronnr.teste.SQLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class CommentsDataSource(context: Context?) {
    // Campos da base de dados
    private var database: SQLiteDatabase? = null
    private val dbHelper: CustomSQLiteHelper = CustomSQLiteHelper(context)
    private val allColumns = arrayOf(
        CustomSQLiteHelper.COLUMN_ID,
        CustomSQLiteHelper.COLUMN_COMMENT
    )

    fun open() {
        database = dbHelper.writableDatabase
    }

    fun close() {
        dbHelper.close()
    }

    fun createComment(comment: String?): Comment {
        val values = ContentValues()
        values.put(CustomSQLiteHelper.COLUMN_COMMENT, comment)
        val insertId = database!!.insert(
            CustomSQLiteHelper.TABLE_COMMENTS, null,
            values
        )
        val cursor: Cursor = database!!.query(
            CustomSQLiteHelper.TABLE_COMMENTS,
            allColumns, CustomSQLiteHelper.COLUMN_ID + " = " + insertId, null,
            null, null, null
        )
        cursor.moveToFirst()
        val newComment: Comment = cursorToComment(cursor)
        cursor.close()
        return newComment
    }

    fun deleteComment(comment: Comment) {
        val id = comment.id
        println("Comment deleted with id: $id")
        database!!.delete(
            CustomSQLiteHelper.TABLE_COMMENTS, CustomSQLiteHelper.COLUMN_ID
                    + " = " + id, null
        )
    }

    fun getAllComments(): List<Comment>? {
        val comments: MutableList<Comment> =
            ArrayList()
        val cursor = database!!.query(
            CustomSQLiteHelper.TABLE_COMMENTS,
            allColumns, null, null, null, null, null
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val comment = cursorToComment(cursor)
            comments.add(comment)
            cursor.moveToNext()
        }
        // make sure to close the cursor
        cursor.close()
        return comments
    }

    fun cursorToComment(cursor: Cursor): Comment {
        val comment = Comment()
        comment.id = cursor.getLong(0)
        comment.comment = cursor.getString(1)
        return comment
    }
}