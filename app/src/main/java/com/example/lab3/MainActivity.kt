package com.example.lab3

import android.app.Activity
import android.content.Intent
import androidx .appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.core.view.get

private const val REQUEST_CODE=0
class MainActivity : AppCompatActivity() {
    private var menu: Menu?=null
    private lateinit var res:String
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
        when(id)
        {
            R.id.action_input->
            {
                val  intent=InputActivity.newIntent(this@MainActivity)
                startActivityForResult(intent, REQUEST_CODE)
                menu?.findItem(R.id.action_calc)?.isVisible=true
            }
            R.id.action_calc->
            {
                val  intent=MessageActivity.newIntent(this@MainActivity,res)
                startActivity(intent)
            }
            R.id.action_quit->this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode!= Activity.RESULT_OK)
        {
            return
        }
        if(requestCode == REQUEST_CODE)
        {
            val n: String? = data?.getStringExtra(EXTRA_NUMBER)
            val isLift:Boolean = data?.getBooleanExtra(EXTRA_ISLIFT,false)?:false
            var type:String?
            if(isLift!=false)
            {
                type=data?.getStringExtra(EXTRA_TYPE)
                res="Номер этажа "+n+". Лифт есть. Тип лифта:"+type
            }
            else {
                res = "Номер этажа " + n + ". Лифта нет."
            }
        }
    }
}