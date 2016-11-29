package com.yuan.library;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.MenuRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by yuan on 29/11/2016.
 */

public abstract class YItemDecoration extends RecyclerView.ItemDecoration {

    private GradientDrawable mGradientDrawableDivider;

    YItemDecoration(int color) {
        generateDividerDrawable(color);
    }

    private void generateDividerDrawable(int color) {
        mGradientDrawableDivider = new GradientDrawable();
        mGradientDrawableDivider.setColor(color);
    }

    GradientDrawable getDividerDrawable() {
        return mGradientDrawableDivider;
    }

}
