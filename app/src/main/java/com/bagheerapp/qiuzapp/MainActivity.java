package com.bagheerapp.qiuzapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int points = 0;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public void checking (View view) {
        CheckBox answerCheck1 = (CheckBox) findViewById(R.id.checkBox1);
        answerCheck1.setTextColor(Color.parseColor("#388E3C"));
        if (answerCheck1.isChecked()) {
            points += 1;
        }

        CheckBox checkAnswerWrong1 = (CheckBox) findViewById(R.id.checkBox2);
        checkAnswerWrong1.setTextColor(Color.RED);
        if (checkAnswerWrong1.isChecked()) {
            checkAnswerWrong1.setChecked(false);
            answerCheck1.setChecked(true);
        }

        CheckBox checkAnswerWrong2 = (CheckBox) findViewById(R.id.checkBox3);
        checkAnswerWrong2.setTextColor(Color.RED);
        CheckBox checkAnswerWrong3 = (CheckBox) findViewById(R.id.checkBox4);
        checkAnswerWrong3.setTextColor(Color.RED);
    }

    public void askNewQuestion (View view){
        counter += 1;

        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(questionsAnswers[counter][0]);

        CheckBox answerCheck1 = (CheckBox) findViewById(R.id.checkBox1);
        answerCheck1.setText(Answersorder()[0]);
        if (answerCheck1.isChecked()) {
            answerCheck1.setChecked(false);
        }

        CheckBox answerCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        answerCheck2.setText(Answersorder()[1]);
        if (answerCheck2.isChecked()) {
            answerCheck2.setChecked(false);
        }

        CheckBox answerCheck3 = (CheckBox) findViewById(R.id.checkBox3);
        answerCheck3.setText(Answersorder()[2]);
        if (answerCheck3.isChecked()) {
            answerCheck3.setChecked(false);
        }

        CheckBox answerCheck4 = (CheckBox) findViewById(R.id.checkBox4);
        answerCheck4.setText(Answersorder()[3]);
        if (answerCheck4.isChecked()) {
            answerCheck4.setChecked(false);
        }
        answerCheck1.setTextColor(Color.BLACK);
        answerCheck2.setTextColor(Color.BLACK);
        answerCheck3.setTextColor(Color.BLACK);
        answerCheck4.setTextColor(Color.BLACK);

    }


         public static String getRandomAnswers(String[] [] array) {
             int rnd = new Random().nextInt(array.length);
             if (rnd != 0) {
                 return array[rnd][1];
             } else {
                      return array[29][1];
                    }
         }




    public String[] Answersorder(){
        String order[] = new String[4];
        for (int i=0; i<2; i++) {
            order[i] = getRandomAnswers(questionsAnswers);
            }
         order[3] = questionsAnswers[counter][1];

        // permutation

        int randomNumber = new Random().nextInt(3)+1;
        String temp = order[randomNumber];
        order[randomNumber] = order [3];
        order[3] = temp;

        return order;
        }
 /*
    private void randomOtherAnswers() {
        Random rand = new Random();
        int n = rand.nextInt(4) + 1;
          int[] indexes = new int[] {1,2,3,4};
          for (int i = 0; i<3; i++) {
              int temp = indexes [i];
              indexes[i] = indexes[n];
              indexes[n] = temp;
          }
    }*/


    // Tömbök deklarálása
    String [] []  questionsAnswers  = new String[] [] {
            {"Konstans fordulatszám", "G97 S_"},
            {"Abszolút méretmegadás", "G90"},
            {"Körinterpoláció óra járással ellentétesen az előtolás irányából nézve", "G3"},
            {"X-Y sík", "G17"},
            {"Metrikus méretmegadás", "G21"},
            {"Főorsó óra járással ellentétesen forog a főorsóból nézve", "M4"},
            {"Konstans vágósebesség","G96 S_"},
            {"Szerszámhívás","T_ _ _ _"},
            {"Lekerekítés",",R_"},
            {"Kontúrkövetés balról az előtolás irányából","G41"},
            {"Kontúrkövetés kikapcsolva / szerszámsugár korrekció kikapcsolva","G40"},
            {"Z-X sík","G18"},
            {"Első munkadarab nullpont","G54"},
            {"Percenkénti előtolás","G94 F_"},
            {"Egyenes interpoláció gyorsmenetben","G0"},
            {"Kontúrkövetés jobbról az előtolás irányából","G42"},
            {"Főorsó áll","M5"},
            {"X tengely körüli forgó tengely","A"},
            {"Z tengely körüli forgó tengely","C"},
            {"Hűtő kenő folyadék bekapcsolva","M8"},
            {"Főorsó óra mutató járással megegyezően forog a főorsóból nézve","M3"},
            {"Maximális főorsó fordulat programozása","G92 S_"},
            {"Szerszámállás kódja","Q _"},
            {"Letörés",",C_"},
            {"Szög programozása",",A_"},
            {"Fordulatonkénti előtolás","G95 F_"},
            {"Inches méretmegadás","G20"},
            {"Program vége","M30"},
            {"Egyenes interpoláció programozott előtolással","G1"},
            {"Gépi koordináta rendszer","G53"}
    };


}

//** question: string[sorszam: 1..30]
//
// public static int[] RandomizeArray(int[] array){
//Random rgen = new Random();  // Random number generator

//		for (int i=0; i<array.length; i++) {
 //   int randomPosition = rgen.nextInt(array.length);
  //      int temp = array[i];
 //       array[i] = array[randomPosition];
 //       array[randomPosition] = temp;
//        }

//        return array;
//        }*/