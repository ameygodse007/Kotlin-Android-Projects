package com.example.vaccineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listData: Array<VaccineModel>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // 4- Handling the Click Events
    var clickListener: ItemClickListener? = null

    // 2- View Holder Class
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var textView: TextView = itemView.findViewById(R.id.textview)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            clickListener?.onClick(view, adapterPosition)
        }
    }

    // 3- Implementing the Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listItem = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myListData = listData[position]
        holder.textView.text = listData[position].getTitle()
        holder.imageView.setImageResource(listData[position].getImage())
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @JvmName("setClickListener1")
    fun setClickListener(clickListener: ItemClickListener?) {
        this.clickListener = clickListener
    }
}
