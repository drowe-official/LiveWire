package com.livewire.app.data

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.livewire.app.R

class MakePost : Fragment() {

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view: View = inflater.inflate(R.layout.fragment_post, container, false)
        var context: Context? = container?.context
        val button: Button = view.findViewById(R.id.back)

        button.setOnClickListener{
            val transaction: FragmentTransaction = fragmentManager!!
                .beginTransaction()
            /*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */
            /*
		 * When this container fragment is created, we fill it with our first
		 * "real" fragment
		 */ transaction.replace(R.id.post_frag, ProfileFragment())

            transaction.commit()
            view.visibility = View.GONE
        }
        return view


    }


}