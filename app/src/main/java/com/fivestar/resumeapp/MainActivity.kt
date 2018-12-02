package com.fivestar.resumeapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        updateFragment(AboutMeFragment())
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_about_me -> {
                updateFragment(AboutMeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_career -> {
                updateFragment(CareerFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_education -> {
                updateFragment(EducationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_skills -> {
                updateFragment(SkillsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun updateFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(main_fragment.id, fragment)
        fragmentTransaction.commit()
    }
}
