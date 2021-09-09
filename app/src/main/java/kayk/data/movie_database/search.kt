package kayk.data.movie_database

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class search : AppCompatActivity() {

    lateinit var edtsearch : EditText
    lateinit var btnSearch : Button


    var recyclerView: RecyclerView? = null
    var dataholder: ArrayList<model>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        edtsearch = findViewById(R.id.edtSearch)
        btnSearch = findViewById(R.id.btnSerach)

        btnSearch.setOnClickListener {



        val res = DBHelper(this).deletedata(edtsearch.text.toString())

            if(res){
                Toast.makeText(this@search,"Deleted Successfully",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@search,"Data not found",Toast.LENGTH_LONG).show()
            }

          /*  recyclerView = findViewById<View>(R.id.recycler) as RecyclerView
            recyclerView!!.layoutManager = LinearLayoutManager(this)
           val cursor: Cursor = DBHelper(this).getdata()
            //val cursor : Cursor? = DBHelper(this).searchData(edtsearch.text.toString())
            dataholder = ArrayList()

          //  var edtsearch1 = edtsearch.text.toString()
            while (cursor.moveToNext()) {
                val obj = model(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4))
                dataholder!!.add(obj)
            }

            val adapter = myadapter1(dataholder!!)
            recyclerView!!.adapter = adapter*/

        }


      /*  edtsearch.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("Not yet implemented")

            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

        })*/
    }
}