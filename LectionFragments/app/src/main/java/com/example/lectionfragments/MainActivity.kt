package com.example.lectionfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var materialToolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemsBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemsBars.left, systemsBars.top, systemsBars.right, systemsBars.bottom)
            insets
        }

        materialToolbar = findViewById(R.id.my_toolbar)
        setSupportActionBar(materialToolbar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.welcome_fragment_container, WelcomeFragment())
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.arrow_forward -> replaceFragment(ArrowFragment())
            R.id.home_page -> replaceFragment(WelcomeFragment())
            R.id.baseline_contact -> replaceFragment(ContactFragment())
        }

        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
    /*    supportFragmentManager.beginTransaction()
            .replace(R.id.welcome_fragment_container, fragment)
            .commit()   */
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_up,
            R.anim.fade_out,
        )
        fragmentTransaction.replace(R.id.welcome_fragment_container,
            fragment)
        fragmentTransaction.commit()
    }
}