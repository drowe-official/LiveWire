package com.livewire.app.data
data class Events(var artists: String, var locations: ArrayList<String>, var pricerange: ArrayList<String>, var startdate: String, var starttime:String, var status:String) {
    constructor() : this("artists",ArrayList<String>(), ArrayList<String>(), "", "", "")

}



