package com.radicaldevs.to_dolist.rcAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.radicaldevs.to_dolist.R



class listAdapter(var getcontext: Context, var getarray:ArrayList<listItemStructure>) :
    RecyclerView.Adapter<listAdapter.ViewHolder>() {

    class ViewHolder(var itemView:View) : RecyclerView.ViewHolder(itemView) {
        var tasktext: TextView = itemView.findViewById<TextView>(R.id.taskText)
        var time: TextView = itemView.findViewById(R.id.time)
    }

    var context = getcontext
    var array = getarray

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ViewHolder{
        var v: View = LayoutInflater.from(context).inflate(R.layout.task_design,parent,false)
        var view:ViewHolder = ViewHolder(v)

        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tasktext.text = array.get(position).gettext
        holder.time.text = array.get(position).gettime
    }

    override fun getItemCount(): Int {
        return array.size
    }

}