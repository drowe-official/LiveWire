package com.livewire.app.outwork


import android.content.Intent
import android.util.Log
import com.spotify.sdk.android.auth.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


const val AUTH_TOKEN_REQUEST_CODE = 55
var token: String? = null
const val CLIENT_ID = "030016c2c30245a5a3325ffe9065833a"

fun loginActivityResult(resultCode: Int, data: Intent) {
    val response = AuthorizationClient.getResponse(resultCode, data)
    Log.d("test3", "[run6] Getting response and updating access token")

    token = response.accessToken
    storeToken()
}

fun storeToken() {
    val uid = FirebaseAuth.getInstance().currentUser!!.uid
    val db = FirebaseFirestore.getInstance()
    val user = hashMapOf("SpotifyToken" to token)
    db.collection("users").document(uid).set(user)

}
fun getAuthenticationRequest(type: AuthorizationResponse.Type): AuthorizationRequest {
    Log.d("test3", "[run2] Building authorization request")
    return AuthorizationRequest.Builder(
            CLIENT_ID,
            type,"livewire-app://callback"
    )
            .setShowDialog(false)
            .setScopes(arrayOf("user-read-email"))
            .setCampaign("your-campaign-token")
            .build()
}