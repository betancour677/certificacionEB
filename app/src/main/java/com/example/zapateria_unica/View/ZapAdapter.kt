package com.example.zapateria_unica.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zapateria_unica.model.local.ZapEntity
import com.example.zapateria_unica.model.local.databinding.ZapListBinding


class ZapAdapter : RecyclerView.Adapter<ZapAdapter.CoursesVH>() {

    private var listZapatilla = listOf<ZapEntity>()
    private val SelectedZap = MutableLiveData<ZapEntity>()



    fun update(list:List<ZapEntity>){
        listZapatilla= list
        notifyDataSetChanged()
    }


    // FUNCION PARA SELECCIONAR

    fun selectedCourse():
            LiveData<ZapEntity> = SelectedZap


    inner class  CoursesVH(private val mBinding:ZapatillasListBinding  ):
        RecyclerView.ViewHolder(mBinding.root), View.OnClickListener{

        fun bind(course: CoursesEntity){
            Glide.with(mBinding.ivLogo).load(course.image).centerCrop().into(mBinding.ivLogo)

            mBinding.tvname.text = course.title
            mBinding.tvdescription.text = course.previewDescription
            mBinding.tvduration.text = "duración: " + course.weeks.toString() + " Semanas"
            mBinding.tvstart.text = "Inicio: " + course.star
            itemView.setOnClickListener(this)

        }
        override  fun onClick(v: View){

            SelectedCourse.value= listCourses[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesVH {
        return CoursesVH(ZapatillasListBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: CoursesVH, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }


    override fun getItemCount()=
        listCourses.size
}




