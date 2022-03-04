package com.example.lab3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
private const val EXTRA_MESSAGE="result"
class MessageActivity : AppCompatActivity() {
    private lateinit var res:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        res=findViewById(R.id.result)
        res.text=intent.getStringExtra(EXTRA_MESSAGE)
    }
    companion object{
        fun newIntent(packageContext: Context,res:String): Intent
        {
            return Intent(packageContext,MessageActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,res)
            }
        }
    }
}