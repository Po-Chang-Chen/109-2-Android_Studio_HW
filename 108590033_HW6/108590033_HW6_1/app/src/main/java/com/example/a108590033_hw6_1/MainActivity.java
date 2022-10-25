package com.example.a108590033_hw6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String ry;
    private Button toast1;
    private TextView tt1;
    private CheckBox chocolate,sprink,crush,cherries,orio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toast1= (Button) findViewById(R.id.button);
        chocolate=(CheckBox) findViewById(R.id.checkBox);
        sprink=(CheckBox) findViewById(R.id.checkBox2);
        crush=(CheckBox) findViewById(R.id.checkBox3);
        cherries=(CheckBox) findViewById(R.id.checkBox4);
        orio=(CheckBox) findViewById(R.id.checkBox5);
    }
    public void showToast(View view) {
        ry="Toppings:";
        if (chocolate.isChecked()) {
            ry = ry +" "+ chocolate.getText().toString();
        }
        if (sprink.isChecked()) {
            ry = ry+ " "+sprink.getText().toString();
        }
        if (crush.isChecked()) {
            ry = ry +" " + crush.getText().toString();
        }
        if (cherries.isChecked()) {
            ry = ry+" " + cherries.getText().toString();
        }
        if (orio.isChecked()) {
            ry = ry +" " +orio.getText().toString();
        }
        Toast toast = Toast.makeText(this, ry,
                Toast.LENGTH_SHORT);
        toast.show();}
}