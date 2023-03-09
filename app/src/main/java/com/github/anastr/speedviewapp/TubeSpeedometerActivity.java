package com.github.anastr.speedviewapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.anastr.speedviewlib.TubeSpeedometer;
import com.github.anastr.speedviewlib.components.indicators.ImageIndicator;

import java.util.Locale;

public class TubeSpeedometerActivity extends AppCompatActivity {

    TubeSpeedometer tubeSpeedometer;
    SeekBar seekBar;
    Button ok;
    TextView textSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tube_speedometer);
        setTitle("Tube Speedometer");

        tubeSpeedometer = findViewById(R.id.speedometer);
        seekBar = findViewById(R.id.seekBar);
        ok = findViewById(R.id.ok);
        textSpeed = findViewById(R.id.textSpeed);

        ImageIndicator imageIndicator = new ImageIndicator(getApplicationContext()
                , ContextCompat.getDrawable(this, R.drawable.indicator_draw));
        tubeSpeedometer.setIndicator(imageIndicator);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tubeSpeedometer.speedTo(seekBar.getProgress());
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSpeed.setText(String.format(Locale.getDefault(), "%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
