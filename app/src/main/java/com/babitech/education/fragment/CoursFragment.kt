package com.babitech.education.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.babitech.education.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class CoursFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v =inflater.inflate(R.layout.fragment_cours, container, false)
        val mathid = v.findViewById<CardView>(R.id.math_id)
        val physiid = v.findViewById<CardView>(R.id.physique_id)
        mathid.setOnClickListener {
            Toast.makeText(activity, "mathematique", Toast.LENGTH_SHORT).show()
        }
        physiid.setOnClickListener {
            Toast.makeText(activity, "physique", Toast.LENGTH_SHORT).show()
            
        }


        return v
    }


}