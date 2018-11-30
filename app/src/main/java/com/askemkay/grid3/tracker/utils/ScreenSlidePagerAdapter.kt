package com.askemkay.grid3.tracker.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.askemkay.grid3.tracker.fragments.ContentType
import com.askemkay.grid3.tracker.fragments.CreateOrder
import com.askemkay.grid3.tracker.fragments.MapViewFragment

// Created by ask_emkay on 11/28/18.
class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
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