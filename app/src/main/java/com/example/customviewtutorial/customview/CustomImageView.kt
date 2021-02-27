package com.example.customviewtutorial.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customviewtutorial.R
import kotlinx.android.synthetic.main.layout_custom_imageview.view.*

class CustomImageView(
    context: Context, attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private val TAG = CustomImageView::class.java.simpleName

    init {
        inflate(context, R.layout.layout_custom_imageview, this)
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomImageView)
            try {
                image.setImageDrawable(attributes.getDrawable(R.styleable.CustomImageView_imageRef))
                text.text = attributes.getString(R.styleable.CustomImageView_text)
            } finally {
                attributes.recycle();
            }
        }
    }
}