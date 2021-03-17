package com.example.clonemovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView thumbUp, thumbDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbUp = (ImageView) findViewById(R.id.thumbUp);
        thumbDown = (ImageView) findViewById(R.id.thumbDown);
    }

    public void thumbUpClicked(View v) {
        System.out.println("thumb up clicked");
    }

    public void thumbDownClicked(View v) {
        System.out.println("thumb down clicked");
    }
}