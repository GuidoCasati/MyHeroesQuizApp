package com.example.android.myheroesquizzapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textvw = new TextView(this);
        textvw.setText("WELCOME\nTO THE\nQUIZ");
        setContentView(textvw);
        textvw.setTextSize(66);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                setContentView(R.layout.activity_main);
                // to do after 3 seconds
            }
        }, 3000);
    }

    public void Score(View view) {
        int iScore = 0;
        RadioButton A1 = (RadioButton) findViewById(R.id.A1_okay);
        boolean bA1 = A1.isChecked();
        if (bA1) iScore += 2;

        RadioButton A2 = (RadioButton) findViewById(R.id.A2_Okay);
        boolean bA2 = A2.isChecked();
        if (bA2) iScore += 2;

        CheckBox A31 = (CheckBox) findViewById(R.id.A31_okay);
        boolean bA31 = A31.isChecked();
        CheckBox A33 = (CheckBox) findViewById(R.id.A33_Okay);
        boolean bA33 = A33.isChecked();
        CheckBox A32 = (CheckBox) findViewById(R.id.A32);
        boolean bA32 = A32.isChecked();
        CheckBox A34 = (CheckBox) findViewById(R.id.A34);
        boolean bA34 = A34.isChecked();
        if (bA31 && bA33 && !bA32 && !bA34) iScore += 4;

        EditText A4 = (EditText) findViewById(R.id.A4);
        String sA4 = A4.getText().toString().toLowerCase();
        if (sA4.contains("xavier")) iScore += 4;

        EditText A5 = (EditText) findViewById(R.id.A5);
        String sA5 = A5.getText().toString().toLowerCase().replace(" ", "");
        if (sA5.contains("maryjane")) iScore += 4;

        String sToast;
        if (iScore > 0) {
            sToast = getString(R.string.ToastPt1) + iScore + " " + getString(R.string.ToastPt2);

        } else sToast = "You scored 0 points :( \nLet's try again!";
        Toast toast = Toast.makeText(getApplicationContext(), sToast, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();

        return;
    }
}
