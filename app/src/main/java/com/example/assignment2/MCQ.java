package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MCQ extends AppCompatActivity {
    TextView ques,count,score;
    RadioButton op1,op2,op3,op4,op5;
    RadioGroup rg;
    Button check,next;
    int a=0,j=0,sc=0,c=1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);
        Toast.makeText(MCQ.this, "Press Check Button to verify Answer", Toast.LENGTH_SHORT).show();
        ques=(TextView)findViewById(R.id.tv2);
        op1=(RadioButton)findViewById(R.id.rb1);
        op2=(RadioButton)findViewById(R.id.rb2);
        op3=(RadioButton)findViewById(R.id.rb3);
        op4=(RadioButton)findViewById(R.id.rb4);
        rg=(RadioGroup)findViewById(R.id.rg);
        check=(Button)findViewById(R.id.answer);
        next=(Button)findViewById(R.id.next);
        count=(TextView)findViewById(R.id.count);
        score=(TextView)findViewById(R.id.point);

        String[] que =getResources().getStringArray(R.array.questions);
        String[] op =getResources().getStringArray(R.array.options);
        int[] correct={3,4,9,14,18,22,27,31,32,38};
        count.setText(""+c+" "+"out of 10");
        score.setText("Points Scored : "+sc);
        ques.setText(que[0]);
        op1.setText(op[0]);
        op2.setText(op[1]);
        op3.setText(op[2]);
        op4.setText(op[3]);
        op1.setChecked(false);
        check.setEnabled(false);
        next.setEnabled(false);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                op5=(RadioButton)findViewById(i);
                check.setEnabled(true);
                next.setEnabled(false);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(Objects.equals(op5.getText(),op[correct[a]])){
                    Toast.makeText(MCQ.this, "Correct", Toast.LENGTH_SHORT).show();
                    if(Objects.equals(op1.getText(),op[correct[a]])){
                        op1.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op2.getText(),op[correct[a]])) {
                        op2.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op3.getText(),op[correct[a]])) {
                        op3.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op4.getText(),op[correct[a]])) {
                        op4.setTextColor(0xFF6FD52F);
                    }
                    sc++;
                    score.setText("Points Scored : "+sc);
                } else if (!(Objects.equals(op5.getText(),op[correct[a]]))){
                    Toast.makeText(MCQ.this, "Wrong", Toast.LENGTH_SHORT).show();
                    if(Objects.equals(op1.getText(),op[correct[a]])){
                        op1.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op2.getText(),op[correct[a]])) {
                        op2.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op3.getText(),op[correct[a]])) {
                        op3.setTextColor(0xFF6FD52F);
                    } else if (Objects.equals(op4.getText(),op[correct[a]])) {
                        op4.setTextColor(0xFF6FD52F);
                    }
                }
                op1.setEnabled(false);
                op2.setEnabled(false);
                op3.setEnabled(false);
                op4.setEnabled(false);
                check.setEnabled(false);
                next.setEnabled(true);
            }

        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check.setEnabled(false);
                op1.setChecked(false);
                op2.setChecked(false);
                op3.setChecked(false);
                op4.setChecked(false);
                op1.setEnabled(true);
                op2.setEnabled(true);
                op3.setEnabled(true);
                op4.setEnabled(true);
                op1.setTextColor(0xFF000000);
                op2.setTextColor(0xFF000000);
                op3.setTextColor(0xFF000000);
                op4.setTextColor(0xFF000000);
                a++;
                j+=4;
                ques.setText(que[a]);
                op1.setText(op[j]);
                op2.setText(op[j+1]);
                op3.setText(op[j+2]);
                op4.setText(op[j+3]);
                c++;
                count.setText(""+c+" "+"out of 10");
                if(c==10)
                    next.setEnabled(false);

            }
        });

    }
}