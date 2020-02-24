package com.livewire.app.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.livewire.app.R

class NotificationsFragment : Fragment() {

    companion object {
        fun newInstance(): NotificationsFragment {
            return NotificationsFragment()
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_notifications, container, false)!!

}
