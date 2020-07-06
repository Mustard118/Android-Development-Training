package com.example.androidtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_click);
        final TextView tv=findViewById(R.id.tv_title);
        final ImageView iv=findViewById(R.id.iv_background);
        final ProgressBar pb=findViewById(R.id.pb_loading);
        EditText et=findViewById(R.id.et_log);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                int progress=pb.getProgress();
                progress+=10;
                pb.setProgress(progress);
                float alpha=iv.getAlpha();
                alpha+=0.2;
                iv.setAlpha(alpha);
                if(progress==pb.getMax()){
                    pb.setVisibility(View.INVISIBLE);
                    tv.setText("Happy Birthday!!!");
                    Log.i("MainActivity","onClick:Happy birthday!");
                }
                if(progress>pb.getMax()) {
                    progress=0;
                    pb.setProgress(progress);
                    alpha=0;
                    iv.setAlpha(alpha);
                }
                Log.i("MainActivity","onClick:Progress");
            }
        });
    }
}
