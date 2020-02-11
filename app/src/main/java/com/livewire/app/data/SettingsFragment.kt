package com.livewire.livewire.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.livewire.livewire.R

class SettingsFragment : Fragment() {

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_settings, container, false)!!

}
