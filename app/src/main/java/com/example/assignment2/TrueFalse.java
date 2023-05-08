package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class TrueFalse extends AppCompatActivity {
    RecyclerView recyclerView;
    Button submit;
    int score=0;
    TextView sc;
    ArrayList <ModelClass> trueFalse=new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false);

        submit=findViewById(R.id.submit);
        submit.setEnabled(true);
        sc=findViewById(R.id.score);


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        trueFalse.add(new ModelClass("Android development uses Java as its primary programming language.","T"));
        trueFalse.add(new ModelClass("All Android devices run on the same version of the operating system.","F"));
        trueFalse.add(new ModelClass("Android Studio is the official integrated development environment (IDE) for Android development.","T"));
        trueFalse.add(new ModelClass("Android apps can only be downloaded from the Google Play Store.","F"));
        trueFalse.add(new ModelClass("Android apps can be developed using Windows, Mac, and Linux operating systems.","T"));
        trueFalse.add(new ModelClass("Android devices can only run one app at a time.","F"));
        trueFalse.add(new ModelClass("Android development requires a physical Android device to test apps.","F"));
        trueFalse.add(new ModelClass("Android development does not require any knowledge of XML.","F"));
        trueFalse.add(new ModelClass("Android development is only for mobile devices","F"));
        trueFalse.add(new ModelClass("Android development is a rapidly growing field with a high demand for skilled developers","T"));

        AdapterClass adapterClass=new AdapterClass(getApplicationContext(),trueFalse);
        recyclerView.setAdapter(adapterClass);
        submit.setOnClickListener(new View.OnClickListener() {
           // final int[] id =adapterClass.getArr();
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                score=adapterClass.getCount();
                /*int i;
                for(i=0; i<trueFalse.size(); i++) {
                    if (Objects.equals(id[i],1) && Objects.equals(trueFalse.get(i).ans,"T")){
                        score++;
                    } else if (Objects.equals(id[i],0) && Objects.equals(trueFalse.get(i).ans,"F")) {
                        score++;
                    }
                }*/
                sc.setText("Score: "+score);
                submit.setEnabled(false);
            }
        });

    }
}