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

public class MainActivity extends AppCompatActivity {
    EditText a1,a2;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("EntryLog",MODE_PRIVATE);
        String username = pref.getString("user",null);
        if(username!=null)
        {
            Intent i = new Intent(getApplicationContext(),Menu.class);
            startActivity(i);
        }
        a1 = (EditText)findViewById(R.id.uname);
        a2 = (EditText)findViewById(R.id.pass);
        b1 = (AppCompatButton)findViewById(R.id.signbtn);
        b2 = (AppCompatButton)findViewById(R.id.logbtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = a1.getText().toString();
                    String s2 = a2.getText().toString();
                    Intent i = new Intent(getApplicationContext(),SignUP.class);
                    startActivity(i);
                    }


                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(), "invalid ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = a1.getText().toString();
                String s2 = a2.getText().toString();
                if (s1.equals("admin") && s2.equals("12345")) {
                    SharedPreferences pref = getSharedPreferences("EntryLog", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("user", "admin");
                    editor.apply();
                    Toast.makeText(getApplicationContext(),"loggin in..",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Menu.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"invalid credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}