package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class SignUP extends AppCompatActivity {
    EditText a1,a2,a3,a4;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        a1 =(EditText)findViewById(R.id.name);
        a2 =(EditText)findViewById(R.id.admn);
        a3 =(EditText)findViewById(R.id.pass1);
        a4 =(EditText)findViewById(R.id.pass2);
        b1 =(AppCompatButton) findViewById(R.id.add);
        b2 =(AppCompatButton) findViewById(R.id.log);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = a1.getText().toString();
                String s2 = a2.getText().toString();
                String s3 = a3.getText().toString();
                String s4 = a4.getText().toString();
                if (s3.equals(s4))
                {
                    Toast.makeText(getApplicationContext(), "signed up", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), Menu.class);
                startActivity(i);
                }
                else if(!s3.equals(s4))
                {
                    Toast.makeText(getApplicationContext(), "passwords dont match", Toast.LENGTH_SHORT).show();
                }

            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("EntryLog",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.apply();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}