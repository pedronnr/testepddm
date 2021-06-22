package pt.pedronnr.teste.Utils

import org.json.JSONObject

class Post {
    var userId : String = ""
    var id : String = ""
    var title : String = ""
    var body : String = ""

    constructor() {

    }

    fun ImportJson(jsonObj : JSONObject) : Post {
        userId = jsonObj.getString("userId")
        id = jsonObj.getString("id")
        title = jsonObj.getString("title")
        body = jsonObj.getString("body")
        return this
    }
}
