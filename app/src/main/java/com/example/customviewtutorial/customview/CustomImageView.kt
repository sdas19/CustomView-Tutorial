package com.example.customviewtutorial.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customviewtutorial.R

class CustomImageView(
    context: Context, attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private val TAG = CustomImageView::class.java.simpleName

    init {
        inflate(context, R.layout.layout_custom_imageview, this)
        //setWillNotDraw(false)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "inside onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d(TAG, "inside onDetachedFromWindow")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d(TAG, "inside onLayout")
        super.onLayout(changed, left, top, right, bottom)
    }

    /*
    * The parent may measure each child once with unspecified dimensions to find out
    * how big they want to be, then call measure() on them again with actual numbers if the sum
    * of all the children's unconstrained sizes is too big or too small (that is, if the children
    * don't agree among themselves as to how much space they each get, the parent will intervene
    * and set the rules on the second pass).
    * https://developer.android.com/guide/topics/ui/how-android-draws.html
    * */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.d(TAG, "inside onMeasure")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //squaring the view
        val widthWithoutPadding = measuredWidth - paddingLeft - paddingRight
        val heigthWithoutPadding = measuredHeight - paddingTop - paddingBottom

        val size = if (widthWithoutPadding > heigthWithoutPadding) {
            heigthWithoutPadding
        } else {
            widthWithoutPadding
        }

        setMeasuredDimension(size + paddingLeft + paddingRight, size + paddingTop + paddingBottom)
    }

    /*
    * Called by draw to draw the child views. This may be overridden by
    * derived classes to gain control just before its children are drawn
    * (but after its own view has been drawn).
    * */
    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        Log.d(TAG, "inside dispatchDraw")
    }

    /*
    * The framework uses draw(Canvas) in its draw cycle. This is in the View code:
        Step 1: draw the background, if needed
        Step 2: save the canvas' layers
        Step 3: draw the content --- onDraw() comes here
        Step 4: draw the children
        Step 5: draw the fade effect and restore layers
        Step 6: draw the scrollbars

    * Useful tip
        You can render any view into an offscreen Bitmap you create, and later use this bitmap anywhere:

            Canvas c = new Canvas();
            c.setBitmap(myOffscreenBitmap);
            myView.draw(c);
    *
    * */
    override fun draw(canvas: Canvas?) {
        Log.d(TAG, "inside draw")
        super.draw(canvas)
    }

    /*
    * For efficiency, layouts do not get their onDraw() method called.
    * To enable it, call setWillNotDrawEnabled(false)
    * https://groups.google.com/g/android-developers/c/oLccWfszuUo
    * */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d(TAG, "inside onDraw")
    }
}