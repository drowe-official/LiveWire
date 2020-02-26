package com.livewire.app.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.*
import com.livewire.app.R


class LocalFragment : Fragment() {

    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var ref: DocumentReference = db.document("test/test")
    private var ARTISTS_KEY:String = "test"
    lateinit var textView: TextView



    //override fun onStart() {
        //super.onStart()
        //ref.addSnapshotListener(MainActivity(), EventListener<DocumentSnapshot>{
            //documentSnapshot: DocumentSnapshot?,
            //firebaseFirestoreException: FirebaseFirestoreException?->
            //val myData Map<String, object> =  documentSnapshot.getData()

        //})
    //}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_local, container, false)
        textView = view.findViewById(R.id.artistslocal)

        //view.setOnClickListener {
        //    Log.d("btnSetup", "Selected")
        //}
        db
        ref
        ARTISTS_KEY

        var context = context
        var arrayList = ArrayList<Events>()

        val artiststext = "onCreate"
        textView.setText(artiststext)

        fetch(view)




        return view

    }
    fun fetch(view: View){
        ref.get().addOnSuccessListener { documentSnapshot ->
            if (documentSnapshot.exists()) {
                //var artiststext = documentSnapshot.toObject(Events::class.java)
            } else{
                val artiststext = "else"
                textView.setText(artiststext)
            }
        }
    }
}