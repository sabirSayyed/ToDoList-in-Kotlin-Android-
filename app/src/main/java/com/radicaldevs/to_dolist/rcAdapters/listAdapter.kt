package com.radicaldevs.to_dolist.rcAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.radicaldevs.to_dolist.R
import kotlin.math.log


class listAdapter(var getcontext: Context, var getarray:ArrayList<listItemStructure>) :
    RecyclerView.Adapter<listAdapter.ViewHolder>() {



    class ViewHolder(var itemView:View) : RecyclerView.ViewHolder(itemView) {
        var tasktext: TextView = itemView.findViewById<TextView>(R.id.taskText)
        var time: TextView = itemView.findViewById(R.id.time)
        var removeButton : Button = itemView.findViewById(R.id.removeButton)
    }

    var context = getcontext
    var array = getarray

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int): ViewHolder{
        var v: View = LayoutInflater.from(context).inflate(R.layout.task_design,parent,false)
        var view:ViewHolder = ViewHolder(v)
        v.setOnClickListener {
            println("helloooo")
        }
        return view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tasktext.text = array.get(position).gettext
        holder.time.text = array.get(position).gettime
        holder.removeButton.setOnClickListener {
//            array.remove(listItemStructure(array.get(position).gettext,array.get(position).gettime))
            array.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return array.size
    }

}