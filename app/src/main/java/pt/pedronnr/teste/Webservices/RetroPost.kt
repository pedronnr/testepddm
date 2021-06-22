package pt.pedronnr.teste.Webservices

import com.google.gson.annotations.SerializedName

data class RetroPost(@SerializedName("userId") val userId: String,
                     @SerializedName("id") val id: String,
                     @SerializedName("title") val title: String,
                     @SerializedName("body") val body: String) {
}

