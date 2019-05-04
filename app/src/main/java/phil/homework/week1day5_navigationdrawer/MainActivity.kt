package phil.homework.week1day5_navigationdrawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var dl: DrawerLayout
    lateinit var t: ActionBarDrawerToggle
    lateinit var nv: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dl = findViewById(R.id.activity_main)
        t = ActionBarDrawerToggle(this, dl, R.string.open, R.string.close)
        dl.addDrawerListener(t)
        t.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv)
        nv.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.account -> Toast.makeText(this@MainActivity, "My Account", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(this@MainActivity, "Settings", Toast.LENGTH_SHORT).show()
                R.id.mycart -> Toast.makeText(this@MainActivity, "My Cart", Toast.LENGTH_SHORT).show()
                else -> true
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(t.onOptionsItemSelected(item)) true
        return super.onOptionsItemSelected(item)
    }

}
