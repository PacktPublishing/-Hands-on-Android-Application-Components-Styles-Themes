package com.packt.video05

import android.content.Context
import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.widget.Button

class CustomView(context: Context, attrs: AttributeSet) : Button(context, attrs){

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0, 0).apply {

            try {
                val color = getResourceId(R.styleable.CustomView_backgroundColorValue, 0)
                val delimiter = getString(R.styleable.CustomView_delimiter)
                val textVisible = getBoolean(R.styleable.CustomView_textVisible,true)
                setText(color, delimiter, textVisible)

            } finally {
                recycle()
            }
        }
    }

    private fun setText(color: Int, delimiter : String, textVisible: Boolean){

        setBackgroundColor(ContextCompat.getColor(context,color))

        if(!textVisible){
            setText("")
        }
        else{
            text = text.replace("\\s".toRegex(), delimiter)
            setText(text)
        }
    }
}
