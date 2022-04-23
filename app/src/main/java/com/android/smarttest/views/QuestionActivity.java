package com.android.smarttest.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.smarttest.R;
import com.android.smarttest.database.DatabaseHelper;
import com.android.smarttest.model.Question;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends BaseActivity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times, scored;
    RadioButton mRadio_1;
    RadioButton mRadio_2;
    RadioButton mRadio_3;
    RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper db = new DatabaseHelper(this); // my question bank class
        quesList = db.getAllQuestions(); // this will fetch all quetonall questions
        currentQ = quesList.get(qid); // the current question
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
// the textview in which the question will be displayed
// the three buttons,
// the idea is to set the text of three buttons with the options from question bank
        mRadio_1 = (RadioButton) findViewById(R.id.radio_1);
        mRadio_2 = (RadioButton) findViewById(R.id.radio_2);
        mRadio_3 = (RadioButton) findViewById(R.id.radio_3);
        mRadioGroup = findViewById(R.id.radio_group);
// the textview in which score will be displayed
       // scored = (TextView) findViewById(R.id.score);
// the timer
        times = (TextView) findViewById(R.id.timers);
// method which will set the things up for our game
        setQuestionView();
        times.setText("00:02:00");
// A timer of 60 seconds to play for, with an interval of 1 second (1000 milliseconds)
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();
// button click listeners
        mRadio_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// passing the button text to other method
// to check whether the anser is correct or not
// same for all three buttons
                getAnswer(mRadio_1.getText().toString());
            }
        });
        mRadio_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(mRadio_2.getText().toString());
            }
        });
        mRadio_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(mRadio_3.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {
// if conditions matches increase the int (score) by 1
// and set the text of the score view
            score++;
            scored.setText("Score : " + score);
            Log.v("TAG","SCORE + IS"+score);
        } else {
// if unlucky start activity and finish the game
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
// passing the int value
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            Log.v("TAG","intent SCORE + IS"+score);
            startActivity(intent);
            finish();
        }
        if (qid < 20) {
// if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
// if over do this
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            Log.v("TAG","intent if < SCORE + IS"+score);
            startActivity(intent);
            finish();
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
// TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            times.setText("Time is up");
            Intent intent = new Intent(QuestionActivity.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
// TODO Auto-generated method stub
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }

    private void setQuestionView() {
// the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        mRadio_1.setText(currentQ.getOPTA());
        mRadio_2.setText(currentQ.getOPTB());
        mRadio_3.setText(currentQ.getOPTC());
        qid++;
    }
}