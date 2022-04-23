package com.android.smarttest.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.smarttest.AppConstants;
import com.android.smarttest.R;
import com.android.smarttest.controller.AppController;
import com.android.smarttest.database.DatabaseHelper;
import com.android.smarttest.model.Question;

import java.util.List;

public class QuestionActivity1 extends BaseActivity {
    List<Question> quesList;
    int score = 0;
    int qid = 0;
    Question currentQ;
    TextView txtQuestion, times;
    RadioButton mRadio_1;
    RadioButton mRadio_2;
    RadioButton mRadio_3;
    RadioGroup mRadioGroup;
    Button mNext;
    Toolbar mToolBar;
    String FmCCOde;
    String module1;
    String moduleone="number1";
    String moduletwo="number2";
    String modulethree="number3";
    String modulefour="number4";
    String modulefive="number5";
    String modulesix="number6";
    String moduleseven="number7";
    String moduleeight="number8";
    String modulenine="number9";
    String moduleten="number10";
    SharedPreferences mSharedPref;
    SharedPreferences.Editor mEditor;
    long previousMinimizedTimeStamp;


    private CountDownTimer countDownTimer; // built in android class
    // CountDownTimer
    private long totalTimeCountInMilliseconds; // total count down time in
    // milliseconds
    private long timeBlinkInMilliseconds; // start time of start blinking
    private boolean blink; // controls the blinking .. on and off

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        setTimer();
        startTimer();
        if(null!=getIntent()){
            FmCCOde = getIntent().getStringExtra("FCCOde");
            module1 = getIntent().getStringExtra("ModuleNum");
            Log.v("TAG","candidate code is"+FmCCOde+module1);
        }

        if(module1.equalsIgnoreCase(moduleone)) {
        DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestions(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(moduletwo)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionstwo(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(modulethree)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsthree(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(modulefour)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsfour(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(modulefive)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsfive(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(modulesix)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionssix(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(moduleseven)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsseven(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(moduleeight)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionseight(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(modulenine)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsnine(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }else if(module1.equalsIgnoreCase(moduleten)){
            DatabaseHelper db = new DatabaseHelper(this);
            quesList = db.getAllQuestionsten(); // this will fetch all quetonall questions
            currentQ = quesList.get(qid); // the current question
        }

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        times = (TextView) findViewById(R.id.timers);
        //times.setText("");

        mRadio_1 = (RadioButton) findViewById(R.id.radio_1);
        mRadio_2 = (RadioButton) findViewById(R.id.radio_2);
        mRadio_3 = (RadioButton) findViewById(R.id.radio_3);
        mNext = (Button) findViewById(R.id.btn_next);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        setQuestionView();

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goForNextQuestionIfAny(getSelectedOptionText(mRadioGroup.getCheckedRadioButtonId()));
                mRadioGroup.clearCheck();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        mEditor.putLong("TimeStamp", System.currentTimeMillis());
        mEditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSharedPref = getSharedPreferences("smart_test_pref", MODE_PRIVATE);
        mEditor = mSharedPref.edit();
        previousMinimizedTimeStamp = mSharedPref.getLong("TimeStamp", -1);

        if(isSessionOver()){
            mEditor.putLong("TimeStamp" , -1);
            mEditor.commit();
            showSessionExpiredAlert();
        }
    }


    private void showSessionExpiredAlert() {
        AlertDialog.Builder dialogue = new AlertDialog.Builder(this);
        dialogue.setTitle("Session Expired");
        dialogue.setMessage("You Are away from test for more than a minute. Your Session has been closed.");
        dialogue.setPositiveButton("Take Me Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(QuestionActivity1.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialogue.setCancelable(false);
        dialogue.show();
    }

    private void setTimer() {
        int time = 10;
        totalTimeCountInMilliseconds = 60 * time * 1000;
        timeBlinkInMilliseconds = 30 * 1000;
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(totalTimeCountInMilliseconds, 500) {
            // 500 means, onTick function will be called at every 500
            // milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {
                long seconds = leftTimeInMilliseconds / 1000;

                if (leftTimeInMilliseconds < timeBlinkInMilliseconds) {

                    times.setTextAppearance(getApplicationContext(),
                            R.style.blinkText);
                    // change the style of the textview .. giving a red
                    // alert style

                    if (blink) {
                        times.setVisibility(View.VISIBLE);
                        // if blink is true, textview will be visible
                    } else {
                        times.setVisibility(View.INVISIBLE);
                    }

                    blink = !blink; // toggle the value of blink
                }

                times.setText(String.format("%02d", seconds / 60)
                        + ":" + String.format("%02d", seconds % 60));
                // format the textview to show the easily readable format

            }

            @Override
            public void onFinish() {
                // this function will be called when the timecount is finished
                Intent intent = new Intent(QuestionActivity1.this, LoginActivity.class);
                intent.putExtra("SessionTimeout", true);
                startActivity(intent);
                finish();
            }

        }.start();

    }


    private String getSelectedOptionText(int checkedRadioButtonId) {
        return ((RadioButton) findViewById(checkedRadioButtonId)).getText().toString();
    }

    private void initToolbar() {
        mToolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        try {
            getSupportActionBar().setTitle("Back");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }

    public void goForNextQuestionIfAny(String answerString) {
        if (currentQ.getANSWER().equalsIgnoreCase(answerString)) {
            score++;
        }

        if (qid < 11) {
// if questions are not over then do this
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
// if over do this
            AppController.getInstance(QuestionActivity1.this).updateResult(getResultStatus(score), FmCCOde);

            showSessionOverAlert();

            /*Intent intent = new Intent(QuestionActivity1.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); // Your score
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();*/
        }
    }

    private void showSessionOverAlert() {
        AlertDialog.Builder dialogue = new AlertDialog.Builder(QuestionActivity1.this);
        dialogue.setTitle("Alert");
        dialogue.setMessage("Test Completed. All the best");
        dialogue.setPositiveButton("Take Me Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(QuestionActivity1.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialogue.setCancelable(false);
        dialogue.show();
    }

    private String getResultStatus(int score){

    Log.v("TAG","SCORE IS"+score);
        int finalscore = (score*10);
        Log.v("TAG","Final SCORE IS"+finalscore);
        return score>6?"Qualified"+finalscore+"%":"Disqualified"+finalscore+"%";
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        mRadio_1.setText(currentQ.getOPTA());
        mRadio_2.setText(currentQ.getOPTB());
        mRadio_3.setText(currentQ.getOPTC());
        qid++;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private boolean isSessionOver() {
        if(previousMinimizedTimeStamp==-1){
            return false;
        }
        long diff = System.currentTimeMillis() - previousMinimizedTimeStamp;
        long diffSeconds = diff / 1000 % 60;
        return diffSeconds> AppConstants.SESSION_TIMEOUT;
    }

}