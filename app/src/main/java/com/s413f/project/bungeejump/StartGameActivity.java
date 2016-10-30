package com.s413f.project.bungeejump;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static com.s413f.project.bungeejump.R.id.imageView1;

public class StartGameActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        img = (ImageView) findViewById(imageView1);
        img.setOnTouchListener(imgListener);//觸控時監聽
    }



    private View.OnTouchListener imgListener = new View.OnTouchListener() {

        float dX,x;

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
    };
}
