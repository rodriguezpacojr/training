package com.training.training;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    @BindView(R.id.pbwelcome) ProgressBar pbwelcome;
    @BindView(R.id.imgwelcome) ImageView imgwelcome;

    public static Activity activity;
    private Threads objT;

    @Override
    protected void onPause() {
        super.onPause();
        objT.cancel(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ButterKnife.bind(this);
        objT = new Threads(pbwelcome,this);
        objT.execute();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
