package kayk.data.movie_database

import android.database.Cursor
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class fetch_data : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var dataholder: ArrayList<model>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_data)
        recyclerView = findViewById<View>(R.id.recview) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val cursor: Cursor = DBHelper(this).getdata()
        dataholder = ArrayList()
        while (cursor.moveToNext()) {
            val obj = model(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4))
            dataholder!!.add(obj)
        }
        val adapter = myadapter(dataholder!!)
        recyclerView!!.adapter = adapter
    }
}