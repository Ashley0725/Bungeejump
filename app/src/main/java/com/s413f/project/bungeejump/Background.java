package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Ashley Wong on 15/11/2016.
 */

public class Background extends Sprite {
    /** Scrolling speed magnitude of background. */
    static final int SpeedYMagnitude = 20;
    /** Scrolling speed of background. */
    private static int speedY = 0;

    /** Drawing position of the background. */
    private static  int bgY = 0, bgY2;
    private static final int bgX = 0;

    /** Constructor. */
    public Background(Drawable.Callback callback, Context context) {
         drawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.waterfall);
        drawable.setCallback(callback);
        drawable.setBounds(0,0,PigView.arenaWidth,PigView.arenaHeight);

        float x = (PigView.arenaWidth - getWidth()) / 2.f;
        float y = (PigView.arenaHeight - getHeight())/2.f ;

        setPosition(x, y);
    }



    /** Stop scrolling background. */
    public void stop(boolean stop) {
        ((AnimationDrawable)(getDrawable())).stop();
    }

    /** Draws the background.
    public void drawOn(Canvas canvas) {
        if (drawable != null) {
            // Decrement the position of the first background bitmap
            bgY += speedY;

            // Calculate the position of the second background bitmap
            bgY2 = drawable.getIntrinsicHeight() + bgY;

            // If the second bitmap moving out from the view, reset the first one to start again
            if (bgY2 <= 0) {
                bgY = 0;
                ///Only need to draw one bitmap (the first one)
               canvas.drawBitmap(drawable, 0, 0, null);
            } else {
                // Two bitmaps are needed to be drawn
                canvas.drawBitmap(drawable, bgX, bgY, null);
                canvas.drawBitmap(drawable, bgX, bgY2, null);
            }
        }
    }*/
    @Override
    /** Move the flying android. */
    public void move() {
        if(SpeedYMagnitude!=0){
            curPos.y += SpeedYMagnitude;
        }
        updateBounds();
    }

    @Override
    /** Evaluate if the pig is moving out of the arena, i.e., game end. */
    public boolean isOutOfArena() {
        if (curPos.y < 0 || curPos.y > PigView.arenaHeight - getHeight() + 50)
            return true;
        return false;
    }
}


