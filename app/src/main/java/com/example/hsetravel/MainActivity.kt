package com.example.hsetravel

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        val appBarLayout = findViewById<AppBarLayout>(R.id.appbar)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener {
                appBarLayout, verticalOffset ->
            val isShow = false
            val scrollRange = -1
            if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                // Collapsed
                //hideOption(R.id.action_info)
            } else if (verticalOffset == 0) {
                // Expanded
                //showOption(R.id.action_info)
            } else {
                // Idle
                //hideOption(R.id.action_info)
            }
        }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        //hideOption(R.id.action_info)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id: Int = item.getItemId()
        if (id == R.id.action_info) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun hideOption(id: Int) {
        val item: MenuItem = menu!!.findItem(id)
        item.setVisible(false)
    }

    private fun showOption(id: Int) {
        val item: MenuItem = menu!!.findItem(id)
        item.setVisible(true)
    }
}