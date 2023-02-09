package com.example.dafaabiyyu_editsiswa

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class AdapterSiswa (private val dataset: MutableList<Datasiswa>) :
        RecyclerView.Adapter<AdapterSiswa.Viewholder>() {
    class Viewholder (view: View): RecyclerView.ViewHolder(view){
        val nis = view.findViewById<TextView>(R.id.id_Nis)
        val nama = view.findViewById<TextView>(R.id.id_Nama)
        val jakel = view.findViewById<TextView>(R.id.id_jeniskelamin)
        val edit = view.findViewById<Button>(R.id.btn_Edit)
        val hapus = view.findViewById<Button>(R.id.btn_Hapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_siswa,parent,false))
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val data = dataset[position]
        holder.nis.text = data.nis
        holder.nama.text = data.nama
        holder.jakel.text = data.jakel
        holder.hapus.setOnClickListener {
            dataset.removeAt(position)
            notifyItemRangeRemoved(position,dataset.size)
            notifyDataSetChanged()
        }

        holder.edit.setOnClickListener {
            val context = holder.itemView.context
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.edit_siswa,null)
            val enis = view.findViewById<TextView>(R.id.editNIS_Update)
            val enama = view.findViewById<TextView>(R.id.editNama_Update)
            val jjk = view.findViewById<TextView>(R.id.TVjekel)
            val ejekelLaki = view.findViewById<RadioButton>(R.id.rbLakiLaki_Update)

            enis.text = data.nis
            enama.text = data.nama
            jjk.text = data.jakel

            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Edit Data")
                .setView(view)
                .setPositiveButton("Update") { dialogInterface, i ->
                    data.nis = enis.text.toString()
                    data.nama = enama.text.toString()

                    if (ejekelLaki.isChecked ) {
                        data.jakel = "laki-laki"
                    } else  {
                        data.jakel = "perempuan"
                    }
                    notifyDataSetChanged()
                }
                .setNegativeButton("Batal",DialogInterface.OnClickListener{dialogInterface, i ->  })
            alertDialog.create().show()
        }
    }

    override fun getItemCount(): Int = dataset.size
}