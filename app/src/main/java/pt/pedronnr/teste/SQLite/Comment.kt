package pt.pedronnr.teste.SQLite

class Comment {
    var id: Long = 0
    var comment: String? = null
    override fun toString(): String {
        return comment!!
    }
}