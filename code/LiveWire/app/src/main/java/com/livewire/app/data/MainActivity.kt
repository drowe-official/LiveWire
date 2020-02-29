package com.livewire.app.data

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.livewire.app.R



class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var auth: FirebaseAuth
    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var mainPagerAdapter: MainPagerAdapter
    lateinit var databaseReference: DatabaseReference

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                super.onActivityResult(requestCode, resultCode, data)
            }
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                auth = FirebaseAuth.getInstance()

                if (auth.currentUser == null) {
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
            Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show()
        }

        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)

        // Set items to be displayed.
        mainPagerAdapter.setItems(
            arrayListOf(
                MainScreen.HOME,
                MainScreen.PROFILE,
                MainScreen.LOCAL,
                MainScreen.NOTIFICATIONS,
                MainScreen.SETTINGS

            )
        )

        // Show the default screen.
        val defaultScreen = MainScreen.HOME
        scrollToScreen(defaultScreen)
        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
        supportActionBar?.setTitle(defaultScreen.titleStringId)

        // Set the listener for item selection in the bottom navigation view.
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        // Attach an adapter to the view pager and make it select the bottom navigation
        // menu item and change the title to proper values when selected.
        viewPager.adapter = mainPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedScreen = mainPagerAdapter.getItems()[position]
                selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })
    }



    /**
        * Scrolls `ViewPager` to show the provided screen.
        */
        private fun scrollToScreen(mainScreen: MainScreen) {
            val screenPosition = mainPagerAdapter.getItems().indexOf(mainScreen)
            if (screenPosition != viewPager.currentItem) {
                viewPager.currentItem = screenPosition
            }
    }

    /**
     * Selects the specified item in the bottom navigation view.
     */
    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        bottomNavigationView.setOnNavigationItemSelectedListener(null)
        bottomNavigationView.selectedItemId = menuItemId
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    /**
     * Listener implementation for registering bottom navigation clicks.
     */
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        getMainScreenForMenuItem(menuItem.itemId)?.let {
            scrollToScreen(it)
            supportActionBar?.setTitle(it.titleStringId)
            return true
        }
        return false
    }

    fun jump_To_Noti_Pref(view: View) {

    }

    fun jump_to_feed_pref(view: View) {


    }

    fun locationallow(view: View) {
        startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
    }

    fun faceplug(view: View) {

    }

    fun back(){
        val v= findViewById<View>(R.id.relativeLayout)
        v.visibility= VISIBLE
        onBackPressed()
    }
}
