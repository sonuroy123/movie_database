package kayk.data.movie_database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class myadapter(var dataholder: ArrayList<model>) :
    RecyclerView.Adapter<myadapter.myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.single_row, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.dname.text = dataholder[position].name
        holder.dactor.text = dataholder[position].actor
        holder.dactress.text = dataholder[position].actress
        holder.ddirector.text = dataholder[position].director
        holder.dyor.text = dataholder[position].yor
    }

    override fun getItemCount(): Int {
        return dataholder.size
    }

    inner class myviewholder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var dname: TextView = itemView.findViewById<View>(R.id.displayname) as TextView
        var dactor: TextView = itemView.findViewById<View>(R.id.displayacter) as TextView
        var dactress: TextView = itemView.findViewById<View>(R.id.displyactress) as TextView
        var ddirector: TextView = itemView.findViewById<View>(R.id.displayDirector) as TextView
        var dyor: TextView = itemView.findViewById<View>(R.id.displayYor) as TextView

    }
}
