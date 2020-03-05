package com.livewire.app.data

import com.livewire.app.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.locallistview.view.*


class RecyclerViewAdapter(val artists : ArrayList<String>, val locations : ArrayList<String>, val pricerange : ArrayList<String>, val startdate:ArrayList<String>,val starttime:ArrayList<String>, val status:ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
         Log.println(Log.ASSERT,"itemcount",artists.size.toString() )
        return artists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.locallistview, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mArtists?.text = artists[position]
        holder.mLocations?.text = locations[position]
        holder.mPricerange?.text = pricerange[position]
        holder.mStartdate?.text = startdate[position]
        holder.mStarttime?.text = starttime[position]
        holder.mStatus?.text = status[position]
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val mArtists = view.artistslocal
    val mLocations = view.locationslocal
    val mPricerange = view.pricerangelocal
    val mStartdate = view.startdatelocal
    val mStarttime = view.starttimelocal
    val mStatus = view.statuslocal
}