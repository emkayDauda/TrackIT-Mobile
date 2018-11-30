package com.askemkay.grid3.tracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.FragmentTransaction
import androidx.core.view.GravityCompat
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.askemkay.grid3.tracker.fragments.BeginOrder
import com.askemkay.grid3.tracker.fragments.CreateOrder
import com.askemkay.grid3.tracker.utils.ScreenSlidePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_type_fragment.*
import kotlinx.android.synthetic.main.create_order_fragment.*
import mehdi.sakout.fancybuttons.FancyButton

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)




        pager.adapter = ScreenSlidePagerAdapter(supportFragmentManager!!)

//        fancyButtonNext?.setOnClickListener { view ->
//            val radioButton = findViewById<RadioButton>(fancy_radio_group.checkedRadioButtonId)
//            Toast.makeText(this@MainActivity, radioButton.text, Toast.LENGTH_LONG).show()
//            Log.e("OkHttp", radioButton.text.toString())
//            Snackbar.make(view, radioButton.text, Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//            pager.currentItem = pager.currentItem + 1
//        }





        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else if(pager.currentItem != 0){
            pager.currentItem = pager.currentItem - 1
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
//                val fragmentManager = supportFragmentManager
//                val transaction = fragmentManager.beginTransaction()
//                transaction.replace(R.id.framer, BeginOrder())
//                transaction.commit()
            }
            R.id.nav_gallery -> {
                startActivity(Intent(this@MainActivity, AcceptPackage::class.java))

            }
            R.id.nav_slideshow -> {

            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun onButtonClicked(view: View){
        if (view is FancyButton){
            when(view.id){
                R.id.fancyButtonNext -> {

                }

            }
        }

        if (view is Button){
            when(view.id){
                R.id.createOrder -> {
                    pager.currentItem = pager.currentItem + 1
                }
            }
        }

        if (view is RadioGroup){

        }
    }


}
