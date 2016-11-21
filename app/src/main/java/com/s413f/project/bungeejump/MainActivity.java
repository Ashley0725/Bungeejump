package com.s413f.project.bungeejump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView StartGameLink = (TextView) findViewById(R.id.tvStartgame);


        StartGameLink.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent startgameIntent = new Intent(MainActivity.this,StartGameActivity.class);
                                                 MainActivity.this.startActivity(startgameIntent);
                                             }
                                         });


    }
}
