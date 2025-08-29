package com.example.lab3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button submitButton;
    EditText title,textContent,nameUser;
    TextView display;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        submitButton = findViewById(R.id.button3);
        title = findViewById(R.id.editTextText);
        textContent = findViewById(R.id.editTextText2);
        nameUser = findViewById(R.id.editTextText3);
        display = findViewById(R.id.textView4);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from user (EditText)
                String stringOfTitle = title.getText().toString();
                String stringOfContent = textContent.getText().toString();
                String userName = nameUser.getText().toString();
                Date currentDate = new Date();

                User user = new User(userName);

                //create data in TextNote class
                TextNote note = new TextNote();
                note.setTitle(stringOfTitle);
                note.setTextContent(stringOfContent);
                note.createdDate = currentDate;
                note.setOwner(user);

                //show data
                display.setText(note.display());
            }
        });
    }
}