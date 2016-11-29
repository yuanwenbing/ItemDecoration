package com.yuan.library;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by yuan on 29/11/2016.
 */

public class HorizontalItemDecoration extends YItemDecoration {

    private int mDividerSize;

    private int mDividerPaddingTop;

    private int mDividerPaddingBottom;

    private boolean mShowStart;

    private boolean mShowEnd;

    private HorizontalItemDecoration(Builder builder) {
        super(builder.color);
        mDividerSize = builder.size;
        mDividerPaddingTop = builder.paddingTop;
        mDividerPaddingBottom = builder.paddingBottom;
        mShowStart = builder.showStart;
        mShowEnd = builder.showEnd;

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, mDividerSize, 0);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawHorizontal(c, parent);
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {
        int top = parent.getPaddingTop() + mDividerPaddingTop;
        int bottom = parent.getHeight() - parent.getPaddingBottom() - mDividerPaddingBottom;
        int childCount = parent.getChildCount();
        GradientDrawable divider = getDividerDrawable();
        if (mShowStart) {
            View child = parent.getChildAt(0);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            divider.setSize(bottom, mDividerSize);
            int left = child.getLeft() + params.leftMargin;
            int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
        for (int i = 0; i < childCount; i++) {
            if (!mShowEnd && i == childCount - 1) {
                return;
            }
            View child = parent.getChildAt(i);
            divider.setSize(bottom, mDividerSize);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(child));
            int right = left + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }


    public static class Builder {

        private int color;

        private int size;

        private int paddingTop;

        private int paddingBottom;

        private boolean showStart;

        private boolean showEnd;

        public Builder paddingTop(int paddingTop) {
            this.paddingTop = paddingTop;
            return this;
        }

        public Builder paddingBottom(int paddingBottom) {
            this.paddingBottom = paddingBottom;
            return this;
        }

        public Builder showStart(boolean showStart) {
            this.showStart = showStart;
            return this;
        }

        public Builder showEnd(boolean showEnd) {
            this.showEnd = showEnd;
            return this;
        }

        public Builder color(@ColorInt int color) {
            this.color = color;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public HorizontalItemDecoration build() {
            return new HorizontalItemDecoration(this);
        }
    }
}
