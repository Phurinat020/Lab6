package com.example.lab3;

import android.annotation.SuppressLint;
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

import java.util.Arrays;
import java.util.Date;

public class AddCheckListActivity extends AppCompatActivity {

    Button submitButton;
    EditText title,itemlist,nameUser;
    TextView display;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_check_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        submitButton = findViewById(R.id.button5);
        title = findViewById(R.id.editTextText6);
        itemlist = findViewById(R.id.editTextText5);
        nameUser = findViewById(R.id.editTextText4);
        display = findViewById(R.id.textView2);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from user (EditText)
                String stringOfTitle = title.getText().toString();
                String stringOfitemList = itemlist.getText().toString();
                String userName = nameUser.getText().toString();
                Date currentDate = new Date();

                User user = new User(userName);

                //create data in TextNote class
                CheckListNote note1 = new CheckListNote();
                note1.setTitle(stringOfTitle);
                note1.setItemList(Arrays.asList(stringOfitemList.split(",")));
                note1.createdDate = currentDate;
                note1.setOwner(user);

                //show data
                display.setText(note1.display());
            }
        });
    }
}