package com.ciandt.dojos.kotlin.batalhanaval.setup.ui

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ciandt.dojos.kotlin.batalhanaval.R

class SetupViewHolder(layout: View, private val listener: OnItemClickListener?) : RecyclerView.ViewHolder(layout), View.OnClickListener {

    private val mColoredArea: View = layout.findViewById(R.id.coloredAreaView)

    init {
        layout.setOnClickListener(this)
    }

    fun bind(navio: Boolean) {
        if (navio) {
            mColoredArea.setBackgroundColor(ContextCompat.getColor(mColoredArea.context,
                    R.color.colorItemTabuleiroNavio))
        } else {
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