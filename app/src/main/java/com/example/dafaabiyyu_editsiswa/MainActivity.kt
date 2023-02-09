package com.example.dafaabiyyu_editsiswa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inpuNIS : EditText
    private lateinit var inpuNAMA : EditText
    private lateinit var jkLakilaki : RadioButton
    private lateinit var jkperempuan : RadioButton
    private lateinit var tambahData : Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inpuNIS = findViewById(R.id.txtInputNIS)
        inpuNAMA = findViewById(R.id.txtInputNama)
        jkLakilaki = findViewById(R.id.rbLakiLaki)
        jkperempuan = findViewById(R.id.rbPerempuan)
        tambahData = findViewById(R.id.btnTambah)
        recyclerView = findViewById(R.id.listData)

        val data = mutableListOf<Datasiswa>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = AdapterSiswa(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        tambahData.setOnClickListener {
            val nis = inpuNIS.text.toString()
            val nama = inpuNAMA.text.toString()
            var jk = "laki-laki"
            if(jkLakilaki.isChecked){

            } else {
                jk = "perempuan"
            }
            val datasiswa = Datasiswa(nis,nama, jk)
            data.add(datasiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}