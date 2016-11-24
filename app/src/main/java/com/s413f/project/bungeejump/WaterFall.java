package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Ashley Wong on 24/11/2016.
 */

public class WaterFall {
    Drawable drawable;
    final private PointF curPos = new PointF();
    /**
     * Constructor.
     */
    public WaterFall(Context context) {
        drawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.waterfall);
        float x = (PigView.arenaWidth - getWidth()) / 2.f;
        float y = (PigView.arenaHeight - getHeight())/2.f;
        ((AnimationDrawable)drawable).start();

        // ii. Update its position
        setPosition(x, y);
    }
    public int getWidth() {
        return drawable.getIntrinsicWidth();
    }

    /** Returns the height of this sprite. */
    public int getHeight() {
        return drawable.getIntrinsicHeight();
    }

    /** Returns the position of the sprite. */
    public PointF getCurPos() {
        return curPos;
    }

    /** Returns the bounds of this sprite. */
    public Rect getBounds() {
        return drawable.getBounds();
    }

    /** Returns the bitmap of this sprite. */
    public Bitmap getBitmap() {
        return ((BitmapDrawable) drawable.getCurrent()).getBitmap();
    }

    /** Returns the drawable for this sprite. */
    public Drawable getDrawable() {
        return drawable;
    }


    public void setPosition(float x, float y) {
        curPos.set(x, y);
        updateBounds();
    }

    /** Updates the bounds of the drawable for drawing. */
    public void updateBounds() {
        if (drawable != null) {
            drawable.setBounds((int) curPos.x, (int) curPos.y, (int) curPos.x + getWidth(), (int) curPos.y + getHeight());
        }
    }

    /** Draws this sprite. */
    public void drawOn(Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }
}
