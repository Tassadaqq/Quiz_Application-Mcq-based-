package com.example.quiz_app;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString().trim();
                checkName(name);
            }
        });
    }
    private void checkName(String name){
        //if it is an empty string
        if(name.isEmpty()){
            etName.setError("Name cannot be empty");
            return;
        }
        //iterate each element if there are special characters or not
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            // Check if the character is not a letter or a space
            if (!Character.isLetter(c) && c!=' ') {
                etName.setError("Name must only contain letters and spaces");
                return ;
            }
        }
        Intent i=new Intent(MainActivity.this,QuizActivity.class);
        i.putExtra("name",name);
        startActivity(i);
        finish();
    }
    private void init()
    {
        etName = findViewById(R.id.etName);
        btnStart = findViewById(R.id.btnStart);
    }
}