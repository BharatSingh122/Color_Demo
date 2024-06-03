package com.example.colordemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.colordemo.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var boxCount = 0
    var toatalBox = 0
    lateinit var adapter: MyAdapter
    var array: ArrayList<MyModelClass> = arrayListOf()
    var temparray: ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val str = binding.etView.text.toString()
            boxCount = str.toInt()
            binding.rvList.layoutManager = GridLayoutManager(this, boxCount)
            setAdapter()

        }

    }

    fun getRandomNumber(): Int {
        return Random.nextInt(1, toatalBox)
    }

    fun setAdapter() {
        array.clear()
        temparray.clear()
        toatalBox = boxCount * boxCount

        for (i in 1..toatalBox) {
            array.add(MyModelClass("#FF000000", i))

        }

            adapter = MyAdapter(array, object : MyAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {

                    var tem = getRandomNumber()

                    while (temparray.contains(tem)) {
                        tem = getRandomNumber()
                    }
                    Log.e("TAGGG", "i------it: ${(tem)}")
                    Log.e("TAGGG", "toatalBox   ${(toatalBox)}")

//                    if (!temparray.contains(tem)) {
                        adapter.updateRandumNumber(tem - 1)
                        temparray.add(tem)
//                    }
                }
            })

        adapter.update()
        binding.rvList.adapter = adapter
        val tem = getRandomNumber()
        adapter.updateRandumNumber(tem - 1)
        temparray.add(tem)

    }

}