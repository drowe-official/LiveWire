package com.livewire.app.data

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.livewire.app.R
import com.spotify.sdk.android.auth.AccountsQueryParameters.CLIENT_ID
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity.REQUEST_CODE
import androidx.core.app.ActivityCompat.startActivityForResult
import com.spotify.sdk.android.auth.AuthorizationClient.createLoginActivityIntent
import android.content.Intent
import com.livewire.app.outwork.*


class SettingsFragment : Fragment() {
    private lateinit var spotifyBtn: Button


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        spotifyBtn = view.findViewById(R.id.spotifyplug)
        spotifyBtn.setOnClickListener {

            //1.1 App requests authorization to access data
            // 1.2 Spotify sends login propmt and scopes to user
            // 1.3 User logs in, sends back code and state
            //2.1. App requests access and refresh tokens
            // 2.2 Spotify Return access and refresh tokens
            //3.1 App uses access token in requests to Web API
            // 3.2 Spotify returns requested data
            // 3.3 Spotify returns new access token
        }
        fun requestAuthorization() {
            val request = getAuthenticationRequest(AuthorizationResponse.Type.CODE)
            val intent = createLoginActivityIntent(activity, request)
            startActivityForResult(intent, REQUEST_CODE)
        }

        return view
    }
     fun onActivityResult(requestCode: Int, resultCode: Int?, data: Intent) {
        if (requestCode == AUTH_TOKEN_REQUEST_CODE) {
            loginActivityResult(requestCode, resultCode!!, data)
        }

    }
}

