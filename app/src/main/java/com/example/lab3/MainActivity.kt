package com.example.lab3

import androidx .appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var menu: Menu?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        this.menu=menu
        menu?.findItem(R.id.action_calc)?.isVisible=false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id:Int=item.itemId
        var itemselected:TextView=findViewById(R.id.selectedMenu)
        when(id)
        {
            R.id.action_input->
            {

                menu?.findItem(R.id.action_calc)?.isVisible=true
            }
            R.id.action_calc->this.finish()
            R.id.action_quit->this.finish()
        }
        return super.onOptionsItemSelected(item)
    }
}