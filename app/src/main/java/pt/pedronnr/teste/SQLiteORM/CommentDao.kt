package pt.pedronnr.teste.SQLiteORM

import androidx.room.*

@Dao
interface CommentDao {
    @Query("SELECT * FROM comments")
    fun getAll(): List<Comment>
    @Query("SELECT * FROM comments WHERE id = :id")
    fun findById(id: Int): Comment
    @Insert
    fun insertAll(vararg comment: Comment)
    @Delete
    fun delete(comment: Comment)
    @Update
    fun updateComment(vararg comment: Comment)
}