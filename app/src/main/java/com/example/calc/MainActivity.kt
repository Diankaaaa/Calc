package com.example.calc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
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
            val n1: String? = data?.getStringExtra(EXTRA_NUMBER1)
            val n2: String? = data?.getStringExtra(EXTRA_NUMBER2)
            val type:String? = data?.getStringExtra(EXTRA_TYPE_OPERATION)
            var i:Int=0;
//            if(type.equals("+"))
//                if (n1 != null) {
//                    if (n2 != null) {
//                        res=n1+"+"+n2+"="+(n1.toInt()+n2.toInt())
//                    }
//                }
//            else if(type.equals("NOD"))
//                {
//                    if (n1 != null) {
//                        if (n2 != null) {
//                            res="NOD("+n1+","+n2+")="+NOD(n1.toInt(),n2.toInt())
//                        }
//                    }
//                }
//            else if(type.equals("*"))
//                {
//                    if (n1 != null) {
//                        if (n2 != null) {
//                            res=n1+"*"+n2+"="+(n1.toInt()*n2.toInt())
//                        }
//                    }
//                }
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
}