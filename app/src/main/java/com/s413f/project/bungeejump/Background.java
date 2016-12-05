package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Ashley Wong on 15/11/2016.
 */

public class Background {
    /** Scrolling speed magnitude of background. */
    static final int SpeedXMagnitude = 48;
    /** Scrolling speed of background. */
    private static int speedX = 0;
    /** Bitmap of the background. */
    private Bitmap background;
    /** Drawing position of the background. */
    private static final int bgY = 0;
    private static int bgX = 0, bgX2;

    ;

    /** Constructor. */
    public Background(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.waterfall2);
        int scaledWidth = (int) (background.getWidth() * (PigView.arenaHeight / (float) background.getHeight()));
        background = Bitmap.createScaledBitmap(background, scaledWidth, PigView.arenaHeight, true);
    }

    public void roll(){
        speedX = SpeedXMagnitude;
        // Decrement the position of the first background bitmap
        bgX += speedX;

        // Calculate the position of the second background bitmap
        bgX2 =  bgX - background.getHeight()  ;

    }



    public void stop() {
        speedX = 0;
    }

    /** Draws the background. */
    public void drawOn(Canvas canvas) {
        if (background != null) {


            // If the second bitmap moving out from the view, reset the first one to start again
            if (bgX2 >=0 ) {
                bgX = 0;
                // Only need to draw one bitmap (the first one)
                canvas.drawBitmap(background, bgX, bgX, null);
            } else {
                // Two bitmaps are needed to be drawn
                canvas.drawBitmap(background, bgY, bgX, null);
                canvas.drawBitmap(background, bgY, bgX2, null);
            }
        }
    }
}
