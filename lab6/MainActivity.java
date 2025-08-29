package com.example.lab3;

import static com.example.lab3.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button aboutMeButton,addNoteButton,addCheckListButton,displayNoteButton;
    ImageView logo;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        aboutMeButton = findViewById(R.id.button);//event source
        logo = findViewById(id.imageView);
        logo.setImageResource(drawable.download);

        aboutMeButton.setOnClickListener(new View.OnClickListener() { //event listener
            @Override
            public void onClick(View view) { //event handler
            //do some thing
            System.out.println("Click");
            Intent aboutMeActivity = new Intent(getApplicationContext(),AboutMeActivity.class);
            startActivity(aboutMeActivity);
            }
        });

        addNoteButton = findViewById(id.button4);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Add");
                Intent addNoteActivity = new Intent(getApplicationContext(),AddNoteActivity.class);
                startActivity(addNoteActivity);
            }
        });
        addCheckListButton = findViewById(R.id.button7);
        addCheckListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("AddCheckList");
                Intent addCheckListActivity = new Intent(getApplicationContext(),AddCheckListActivity.class);
                startActivity(addCheckListActivity);
            }
        });
        progressBar = findViewById(id.progressBar);
        progressBar.setVisibility(View.GONE);
        displayNoteButton = findViewById(id.button9);
        displayNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show progress bar
                progressBar.setVisibility(View.VISIBLE);
                //create thread
                new Thread(() -> {
                    //delay/sleep 2 seconds
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //load data from database
                    //back to main thread
                    runOnUiThread(() -> {
                        //remove progress bar
                        progressBar.setVisibility(View.GONE);
                        //go to Add Note Activity
                        Intent displayNoteAct = new Intent(getApplicationContext(),DisplayNoteActivity.class);
                        startActivity(displayNoteAct);
                    });
                }).start();
            }
        });
    }
}


