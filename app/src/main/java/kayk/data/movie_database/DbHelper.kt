package kayk.data.movie_database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(context: Context?) : SQLiteOpenHelper(context, "movie.db", null, 1) {


    override fun onCreate(DB: SQLiteDatabase) {
        DB.execSQL("create Table user(name varchar(20) PRIMARY KEY, actor varchar(20),actress varchar(20), director varchar(20),yor DATE)")
    }

    override fun onUpgrade(DB: SQLiteDatabase, i: Int, i1: Int) {
        DB.execSQL("drop Table if exists user")
    }

    fun insertuserdata(name: String?,actor : String?,actress : String?,director : String?,yor : String?): Boolean {
        val DB = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("actor", actor)
        cv.put("actress", actress)
        cv.put("director", director)
        cv.put("yor", yor)

        val result = DB.insert("user", null, cv)
        return result != -1L
    }


    @SuppressLint("Recycle")
    fun deletedata(data: String): Boolean {
        val DB = this.writableDatabase
        val cursor = DB.rawQuery("Select * from user where name = ?", arrayOf(data))
        return if (cursor.count > 0) {
            val result = DB.delete("user", "name=?", arrayOf(data)).toLong()
            result != -1L
        } else {
            false
        }
    }

    fun getdata(): Cursor {
        val DB = this.writableDatabase
        return DB.rawQuery("Select * from user", null)
    }
}