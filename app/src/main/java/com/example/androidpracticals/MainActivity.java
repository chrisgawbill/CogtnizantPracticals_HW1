package com.example.androidpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView num;
    Button countBtn;
    Button zeroBtn;
    int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = findViewById(R.id.show_count);
        countBtn = findViewById(R.id.button_count);
        zeroBtn = findViewById(R.id.button_zero);
    }
    public void toastClickHandler(View view){
        Context context = getApplicationContext();
        Toast.makeText(this, "Count is " + num.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    public void countClickHandler(View view){
        mCount++;
        if(num!=null){
            num.setText(Integer.toString(mCount));
            if(mCount%2==0){
                //set count btn to even color
                countBtn.setBackgroundColor(getResources().getColor(R.color.countEven));
            }else{
                //set count btn to odd color
                countBtn.setBackgroundColor(getResources().getColor(R.color.countOdd));
                if(mCount == 1){
                    //set zero btn to active color
                    zeroBtn.setBackgroundColor(getResources().getColor(R.color.zeroActive));
                }
            }
        }
    }
    public void zeroClickHandler(View view){
        mCount = 0;
        num.setText(Integer.toString(mCount));
        //set zero btn to inactive color
        zeroBtn.setBackgroundColor(getResources().getColor(R.color.zeroInactive));
        countBtn.setBackgroundColor(getResources().getColor(R.color.countOdd));
    }
}