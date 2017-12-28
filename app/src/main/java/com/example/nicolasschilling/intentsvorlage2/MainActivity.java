package com.example.nicolasschilling.intentsvorlage2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button safebtn;
    Button filesafebtn;
    ArrayList<Data> datenliste = new ArrayList<>();
    public static final String parKEY = "parKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        safebtn = (Button) findViewById(R.id. safebtn);
        filesafebtn =(Button) findViewById(R.id.filesafebtn);




                safebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Data newdata = new Data (editText.getText().toString());
                        datenliste.add(newdata);
                        senddata();

                    }
                });

        filesafebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (FileWriter.saveFile(editText.getText().toString())) {
                            Toast.makeText(MainActivity.this, "Has been safed", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void senddata(){
        Intent myIntent = new Intent (MainActivity.this, ShowMe.class);
        myIntent.putExtra(parKEY, datenliste.get(datenliste.size()-1));
        startActivity(myIntent);


    }
}
