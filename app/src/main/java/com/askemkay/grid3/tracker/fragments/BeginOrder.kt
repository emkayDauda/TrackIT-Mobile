package com.askemkay.grid3.tracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.askemkay.grid3.tracker.R
import kotlinx.android.synthetic.main.content_type_fragment.*
import kotlinx.android.synthetic.main.create_order_fragment.*
import kotlinx.android.synthetic.main.fragment_create_order.*
import mehdi.sakout.fancybuttons.FancyButton

// Created by ask_emkay on 11/28/18.
class BeginOrder: Fragment() {
//    private lateinit var pager: ViewPager
//    private lateinit var  energyTextview: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.create_order_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagers?.adapter = ScreenSlidePagerAdapter(activity?.supportFragmentManager!!)

        fancyButtonNext?.setOnClickListener {
            pagers.currentItem = pagers.currentItem + 1
        }

        createOrder.setOnClickListener {
            pagers.currentItem = pagers.currentItem + 1
        }
    }



    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> {
                    val a = ContentType()
                    val b = Bundle()
                    b.putString("totalPower", "16.858")
                    a.arguments = b
                    a
                }
                1 -> {
                    val a = CreateOrder()
                    val b = Bundle()
                    b.putString("totalPower", "3135.56")
                    a.arguments = b
                    a
                }
                2 -> {
                    val a = MapViewFragment()
                    val b = Bundle()
                    b.putString("totalPower", "1356.92")
                    a.arguments = b
                    a
                }
                else -> {
                    val a = ContentType()
                    val b = Bundle()
                    b.putString("totalPower", "16.858")
                    a.arguments = b
                    a
                }
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Total Energy (kWh)"
                1 -> "Generator (kWh)"
                2 -> "Utility (kWh)"
                else -> ""
            }
        }
    }




}