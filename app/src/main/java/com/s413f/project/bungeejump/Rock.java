package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Ashley Wong on 13/11/2016.
 */

public class Rock extends Sprite {

    private float dy = Background.SpeedYMagnitude;

    /** Constructor. */
    public Rock( Context context) {
        drawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.rock);


        int y = 0 ;


        // ii. Randomize y position of the upper obstacle
        int minX = 0;
        int maxX = (int) (PigView.arenaWidth - getWidth());
        int x = minX + (int) (Math.random() * (maxX - minX));

        // iii. Upper and lower obstacles creation
        setPosition(x, y);
    }

    public void defaultRock(int y) {
        int minX = 0;
        int maxX = (int) (PigView.arenaWidth - getWidth());
        int x = minX + (int) (Math.random() * (maxX - minX));
        setPosition(x, y);
    }
    @Override
    /** Move the obstacle. */
    public void move() {
        if (dy != 0) {
            // Update the new 4 position of the obstacle
            curPos.y += dy ;

            // Update the boundary of the obstacle drawable
            updateBounds();
        }
    }

    @Override
    /** Evaluate if the obstacle has moved out from the arena. */
    public boolean isOutOfArena() {
        if (getCurPos().y + getHeight() < 0)
            return true;
        return false;
    }
}
