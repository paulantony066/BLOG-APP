package com.example.blogapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Addpost extends AppCompatActivity {
    EditText a1,a2,a3;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addpost);
        a1 = (EditText)findViewById(R.id.title);
        a2 = (EditText)findViewById(R.id.description);
        a3 = (EditText)findViewById(R.id.name);
        b1=(AppCompatButton)findViewById(R.id.submit);
        b2=(AppCompatButton)findViewById(R.id.back);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = a1.getText().toString();
                    String s2 = a2.getText().toString();
                    String s3 = a3.getText().toString();
                    Toast.makeText(getApplicationContext(),s1 + " "+s2+" "+s3, Toast.LENGTH_SHORT).show();
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Menu.class);
                startActivity(i);
            }
        });
    }
}