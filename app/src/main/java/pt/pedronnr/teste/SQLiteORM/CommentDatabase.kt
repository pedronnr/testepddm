package pt.pedronnr.teste.SQLiteORM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Comment::class], version = 1)
abstract class CommentDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile private var instance: CommentDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, CommentDatabase::class.java, "comments.db").build()
    }
}