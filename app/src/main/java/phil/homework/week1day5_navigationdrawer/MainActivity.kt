package phil.homework.week1day5_navigationdrawer

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var dl: DrawerLayout
    lateinit var t: ActionBarDrawerToggle
    lateinit var nv: NavigationView
    lateinit var tb: android.support.v7.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tb = findViewById(R.id.toolbar)
        setSupportActionBar(tb)


        dl = findViewById(R.id.activity_main)
        t = ActionBarDrawerToggle(this, dl, R.string.open, R.string.close)
        dl.addDrawerListener(t)
        t.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nv = findViewById(R.id.nv)
        nv.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.contacts -> Toast.makeText(this@MainActivity, "Search Contacts", Toast.LENGTH_SHORT).show()
                R.id.flashlight -> Toast.makeText(this@MainActivity, "Use Flashlight", Toast.LENGTH_SHORT).show()
                R.id.emi -> Toast.makeText(this@MainActivity, "Calculate EMI", Toast.LENGTH_SHORT).show()
                else -> true
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        //val searchItem = menu?.findItem()

        return super .onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(t.onOptionsItemSelected(item)) true
        return super.onOptionsItemSelected(item)
    }

}
