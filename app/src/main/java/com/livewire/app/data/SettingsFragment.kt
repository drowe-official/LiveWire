package com.livewire.app.data

import android.os.Bundle
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

        if (requestCode == AUTH_TOKEN_REQUEST_CODE) {
            loginActivityResult(resultCode, data!!)

        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_settings, container, false)
        spotifyBtn = view.findViewById(R.id.spotifyplug)

        spotifyBtn.setOnClickListener {
            val request = getAuthenticationRequest(AuthorizationResponse.Type.TOKEN)
            val intent = createLoginActivityIntent(activity, request)
            startActivityForResult(intent, AUTH_TOKEN_REQUEST_CODE)
        }
        return view
    }
}