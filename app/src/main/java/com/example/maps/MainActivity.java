package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button bt1,bt2;
    EditText b1,c1,c2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1=findViewById(R.id.btn1);
        b1=findViewById(R.id.editTone);
        c1= findViewById(R.id.editTone2);
        c2=findViewById(R.id.editTone3);


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maps2.class);
                intent.putExtra("PTA", c1.getText().toString());
                intent.putExtra("dest",c2.getText().toString());
                startActivity(intent);
            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Maps.class);
                intent.putExtra("nombre", b1.getText().toString());
                startActivity(intent);
            }
        });
    }
}