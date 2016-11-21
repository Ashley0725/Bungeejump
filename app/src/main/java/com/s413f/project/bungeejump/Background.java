package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by Ashley Wong on 15/11/2016.
 */

public class Background {
    /** Scrolling speed magnitude of background. */
    static final int SpeedYMagnitude = 4;
    /** Scrolling speed of background. */
    private static int speedY = 0;
    /** Bitmap of the background. */
    private Bitmap background;
    /** Drawing position of the background. */
    private static  int bgY = 0, bgY2;
    private static final int bgX = 0;

    /** Constructor. */
    public Background(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.waterfall0);
        int scaledWidth = (int) (background.getWidth() * (PigView.arenaHeight / (float) background.getHeight()));
        background = Bitmap.createScaledBitmap(background, scaledWidth, PigView.arenaHeight, true);
    }

    /** Stop scrolling background. */
    public void stop(boolean stop) {
        if (stop)
            speedY = 0;
        else
            speedY = SpeedYMagnitude;
    }

    /** Draws the background. */
    public void drawOn(Canvas canvas) {
        if (background != null) {
            // Decrement the position of the first background bitmap
            bgY += speedY;

            // Calculate the position of the second background bitmap
            bgY2 = background.getHeight() + bgY;

            // If the second bitmap moving out from the view, reset the first one to start again
            if (bgY2 <= 0) {
                bgY = 0;
                ///Only need to draw one bitmap (the first one)
               canvas.drawBitmap(background, 0, 0, null);
            } else {
                // Two bitmaps are needed to be drawn
                canvas.drawBitmap(background, bgX, bgY, null);
                canvas.drawBitmap(background, bgX, bgY2, null);
            }
        }
    }
}
