package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    TextView question,q_no;
    Button btnNext,btnPrev;
    RadioButton opt1,opt2,opt3, opt4;
    RadioGroup quiz;
    int q_index=0,score=0;
    String [] questions={"What is capital of Pakistan?","What is favorite game of Tassadaq?"
    ,"Which is the best uni of pakistan?","2+2?","4+6","7-1","9*9","9/9","9+9","2+5"};
    String [][]options={{"LHR","ISB","FSD","KHI"},
            {"VOLLEYBALL","CRICKET","SNOOKER","FOOTBALL"},
            {"IBA","LUMS","COMSAT","FAST"},
            {"4","5","6","8"},
            {"4","5","10","8"},
            {"4","5","6","8"},
            {"4","5","6","81"},
            {"4","5","6","1"},
            {"4","5","6","18"},
            {"4","5","6","7"}};
    String []correct ={"ISB","SNOOKER","LUMS","4","10","6","81","1","18","7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        //name that was passed from the MainAcitivity
        String name = getIntent().getStringExtra("name");
        setQuestion();
        btnNext.setOnClickListener(v ->{
            checkAnswer();
            q_index++;
            if(q_index<questions.length){
                setQuestion();
            }
            else {
                Intent i=new Intent(QuizActivity.this,ResultActivity.class);
                i.putExtra("name",name);
                i.putExtra("score",score);
                startActivity(i);
                finish();
            }
        });
        btnPrev.setOnClickListener(v -> {
            if(q_index>0){
                q_index--;
                setQuestion();
            }
        });
    }
    private void checkAnswer(){
        String selected_option="";
        if(opt1.isChecked()){
            selected_option=opt1.getText().toString();
        }
        else if(opt2.isChecked()){
            selected_option=opt2.getText().toString();
        }
        else if(opt3.isChecked()){
            selected_option=opt3.getText().toString();
        }
        else if(opt4.isChecked()){
            selected_option=opt4.getText().toString();
        }

        if(selected_option.equals(correct[q_index])){
            score++;
        } else if (score>0) {
            score--;
        }
    }
    //sets the question once previous or next button cliks
    private void setQuestion(){
        if (q_index==0){
            btnPrev.setEnabled(false);
        }
        else {
            btnPrev.setEnabled(true);
        }
        q_no.setText("Question " + (q_index + 1));
        question.setText(questions[q_index]);

        opt1.setText(options[q_index][0]);
        opt2.setText(options[q_index][1]);
        opt3.setText(options[q_index][2]);
        opt4.setText(options[q_index][3]);

        quiz.clearCheck();
    }
    private void init(){
        opt2=findViewById(R.id.opt2);
        opt1=findViewById(R.id.opt1);
        opt3=findViewById(R.id.opt3);
        opt4=findViewById(R.id.opt4);
        btnNext=findViewById(R.id.btnNext);
        btnPrev=findViewById(R.id.btnPrev);
        question=findViewById(R.id.question);
        quiz=findViewById(R.id.quiz);
        q_no=findViewById(R.id.q_no);
    }
}
