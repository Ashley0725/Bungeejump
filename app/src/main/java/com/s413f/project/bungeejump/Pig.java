package com.s413f.project.bungeejump;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;



/**
 * Created by Ashley Wong on 13/11/2016.
 */

public class Pig extends Sprite {
    static final float INITIAL_DY = 38;  // Initial velocity in vertical direction
    private float dy;  // y velocity of the flying android object

    /** Constructor. */
    public Pig(Drawable.Callback callback, Context context) {

            drawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.jumping_pig);
            drawable.setCallback(callback);

        dy = INITIAL_DY;
    }

    /** Reset the x, y position of the flying android. */
    public void reset() {
        // Add code here
        // Task 1: Reset the flying android
        // i. Locate it at the center of the arena
        float x = (PigView.arenaWidth - getWidth()) / 2.f;
        float y = (PigView.arenaHeight - getHeight()) ;

        // ii. Update its position
        setPosition(x, y);
    }

    public boolean jumping(float inity){
        if(curPos.y >= inity - 8*INITIAL_DY){
            return true;
        }
        return false;
    }

    /** Move the flying android upward.*/
    public void fly(float x) {
        curPos.x += (x - curPos.x)/3.f;
    }

    public void jump() {
        if(dy!=0) {
            curPos.y -= dy;
            updateBounds();
        }
    }
    @Override
    /** Move the flying android. */
    public void move() {
        if(dy!=0){
            curPos.y += dy;
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
