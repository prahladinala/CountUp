package com.example.countup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView countUp;
    Button incremnt, decremnt;
    int CounterStart = 0;
    Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        countUp = findViewById(R.id.counter);
        incremnt = findViewById(R.id.incre);
        decremnt = findViewById(R.id.decre);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        countUp.setText("0");

        incremnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CounterStart = CounterStart + 1;
                vibe.vibrate(50);
                countUp.setText(String.valueOf(CounterStart));
                Toast.makeText(MainActivity.this,""+CounterStart , Toast.LENGTH_SHORT).show();

            }
        });
        decremnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CounterStart = CounterStart - 1;
                vibe.vibrate(50);
                countUp.setText(String.valueOf(CounterStart));
                Toast.makeText(MainActivity.this,""+CounterStart , Toast.LENGTH_SHORT).show();
            }
        });
        incremnt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                countUp.setText("0");
                Toast.makeText(MainActivity.this,"Counter Reset", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        decremnt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                countUp.setText("0");
                Toast.makeText(MainActivity.this,"Counter Reset", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    @Override
    public void onBackPressed() {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Really Exit?")
                    .setMessage("Are you sure you want to exit?")
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface arg0, int arg1) {
                            setResult(RESULT_OK, new Intent().putExtra("EXIT", true));
                            finish();
                        }

                    }).create().show();

    }
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus) {
//            getWindow().getDecorView().setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }



}
