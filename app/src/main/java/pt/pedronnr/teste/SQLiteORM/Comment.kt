package pt.pedronnr.teste.SQLiteORM

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class Comment(@PrimaryKey(autoGenerate = true) val id: Int = 0, @ColumnInfo(name = "comment") val comment: String) {
}