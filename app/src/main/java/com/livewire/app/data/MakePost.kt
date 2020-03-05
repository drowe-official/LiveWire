package com.livewire.app.data

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.storage.UploadTask
import com.livewire.app.R
import java.util.*
import android.net.Uri
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference


class MakePost : Fragment() {

    private var filePath: Uri? = null
    private val PICK_IMAGE_REQUEST = 22
    var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_post, container, false)
        container?.context
        val backBtn: Button = view.findViewById(R.id.back)
        val postTxt: Button = view.findViewById(R.id.posttxt)
        val imageBtn: Button = view.findViewById(R.id.imagebtn)
        val postBtn: Button = view.findViewById(R.id.post)
        storageReference = storage!!.reference
        var txt: String? = null

        backBtn.setOnClickListener {
            val transaction: FragmentTransaction = fragmentManager!!
                    .beginTransaction()
            transaction.commit()
            view.visibility = View.GONE
        }

        postTxt.setOnClickListener {
            txt = postTxt.text.toString()
        }

        imageBtn.setOnClickListener {
            selectImage()
        }

        postBtn.setOnClickListener {

        }
        return view

    }

    private fun selectImage() { // Defining Implicit Intent to mobile gallery
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST)
    }

    private fun uploadImage() {
        if (filePath != null) { // Code for showing progressDialog while uploading
            val progressDialog = ProgressDialog(context)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
            // Defining the child of storageReference
            val ref = storageReference?.child("images/"
                    + UUID.randomUUID().toString())
            // adding listeners on upload
// or failure of image
            ref?.putFile(filePath!!)?.addOnSuccessListener {
                // Image uploaded successfully
                // Dismiss dialog
                progressDialog.dismiss()
                Toast
                        .makeText(context,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT)
                        .show()
            }?.addOnFailureListener { e: Exception ->
                // Error, Image not uploaded
                progressDialog.dismiss()
                Toast
                        .makeText(context,
                                "Failed " + e.message,
                                Toast.LENGTH_SHORT)
                        .show()
            }?.addOnProgressListener { taskSnapshot: UploadTask.TaskSnapshot ->
                // Progress Listener for loading
                // percentage on the dialog box
                val progress = (100.0
                        * taskSnapshot.bytesTransferred
                        / taskSnapshot.totalByteCount)
                progressDialog.setMessage(
                        "Uploaded "
                                + progress.toInt() + "%")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) { // Get the Uri of data
            filePath = data.data
            Log.d("test2", filePath.toString())
        }
    }

}
