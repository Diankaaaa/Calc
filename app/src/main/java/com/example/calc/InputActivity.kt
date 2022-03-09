package com.example.calc

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

public const val EXTRA_NUMBER1="number1"
public const val EXTRA_NUMBER2="number2"
public const val EXTRA_TYPE_OPERATION="type"

class InputActivity : AppCompatActivity() {
    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var summa: CheckBox
    private lateinit var multiply: CheckBox
    private lateinit var maxdivsor: CheckBox
    private lateinit var buttonok : Button

    private var Summa:Int=0;
    private var Multiply:Int=0;
    private var MaxDivisor:Int=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        number1 = findViewById(R.id.number_1)
        number2 = findViewById(R.id.number_2)
        summa = findViewById(R.id.summa)
        maxdivsor = findViewById(R.id.max_divsor)
        multiply = findViewById(R.id.multiply)
        buttonok = findViewById(R.id.OK)

        buttonok.setOnClickListener { view:View->
            val data=Intent().apply {
                putExtra(EXTRA_NUMBER1,number1.text.toString())
                putExtra(EXTRA_NUMBER2,number2.text.toString())
                if(summa.isChecked)
                {
                    Summa = number1.text.toString().toInt() + number2.text.toString().toInt()
                    putExtra(EXTRA_TYPE_OPERATION,Summa)
                }
                if(maxdivsor.isChecked){
                   MaxDivisor=NOD(number1.text.toString().toInt(),number2.text.toString().toInt())
                    putExtra(EXTRA_TYPE_OPERATION,MaxDivisor)
                }
                if(multiply.isChecked){
                    Multiply = number1.text.toString().toInt() * number2.text.toString().toInt()
                    putExtra(EXTRA_TYPE_OPERATION,Multiply)
                }
            }
            setResult(Activity.RESULT_OK,data)
            this.finish()
        }
    }

    fun NOD(x: Int, y: Int): Int {
        var x = x
        var y = y
        while (x != y) {
            if (x > y) x = x - y else y = y - x
        }
        return x
    }

    companion object{
        fun newIntent(packageContext: Context): Intent
        {
            return Intent(packageContext,InputActivity::class.java).apply {

            }
        }
    }


}