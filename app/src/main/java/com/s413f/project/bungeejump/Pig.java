package com.s413f.project.bungeejump;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.s413f.project.bungeejump.R.id.imageView1;

/**
 * Created by Ashley Wong on 13/11/2016.
 */

public class Pig extends AppCompatActivity {
    final AnimationDrawable jumpPig = new AnimationDrawable();

    public Pig() {
       /* for (int id : new int[]{R.drawable.pig1,
                R.drawable.pig3,
                R.drawable.pig5}) {
            jumpPig.addFrame(getResources().getDrawable(id), 200);
        }*/

       ImageView button1 = (ImageView) findViewById(R.id.imageView1);
        /*button1.setImageDrawable(jumpPig);*/
        button1.setOnTouchListener(new View.OnTouchListener(){

                    float dX, x;

                    @Override
                    public boolean onTouch(View view, MotionEvent event) {

                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:
                                dX = view.getX() - event.getRawX();
                                x = event.getRawX() + dX;

                                break;

                            case MotionEvent.ACTION_MOVE:
                                view.animate()
                                        .x(event.getRawX() + dX)
                                        .setDuration(0)
                                        .start();
                                break;
                            default:
                                return false;

                        }
                        return true;
                    }
         });
   }
}

