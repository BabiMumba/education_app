package com.babitech.education

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.core.view.GravityCompat
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.babitech.education.jv.DarkModePrefManager
import androidx.appcompat.app.AppCompatDelegate
import android.os.Build
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar

class MainActivity1 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDarkMode(window)
        setContentView(R.layout.activity_main)



        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        bottomNavigationView = findViewById(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //
        val layoutParams = bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.behavior = BottomNavigationBehavior1()

        bottomNavigationView.selectedItemId = R.id.navigationHome

        findViewById<View>(R.id.floatingActionButton).setOnClickListener {
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_camera -> {
            }
            R.id.nav_gallery -> {
            }
            R.id.nav_slideshow -> {
            }
            R.id.nav_manage -> {
            }
            R.id.nav_share -> {
            }
            R.id.nav_dark_mode -> {

                val darkModePrefManager = DarkModePrefManager(this)
                darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                recreate()
            }
        }
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationMyProfile -> {

                }
                R.id.navigationMyCourses -> {

                }
                R.id.navigationHome ->{

                }
                R.id.navigationSearch ->{

                }
                R.id.navigationMenu -> {
                    val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
                    drawer.openDrawer(GravityCompat.START)
                }
            }
            true
        }



    private fun setDarkMode(window: Window) {
        if (DarkModePrefManager1(this).isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            changeStatusBar(MODE_DARK, window)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            changeStatusBar(MODE_LIGHT, window)
        }
    }

    private fun changeStatusBar(mode: Int, window: Window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = this.resources.getColor(R.color.contentStatusBar)
            if (mode == MODE_LIGHT) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

    companion object {
        private const val MODE_DARK = 0
        private const val MODE_LIGHT = 1
    }

}