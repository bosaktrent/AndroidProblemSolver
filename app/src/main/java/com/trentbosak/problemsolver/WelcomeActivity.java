package com.trentbosak.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void startFarmerIntro(View view) {
        Intent intent = new Intent(this, FarmerIntroActivity.class);
        startActivity(intent);
    }

    public void startPuzzleIntro(View view) {
        Intent intent = new Intent(this, PuzzleIntroActivity.class);
        startActivity(intent);
    }
}
