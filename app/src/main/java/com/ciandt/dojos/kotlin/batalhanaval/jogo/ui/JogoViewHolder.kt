package com.ciandt.dojos.kotlin.batalhanaval.jogo.ui

import android.support.v7.widget.RecyclerView
import android.view.View

class JogoViewHolder(layout: View, private val listener: OnItemClickListener?) : RecyclerView.ViewHolder(layout), View.OnClickListener {

    init {
        layout.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        listener?.onItemClick(adapterPosition)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}