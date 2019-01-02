package com.trentbosak.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FarmerIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_intro);
        Intent intent = getIntent();
    }

    public void startFarmerProblem(View view) {
        Intent intent = new Intent(this, FarmerActivity.class);
        startActivity(intent);
    }

}
