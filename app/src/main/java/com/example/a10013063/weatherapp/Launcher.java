package com.example.a10013063.weatherapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Launcher extends AppCompatActivity {

    EditText enterZip;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        enterZip = findViewById(R.id.id_enterZip);
        button = findViewById(R.id.id_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(enterZip.getText().toString().isEmpty()){
                    Snackbar.make(v,"Enter a Zip Code", Snackbar.LENGTH_SHORT).show();
                }
                else if(enterZip.getText().toString().length() != 5){
                    Snackbar.make(v,"Enter a Valid Zip Code", Snackbar.LENGTH_SHORT).setAction("Clear", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            enterZip.setText("");
                        }
                    }).show();
                }
                else{
                    Intent intent = new Intent(Launcher.this, MainActivity.class);
                    intent.putExtra("zip",enterZip.getText().toString());
                    startActivity(intent);
                }
            }
        });




    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("zip",enterZip.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        enterZip.setText(savedInstanceState.getString("zip"));
    }
}
