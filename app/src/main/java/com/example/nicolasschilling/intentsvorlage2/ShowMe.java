package com.example.nicolasschilling.intentsvorlage2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShowMe extends AppCompatActivity {

    TextView txtview;
    Button loadbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showme);

        txtview = (TextView) findViewById(R.id.textView);
        loadbtn = (Button) findViewById(R.id.loadbtn);


        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }



    //LOADDATA
    private void loadData() {
        if (getIntent().getExtras() != null) {
            Data load_data = getIntent().getParcelableExtra(MainActivity.parKEY);
            if (load_data != null) {
                txtview.setText(load_data.getDaten());
            }
        }
    }
}





