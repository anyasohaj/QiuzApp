package com.bagheerapp.qiuzapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
  //  DecimalFormat df = new DecimalFormat("#.00");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

   public void startTest(View view){
       Intent intent = new Intent(this, Test.class);
       startActivity(intent);
   }

}


