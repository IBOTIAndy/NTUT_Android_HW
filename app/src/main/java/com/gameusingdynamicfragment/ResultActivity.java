package com.gameusingdynamicfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private EditText mEdtCountSet,
            mEdtCountPlayerWin,
            mEdtCountComWin,
            mEdtCountDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mEdtCountSet = (EditText) findViewById(R.id.edtCountSet);
        mEdtCountPlayerWin = (EditText) findViewById(R.id.edtCountPlayerWin);
        mEdtCountComWin = (EditText) findViewById(R.id.edtCountComWin);
        mEdtCountDraw = (EditText) findViewById(R.id.edtCountDraw);

        Intent intent = getIntent();

        mEdtCountSet.setText(String.valueOf(intent.getIntExtra("CountSet", 0)));
        mEdtCountPlayerWin.setText(String.valueOf(intent.getIntExtra("CountPlayerWin", 0)));
        mEdtCountComWin.setText(String.valueOf(intent.getIntExtra("CountComWin", 0)));
        mEdtCountDraw.setText(String.valueOf(intent.getIntExtra("CountDraw", 0)));

    }
}
