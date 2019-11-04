package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText basemoney;
    private EditText alldistance;
    private EditText adddistance;
    private EditText addmoney;
    private TextView total_TEXT;
    private Button button;
    int total_time,Add_M_cont,Add_dis_cont,total_dis_cont,Base_count,total_count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basemoney = findViewById(R.id.basemoney);
        alldistance = findViewById(R.id.alldistance);
        adddistance = findViewById(R.id.adddistance);
        addmoney = findViewById(R.id.addmoney);
        total_TEXT = findViewById(R.id.total_TEXT);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(basemoney.getText().toString().matches("")
                        || alldistance.getText().toString().matches("")
                        || adddistance.getText().toString().matches("")
                        ||addmoney.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不要空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Base_count = Integer.parseInt(basemoney.getText().toString());
                    total_dis_cont = Integer.parseInt(alldistance.getText().toString());
                    Add_dis_cont = Integer.parseInt(adddistance.getText().toString());
                    Add_M_cont = Integer.parseInt(addmoney.getText().toString());
                    total_time = total_dis_cont / Add_dis_cont;
                    if (total_dis_cont % Add_dis_cont != 0)
                        total_time++;
                    total_count = Base_count + total_time * Add_M_cont;
                    total_TEXT.setText(getString(R.string.TextView_TEXT) + total_count + "元");
                }

            }
        });


    }
}
