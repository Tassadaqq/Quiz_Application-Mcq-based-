package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView name_field,etscore;
    Button btnShare;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        //name that was passed from the MainActivity
        String name = getIntent().getStringExtra("name");
        //score passed from quiz activity
        int score=getIntent().getIntExtra("score",0);
        message ="Congrats "+name+" you have scored "+score+"/10 in Quiz App.";
        name_field.setText(name);
        etscore.setText(score+"/10");

        btnShare.setOnClickListener(v -> share());

    }
    public void share()
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(Intent.createChooser(i, "Share your score"));
    }
    public void init(){
        name_field=findViewById(R.id.name_field);
        etscore=findViewById(R.id.etscore);
        btnShare=findViewById(R.id.btnShare);
    }
}
