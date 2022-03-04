package com.example.lab3

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

public const val EXTRA_NUMBER="number"
public const val EXTRA_ISLIFT="islift"
public const val EXTRA_TYPE="type"

class InputActivity : AppCompatActivity() {
    private lateinit var isLift:CheckBox
    private lateinit var buttonOk:Button
    private lateinit var textNumber:EditText
    private lateinit var radioType1:RadioButton
    private lateinit var radioType2:RadioButton
    private lateinit var group:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        isLift=findViewById(R.id.isLift)
        buttonOk=findViewById(R.id.ok)
        textNumber=findViewById(R.id.number)
        radioType1=findViewById(R.id.type1)
        radioType2=findViewById(R.id.type2)
        group=findViewById(R.id.radioGroup)
        group.isVisible=false
        isLift.setOnClickListener { view:View->
            if(isLift.isChecked) group.isVisible=true
            else group.isVisible=false
        }
        buttonOk.setOnClickListener { view:View->
            val data=Intent().apply {
                putExtra(EXTRA_NUMBER,textNumber.text.toString())
                if(isLift.isChecked)
                {
                    putExtra(EXTRA_ISLIFT,true)
                    if(radioType1.isChecked) putExtra(EXTRA_TYPE,radioType1.text)
                    if(radioType2.isChecked) putExtra(EXTRA_TYPE,radioType2.text)
                }
                else putExtra(EXTRA_ISLIFT,false)

            }
            setResult(Activity.RESULT_OK,data)
            this.finish()
        }
    }

    companion object{
        fun newIntent(packageContext: Context): Intent
        {
            return Intent(packageContext,InputActivity::class.java).apply {

            }
        }
    }
}