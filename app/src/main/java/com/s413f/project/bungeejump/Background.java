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

    private Bitmap background;

    private static int bgX = 0;




    public Background(Context context) {
        background = BitmapFactory.decodeResource(context.getResources(),R.drawable.waterfall0);
        int scaledWidth = (int) (background.getWidth() * (PigView.arenaHeight / (float) background.getHeight()));
        background = Bitmap.createScaledBitmap(background, scaledWidth, PigView.arenaHeight, true);
    }


    public void drawOn(Canvas canvas) {
        if (background != null) {

            canvas.drawBitmap(background, bgX, bgX, null);

        }
    }


}