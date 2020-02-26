package com.livewire.app.outwork

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.spotify.sdk.android.auth.AccountsQueryParameters

import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException
import java.util.Locale

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

val CLIENT_ID = "089d841ccc194c10a77afad9e1c11d54"
    val AUTH_TOKEN_REQUEST_CODE = 0x10
    val AUTH_CODE_REQUEST_CODE = 0x11

    private val mOkHttpClient = OkHttpClient()
    private var mAccessToken: String? = null
    private var mAccessCode: String? = null
    private var mCall: Call? = null

fun loginActivityResult(requestCode: Int, resultCode: Int, data: Intent): String {

    val response = AuthorizationClient.getResponse(resultCode, data)
    return response.getAccessToken()
}

fun getAuthenticationRequest(type: AuthorizationResponse.Type): AuthorizationRequest {
    return AuthorizationRequest.Builder(
        AccountsQueryParameters.CLIENT_ID,
        type,
        getRedirectUri().toString()
    )
        .setShowDialog(false)
        .setScopes(arrayOf("user-read-email"))
        .setCampaign("your-campaign-token")
        .build()
}

fun cancelCall() {
    if (mCall != null) {
        mCall!!.cancel()
    }
}

fun getRedirectUri(): Uri {
    return Uri.Builder()
        .scheme("spotify-sdk")
        .authority("auth")
        .build()
}