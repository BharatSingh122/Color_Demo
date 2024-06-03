package com.example.colordemo

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.colordemo.databinding.ItemAdapterBinding
import kotlin.random.Random

class MyAdapter(var items: ArrayList<MyModelClass>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<MyAdapter.YourViewHolder>() {

    var temparray: ArrayList<Int> = arrayListOf()
    var random = -1

    inner class YourViewHolder(val binding: ItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    fun update() {
        temparray.clear()
    }

    fun updateRandumNumber(randomN: Int){
        random = randomN
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
        val binding =
            ItemAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {


        holder.binding.view.setBackgroundColor(Color.parseColor(items[position].color))


        if (position == random){

            items[position] = items[position].copy(color = "#FFE61111")
            holder.binding.view.setBackgroundColor(Color.parseColor("#FFE61111"))

            holder.binding.view.setOnClickListener {

                items[position] = items[position].copy(color = "#FF19DF21")

                listener.onItemClick(position)
            }


        }


        /*
                if (position == (random-1)){

                    Log.e("TAGGG", "position--1: ${position}" )
                    Log.e("TAGGG", "i------random: ${random}" )
                    Log.e("TAGGG", "i------temparray.size: ${temparray.size}" )

                    if (temparray.size==0){
                        temparray.add(items[position].value)
                        items[position] = item.copy(color = "#FFE61111")
                        holder.binding.view.setBackgroundColor(Color.parseColor("#FFE61111"))
                        temparray.add(items[position].value)
                        holder.binding.view.setOnClickListener {
                            items[position] = item.copy(color = "#FF19DF21")
                            notifyDataSetChanged()

                            listener.onItemClick(position)

                        }

                    }else{
                        for (i in temparray){

                            Log.e("TAGGG", "onBindViewHolder--1: ${items[position].value}" )
                            Log.e("TAGGG", "i------111: ${i}" )

                            if (i != items[position].value){


                                Log.e("TAGGG", "onBindViewHolder: ${items[position].value}" )
                                Log.e("TAGGG", "i------: ${i}" )
                                items[position] = item.copy(color = "#FFE61111")
                                holder.binding.view.setBackgroundColor(Color.parseColor("#FFE61111"))
                                temparray.add(items[position].value)

                                holder.binding.view.setOnClickListener {
                                    items[position] = item.copy(color = "#FF19DF21")
                                    notifyDataSetChanged()
                                }

                            }
                        }

                    }

                }
        */


    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getRandomNumber(): Int {
        return Random.nextInt(1, items.size)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
