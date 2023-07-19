package com.example.zapateria_unica.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_ejercicios.R
import com.example.zapateria_unica.model.local.ZapEntity
import com.example.zapateria_unica.model.local.databinding.ZapListBinding


class ZapAdapter : RecyclerView.Adapter<ZapAdapter.zapHolder>() {

    private var listZapatilla = listOf<ZapEntity>()
    private val SelectedZap = MutableLiveData<ZapEntity>()


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): zapHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return zapHolder(layoutInflater.inflate(R.layout.item_rv, parent, false))
        }

        override fun getItemCount(): Int = listZapatilla.size

        override fun onBindViewHolder(holder: zapHolder, position: Int) {
            val item =(zapatillas[position])
            holder.render(item,onClickListener)
        }

        class zapHolder(val view: View) : RecyclerView.ViewHolder(view) {

            val binding = ItemZapatillasBinding.bind(view)

            fun render(zapatillas: ModelosZapatillas,onClickListener: (ModelosZapatillas) -> Unit)  {
                binding.nombrezapatilla.text = zapatillas.nombreZapatilla
                binding.tvPreciozapatilla.text = zapatillas.precioZapatilla
                Glide.with(binding.imagenZapatilla).load(zapatillas.imagenZapatilla).into(binding.imagenZapatilla)

                itemView.setOnClickListener{onClickListener(zapatillas)}

            }
        }
    }

