package com.askemkay.grid3.tracker.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.askemkay.grid3.tracker.R
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_type_fragment.*
import kotlinx.android.synthetic.main.create_order_fragment.*

// Created by ask_emkay on 11/28/18.
class ContentType: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.content_type_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fancy_radio_group.setOnCheckedChangeListener { radioGroup, i ->  }

//        drug.setOnClickListener {
//            drug.isChecked = true
//            vaccine.isChecked = false
//            helpTeam.isChecked = false
//        }
//        vaccine.setOnClickListener {
//            drug.isChecked = false
//            vaccine.isChecked = true
//            helpTeam.isChecked = false
//        }
//        helpTeam.setOnClickListener {
//            drug.isChecked = false
//            vaccine.isChecked = false
//            helpTeam.isChecked = true
//        }

        fancyButtonNext.setOnClickListener {
            val text = if (vaccine.isChecked) "Vaccines" else if(drug.isChecked)"Drugs" else "Equipment"
            activity?.getSharedPreferences("SharedPref", MODE_PRIVATE)?.edit()
                ?.putString("type", text)?.commit()
//            Toast.makeText(activity?.baseContext, text, Toast.LENGTH_LONG).show()
//            Log.e("OkHttp", text)
            activity?.pager?.currentItem = activity?.pager?.currentItem!! + 1
        }

    }
}