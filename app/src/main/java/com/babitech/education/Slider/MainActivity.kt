package com.babitech.education.Slider

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import android.widget.LinearLayout
import android.os.Bundle
import com.babitech.education.R
import android.view.WindowManager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import android.text.Html
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Intent
import android.graphics.Color
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var tvSkip: TextView
    private lateinit var tvNext: TextView
    private lateinit var viewPager: ViewPager
    private lateinit var layoutDots: LinearLayout

    // private IntroPref introPref;
    private lateinit var layouts: IntArray
    private lateinit var dots: Array<TextView?>

    private var viewPagerAdapter: MyViewPagerAdapter? = null
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_s)

        // introPref = new IntroPref(this);

        /*
        if (!introPref.isFirstTimeLaunch()) {
           launchHomeScreen();
            finish();
        }
         */window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_FULLSCREEN
        tvNext = findViewById(R.id.tvNext)
        tvSkip = findViewById(R.id.tvSkip)
        viewPager = findViewById(R.id.viewPager)
        layoutDots = findViewById(R.id.layoutDots)
        layouts = intArrayOf(
            R.layout.intro_one,
            R.layout.intro_two,
            R.layout.intro_three
        )
        tvNext.setOnClickListener {
            val current = getItem()
            if (current < layouts.size) {
                viewPager.currentItem = current
            } else {
                launchHomeScreen()
            }
        }
        tvSkip.setOnClickListener {
            val current = getItem()
            if (current < layouts.size) {
                // move to next screen
                viewPager.currentItem = current + 2
            } else {
                launchHomeScreen()
            }
        }
        viewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = viewPagerAdapter
        viewPager.addOnPageChangeListener(onPageChangeListener)
        addBottomDots(0)
        changeStatusBarColor()
    }

    private fun changeStatusBarColor() {
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }

    private var onPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            addBottomDots(position)
            if (position == layouts.size - 1) {
                tvNext.text = "commencer"
            } else {
                tvNext.text = "Suivant"
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)
        val activeColors = resources.getIntArray(R.array.active)
        val inActiveColors = resources.getIntArray(R.array.inactive)
        layoutDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226")
            dots[i]!!.textSize = 50f
            dots[i]!!.setTextColor(inActiveColors[currentPage])
            layoutDots.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[currentPage]!!.setTextColor(activeColors[currentPage])
        }
    }

    inner class MyViewPagerAdapter : PagerAdapter() {
        var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }

    private fun getItem(): Int {
        return viewPager.currentItem + 1
    }

    private fun launchHomeScreen() {
        //introPref.setIsFirstTimeLaunch(false);
        startActivity(Intent(this@MainActivity, ActivityHome::class.java))
        finish()
    }
}