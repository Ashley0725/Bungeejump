package com.s413f.project.bungeejump;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;



public class StartGameActivity extends AppCompatActivity {

private PigView animationView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationView = new PigView(this);
        setContentView(animationView);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
        }

/**
 * Handles the option menu selection. This method is called when an options
 * menu item is selected.
 */
@Override
public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_restart:
        animationView.newGame(false);
        break;
        case R.id.action_pause:
        animationView.pause();
        break;
        case R.id.action_resume:
        animationView.resume();
        break;
        case R.id.action_howtoplay:
        break;
        }
        return false;
        }



/** Resumes the animation. This method is called when the activity is resumed. */
@Override
protected void onResume() {
        super.onResume();
        animationView.resume();
        }

/** Pauses the animation. This method is called when the activity is paused. */
@Override
protected void onPause() {
        super.onPause();
        animationView.pause();
        }




}
