package com.example.scratchcard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ScratchView scratchCard;
    TextView textView;
    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scratchCard = findViewById(R.id.scratchView);
        textView = findViewById(R.id.textView);

        Random random = new Random();

        int num = random.nextInt(10000)+1;

        textView.setText("You Won\n$" + num);

        scratchCard.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(MainActivity.this, "You Won!!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
//                Log.d("You Won!!!", String.valueOf(percent));
//                Toast.makeText(MainActivity.this, String.valueOf(percent), Toast.LENGTH_SHORT).show();
            }
        });
    }
}