package com.bagheerapp.qiuzapp;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test extends AppCompatActivity {
    int point = 0;
    int points = 0;
    int counter = 0;
    String globalOrder[] = new String[4];
    String questionsAnswers[][] = new String[30][2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        gettingResou();
    }

    public void checking (View view) {
        CheckBox answerCheck1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox answerCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox answerCheck3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox answerCheck4 = (CheckBox) findViewById(R.id.checkBox4);


        // Evaluation of the first (XML) question

        if (counter == 0) {
            if (answerCheck1.isChecked()) {points += 1;} else{
                String wrong = getResources().getString(R.string.wrong_answer);
                Toast.makeText(this, wrong, Toast.LENGTH_SHORT).show();
                answerCheck1.setTextColor(Color.parseColor("#2E7D32")); answerCheck1.setChecked(true);
                answerCheck2.setTextColor(Color.RED); answerCheck2.setChecked(false);
                answerCheck3.setTextColor(Color.RED); answerCheck3.setChecked(false);
                answerCheck4.setTextColor(Color.RED); answerCheck4.setChecked(false);
                return;
            }




        } else {

            if (answerCheck1.getText() != questionsAnswers[counter][1]) {
                answerCheck1.setTextColor(Color.RED);

                if (answerCheck1.isChecked()) {
                    String wrong = getResources().getString(R.string.wrong_answer);
                    Toast.makeText(this, wrong, Toast.LENGTH_SHORT).show();
                    answerCheck1.setChecked(false);
                }
            } else {if (answerCheck1.isChecked()) {
                point = 1;}
                answerCheck1.setTextColor(Color.parseColor("#2E7D32"));
                answerCheck1.setChecked(true);

            }

            if (answerCheck2.getText() != questionsAnswers[counter][1]) {
                answerCheck2.setTextColor(Color.RED);

                if (answerCheck2.isChecked()) {
                    String wrong = getResources().getString(R.string.wrong_answer);
                    Toast.makeText(this, wrong, Toast.LENGTH_SHORT).show();
                    answerCheck2.setChecked(false);
                }
            } else {if (answerCheck2.isChecked()) {
                point = 1;}
                answerCheck2.setTextColor(Color.parseColor("#2E7D32"));
                answerCheck2.setChecked(true);

            }

            if (answerCheck3.getText() != questionsAnswers[counter][1]) {
                answerCheck3.setTextColor(Color.RED);

                if (answerCheck3.isChecked()) {
                    String wrong = getResources().getString(R.string.wrong_answer);
                    Toast.makeText(this, wrong, Toast.LENGTH_SHORT).show();
                    answerCheck3.setChecked(false);
                }
            } else {if (answerCheck3.isChecked()) {
                point = 1;}
                answerCheck3.setTextColor(Color.parseColor("#2E7D32"));
                answerCheck3.setChecked(true);

            }

            if (answerCheck4.getText() != questionsAnswers[counter][1]) {
                answerCheck4.setTextColor(Color.RED);

                if (answerCheck4.isChecked()) {
                    String wrong = getResources().getString(R.string.wrong_answer);
                    Toast.makeText(this, wrong, Toast.LENGTH_SHORT).show();
                    answerCheck4.setChecked(false);
                }
            } else {if (answerCheck4.isChecked()) {
                point = 1;}
                answerCheck4.setTextColor(Color.parseColor("#2E7D32"));
                answerCheck4.setChecked(true);

            }

        }

    }


    // Clicking the NEXT button it generate new question, new answer possibilities and reset checkboxes

    public void askNewQuestion (View view) {
        if (point == 1) {
            points += 1;
            point = 0;
        }

        if (counter > 28) {

            String endToast = getResources().getString(R.string.End_toast);
            Toast.makeText(this, endToast, Toast.LENGTH_LONG).show();
            return;
        }

        counter += 1;
        TextView countUp = (TextView) findViewById(R.id.textView);
        countUp.setText((counter + 1) + "/30");


        if (counter == 29) {
            double percent = points / 0.3;
            int intValue = (int) percent;
            TextView evaluation = (TextView) findViewById(R.id.textView);
            String acc = getResources().getString(R.string.accomplish);
            evaluation.setText(acc + " " + intValue + "%");
        }


        generateRandomNumbers();

        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(questionsAnswers[counter][0]);

        CheckBox answerCheck1 = (CheckBox) findViewById(R.id.checkBox1);
        answerCheck1.setText(globalOrder[0]);
        if (answerCheck1.isChecked()) {
            answerCheck1.setChecked(false);
        }

        CheckBox answerCheck2 = (CheckBox) findViewById(R.id.checkBox2);
        answerCheck2.setText(globalOrder[1]);
        if (answerCheck2.isChecked()) {
            answerCheck2.setChecked(false);
        }

        CheckBox answerCheck3 = (CheckBox) findViewById(R.id.checkBox3);
        answerCheck3.setText(globalOrder[2]);
        if (answerCheck3.isChecked()) {
            answerCheck3.setChecked(false);
        }

        CheckBox answerCheck4 = (CheckBox) findViewById(R.id.checkBox4);
        answerCheck4.setText(globalOrder[3]);
        if (answerCheck4.isChecked()) {
            answerCheck4.setChecked(false);
        }
        answerCheck1.setTextColor(Color.BLACK);
        answerCheck2.setTextColor(Color.BLACK);
        answerCheck3.setTextColor(Color.BLACK);
        answerCheck4.setTextColor(Color.BLACK);

    }



    public  void generateRandomNumbers() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 30; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int j = 0; j < 3; j++) {
            globalOrder [j] = questionsAnswers[list.get(j)][1];
            if (globalOrder[j] == questionsAnswers[counter][1]) {
                globalOrder[j] = "G100";
            }
            globalOrder[3] = questionsAnswers[counter][1];
        }
        // Permutation

        int randomNumber = new Random().nextInt(4);
        String temp = globalOrder[randomNumber];
        globalOrder[randomNumber] = globalOrder [3];
        globalOrder[3] = temp;
    }

    public void gettingResou () {
        Resources res = getResources();
        String[] togetherFromResou = res.getStringArray(R.array.questions_array);

        for (int k = 0; k < 30; k++) {
            questionsAnswers[k] = togetherFromResou[k].split("/");

        } }
}
