package pt.pedronnr.teste.SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class CustomSQLiteHelper(context: Context?) : SQLiteOpenHelper(
context,
DATABASE_NAME,
null,
DATABASE_VERSION
) {
    override fun onCreate(database: SQLiteDatabase) {
        database.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        Log.w(
            CustomSQLiteHelper::class.java.name,
            "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data"
        )
        db.execSQL("DROP TABLE IF EXISTS $TABLE_COMMENTS")
        onCreate(db)
    }

    companion object {
        const val TABLE_COMMENTS = "comments"
        const val COLUMN_ID = "_id"
        const val COLUMN_COMMENT = "comment"
        private const val DATABASE_NAME = "comments.db"
        private const val DATABASE_VERSION = 1

        // String de criação da base de dados
        private const val DATABASE_CREATE = ("create table "
                + TABLE_COMMENTS + "( " + COLUMN_ID
                + " integer primary key autoincrement, " + COLUMN_COMMENT
                + " text not null);")
    }
}