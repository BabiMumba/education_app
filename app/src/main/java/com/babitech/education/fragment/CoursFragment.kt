package com.babitech.education.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        val floatbtn = v.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatbtn.setOnClickListener {
            Toast.makeText(activity, "salut", Toast.LENGTH_SHORT).show()
        }

        return v
    }


}