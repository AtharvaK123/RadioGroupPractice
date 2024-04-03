package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.Debug;

import android.annotation.SuppressLint;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    Button button;
    RadioButton rb, rb1;
    ImageView i1, i2, i3;
    TextView total, result;
    int sum = 0;
    int i = (int) (Math.random() * 2) + 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.RadioGroup);
        button = findViewById(R.id.button);
        i1 = findViewById(R.id.imageView);
        i2 = findViewById(R.id.imageView2);
        i3 = findViewById(R.id.imageView3);
        total = findViewById(R.id.total);
        result = findViewById(R.id.result);
        rb = findViewById(R.id.radioButton2);
        rb1 = findViewById(R.id.radioButton2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb.isChecked() || rb1.isChecked()) {
                    if (i == 1) {
                        i1.setVisibility(View.INVISIBLE);
                        i2.setVisibility(View.VISIBLE);
                        i3.setVisibility(View.INVISIBLE);
                    }
                    if (i == 2) {
                        i1.setVisibility(View.INVISIBLE);
                        i2.setVisibility(View.INVISIBLE);
                        i3.setVisibility(View.VISIBLE);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Choose One Option", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                if (j == R.id.radioButton) {
                    sum += 1;
                } else if (j == R.id.radioButton2) {
                    sum += 2;
                }

                if(i == 1){
                    sum += 1;
                }
                else if(i == 2){
                    sum += 2;
                }

                total.setText(sum + "");
                if (sum % 2 == 1) {
                    result.setText("Computer Wins");
                } else result.setText("You Win");
            }
        });
    }
}

