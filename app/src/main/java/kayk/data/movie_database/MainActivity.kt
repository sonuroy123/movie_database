package kayk.data.movie_database

import android.app.AlertDialog
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var actor: EditText
    lateinit var actress: EditText
    lateinit var director: EditText
    lateinit var yor: EditText
    lateinit var DB: DBHelper
    var insert : Button?  = null
    var view : Button?  = null
    var show : Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name);
        actor = findViewById(R.id.actor);
        actress = findViewById(R.id.actress);
        director = findViewById(R.id.director);
        yor = findViewById(R.id.yor);
        DB = DBHelper(this)
        insert = findViewById(R.id.btnInsert)
        view = findViewById(R.id.btnView)

       show = findViewById(R.id.btSerach)

        insert?.setOnClickListener {
            val name1 = name.getText().toString()
            val actor1 = actor.getText().toString()
            val actress1 = actress.getText().toString()
            val director1 = director.getText().toString()
            val yor1 = yor.getText().toString()

            if (name1.isEmpty() || actor1.isEmpty()  || actress1.isEmpty()  || director1.isEmpty()  || yor1.isEmpty()  ){
                Toast.makeText(this@MainActivity, "field can't be empty", Toast.LENGTH_SHORT).show()
            } else{
                /* val cursor: Cursor = DBHelper(this).getdata()
                    var flag=false
                    while (cursor.moveToNext()) {
                        val obj = cursor.getString(1).toString()
                        if (obj == email)
                            flag=true
                    }
                    if(flag){
                        Toast.makeText(this@MainActivity, "This Aadhar no is registered", Toast.LENGTH_SHORT)
                            .show()
                    }*/

                val checkinsertdata = DB.insertuserdata(name1,actor1,actress1,director1,yor1)
                if (checkinsertdata == true){
                    Toast.makeText(this@MainActivity, "New Entry Inserted", Toast.LENGTH_SHORT).show()
                    name.setText(" ")
                    actor.setText(" ")
                    actress.setText(" ")
                    director.setText(" ")
                    yor.setText(" ")
                }
                else
                    Toast.makeText(this@MainActivity, "New Entry Not Inserted", Toast.LENGTH_SHORT).show()
            }
        }

        view?.setOnClickListener {
            val intent = Intent(this@MainActivity,fetch_data::class.java)
            startActivity(intent)

        }

      show?.setOnClickListener {
          val intent = Intent(this@MainActivity,search::class.java)
          startActivity(intent)
      }
    }
}