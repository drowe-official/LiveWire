package com.livewire.app.data

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import com.livewire.app.R


class ProfileFragment : Fragment() {
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var ref: DocumentReference = db.document("listings/event-0002")
    private var artistsnames: ArrayList<String> = ArrayList()
    private var locationsnames: ArrayList<String> = ArrayList()
    private var prnames: ArrayList<String> = ArrayList()
    private var sdnames: ArrayList<String> = ArrayList()
    private var stnames: ArrayList<String> = ArrayList()
    private var statnames: ArrayList<String> = ArrayList()
    private var TAG: String = "LocalFragment"
    lateinit var textViewart: TextView
    lateinit var textViewloc: TextView
    lateinit var textViewpr: TextView
    lateinit var textViewsd: TextView
    lateinit var textViewst: TextView
    lateinit var textViewstat: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)
        val storage = FirebaseStorage.getInstance()
        val gsReference = storage.getReferenceFromUrl("gs://livewire-ca.appspot.com/uhoh.jpg")
        val imageView = view.findViewById<ImageView>(R.id.imageProfile)
        gsReference.downloadUrl.addOnSuccessListener { uri-> Glide.with(view.context).load(uri).apply(
            RequestOptions.circleCropTransform()).into(imageView)}
        var context: Context? = container?.context

        db.collectionGroup("listings").addSnapshotListener { querySnapshot: QuerySnapshot?, e: FirebaseFirestoreException? ->
            for (document in querySnapshot!!.documents) {
                if (document.exists()) {
                    var event = document.toObject(Events::class.java)
                    artistsnames.add(event!!.artists)
                    locationsnames.add("Venue:                                              "+event.locations.joinToString())
                    if (event.pricerange.isEmpty()){
                        prnames.add("Price: Free")
                    }
                    else{
                        prnames.add("Price: "+event.pricerange.joinToString())
                    }
                    sdnames.add(event.startdate)
                    stnames.add(event.starttime)
                    statnames.add(event.status)
                }
            }
        }

        Log.println(Log.ASSERT, "artistssize",artistsnames.size.toString())
        val recyclerView: RecyclerView = view.findViewById(R.id.listviewprofile)
        val adapter  = RecyclerViewAdapter(artistsnames, locationsnames, prnames, sdnames,stnames,statnames,context!!)

        recyclerView.setLayoutManager(LinearLayoutManager(context))
        Log.println(Log.ASSERT, "initRecyclerView","recycler")
        recyclerView.adapter = adapter
        val button:Button = view.findViewById(R.id.addbutton)
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
		 */ transaction.replace(R.id.profilefrag, MakePost())

            transaction.commit()
        }



        return view
    }
    override fun onStop() {
        super.onStop()
        artistsnames = ArrayList()
        locationsnames= ArrayList()
        prnames = ArrayList()
        sdnames = ArrayList()
        stnames = ArrayList()
        statnames = ArrayList()

    }

}

