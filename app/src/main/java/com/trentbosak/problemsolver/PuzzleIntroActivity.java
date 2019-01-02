package com.trentbosak.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableLayout;

public class PuzzleIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_intro);
        Intent intent = getIntent();
    }

    public void startPuzzleProblem(View view) {
        Intent intent = new Intent(this, PuzzleActivity.class);
        startActivity(intent);
    }
}
