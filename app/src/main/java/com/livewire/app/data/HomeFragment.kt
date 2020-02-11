package com.livewire.livewire.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.livewire.app.R

class HomeFragment : Fragment() {

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }
class MainActivity : AppCompatActivity(), BottomNcom.livewire.app.dataavigationView.OnNavigationItemSelectedListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_home, container, false)!!

}
