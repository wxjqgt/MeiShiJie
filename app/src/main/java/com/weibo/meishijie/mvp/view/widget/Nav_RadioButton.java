package com.weibo.meishijie.mvp.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.weibo.meishijie.R;

/**
 * Created by Administrator on 2017/12/7.
 */

public class Nav_RadioButton extends AppCompatRadioButton {

    /**
     * xml文件中设置的大小
     */
    private int mDrawableSize;

    public Nav_RadioButton(Context context) {
        this(context, null, 0);
    }

    public Nav_RadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Nav_RadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Drawable drawableLeft = null, drawableTop = null,
                drawableRight = null, drawableBottom = null;
        TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.NavigationBar_RadioButton);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.NavigationBar_RadioButton_DrawableSize:
                    mDrawableSize = a.getDimensionPixelSize(
                            R.styleable.NavigationBar_RadioButton_DrawableSize, 0);
                    break;
                case R.styleable.NavigationBar_RadioButton_DrawableTop:
                    drawableTop = a.getDrawable(attr);
                    break;
                case R.styleable.NavigationBar_RadioButton_DrawableRight:
                    drawableRight = a.getDrawable(attr);
                    break;
                case R.styleable.NavigationBar_RadioButton_DrawableBottom:
                    drawableBottom = a.getDrawable(attr);
                    break;
                case R.styleable.NavigationBar_RadioButton_DrawableLeft:
                    drawableLeft = a.getDrawable(attr);
                    break;
                default:
                    break;
            }
        }
        setCustomCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom);
        //回收
        a.recycle();
    }

    public void setCustomCompoundDrawablesWithIntrinsicBounds(
            Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (mDrawableSize == 0){
            mDrawableSize = 30;
        }
        if (left != null) {
            left.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableSize, mDrawableSize);
        }
        setCompoundDrawables(left, top, right, bottom);
    }
}
