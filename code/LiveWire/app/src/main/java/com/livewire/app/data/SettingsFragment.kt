package com.livewire.app.data

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.livewire.app.R
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.AuthorizationClient.createLoginActivityIntent
import android.content.Intent
import com.livewire.app.outwork.*

class SettingsFragment : Fragment() {
    private lateinit var spotifyBtn: Button

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("test3", "[run4] LoginActivity returning result")
        if (requestCode == AUTH_TOKEN_REQUEST_CODE) {
            Log.d("test3", "[run5] Requesting token")
            loginActivityResult(resultCode, data!!)

            }
        }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        spotifyBtn = view.findViewById(R.id.spotifyplug)

        fun requestAuthorization() {
            val request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN)
            Log.d("test3", "[run3] Created request, making login activity")
            val intent = createLoginActivityIntent(activity, request)
            startActivityForResult(intent, AUTH_TOKEN_REQUEST_CODE)
        }
        spotifyBtn.setOnClickListener {
            Log.d("test3", "[run1] Button pressed, requesting authorization")
            //1.1 App requests authorization to access data
            // 1.2 Spotify sends login propmt and scopes to user
            // 1.3 User logs in, sends back code and state to App
            //2.1. App requests access and refresh tokens
            // 2.2 Spotify Return access and refresh tokens
            //3.1 App uses access token in requests to Web API
            // 3.2 Spotify returns requested data
            // 3.3 Spotify returns new access token

            requestAuthorization()
        }
        return view
    }
}