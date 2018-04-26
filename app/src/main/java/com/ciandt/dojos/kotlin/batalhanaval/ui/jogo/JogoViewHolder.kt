package com.ciandt.dojos.kotlin.batalhanaval.ui.jogo

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ciandt.dojos.kotlin.batalhanaval.R

/**
 * Author: andrech
 * Date: 21/02/18
 */
class JogoViewHolder(layout: View, private val listener: OnItemClickListener?) : RecyclerView.ViewHolder(layout), View.OnClickListener {

    private val mColoredArea: View

    init {
        mColoredArea = layout.findViewById(R.id.coloredAreaView)
        layout.setOnClickListener(this)
    }

    fun bind() {
        //TODO: Definir o que será passado para renderizar a célula
    }

    fun bind(navio: Boolean){
        if(navio){
            mColoredArea.setBackgroundColor(ContextCompat.getColor(mColoredArea.context,
                    R.color.colorItemTabuleiroNavio))
        }
        else{
            mColoredArea.setBackgroundColor(ContextCompat.getColor(mColoredArea.context,
                    R.color.colorItemTabuleiroPadrao))
        }
    }

    override fun onClick(view: View?) {
        listener?.onItemClick(adapterPosition)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }

}