package com.yuan.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yuan on 29/11/2016.
 */

public class VerticalItemDecoration extends YItemDecoration {

    private int mDividerSize;

    private int mDividerPaddingLeft;

    private int mDividerPaddingRight;

    private boolean mShowStart;

    private boolean mShowEnd;


    private VerticalItemDecoration(Builder builder) {
        super(builder.color,builder.drawable);
        mDividerSize = builder.size;
        mDividerPaddingLeft = builder.paddingLeft;
        mDividerPaddingRight = builder.paddingRight;
        mShowStart = builder.showStart;
        mShowEnd = builder.showEnd;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, mDividerSize);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c, parent);
    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft() + mDividerPaddingLeft;
        int right = parent.getWidth() - parent.getPaddingRight() - mDividerPaddingRight;
        int childCount = parent.getChildCount();

        Drawable divider = getDividerDrawable();
        if (mShowStart) {
            View child = parent.getChildAt(0);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getTop() + params.topMargin;
            int bottom = top + divider.getIntrinsicHeight();
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }

        for (int i = 0; i < childCount; i++) {

            if (!mShowEnd && i == childCount - 1) {
                return;
            }
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDividerSize;
            divider.setBounds(left, top, right, bottom);
            divider.draw(c);
        }
    }


    public static class Builder {

        private int color;

        private int size;

        private int paddingLeft;

        private int paddingRight;

        private boolean showStart;

        private boolean showEnd;

        private Drawable drawable;

        public Builder drawable(Drawable drawable) {
            this.drawable = drawable;
            return this;
        }

        public Builder paddingLeft(int paddingLeft) {
            this.paddingLeft = paddingLeft;
            return this;
        }

        public Builder paddingRight(int paddingRight) {
            this.paddingRight = paddingRight;
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

        public VerticalItemDecoration build() {
            return new VerticalItemDecoration(this);
        }
    }
}
