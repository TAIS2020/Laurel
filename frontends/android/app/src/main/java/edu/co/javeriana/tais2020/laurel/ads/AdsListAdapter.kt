package edu.co.javeriana.tais2020.laurel.ads

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import edu.co.javeriana.tais2020.laurel.R

class AdsListAdapter(val context: Context):RecyclerView.Adapter<AdsListAdapter.MyViewHolder>()  {

    lateinit var list:List<Int>

    fun setContentList(list:List<Int>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var image = itemView.findViewById<ImageView>(R.id.ads_list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsListAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ads_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdsListAdapter.MyViewHolder, position: Int) {
        holder.image.setImageResource(list[position])
    }

}