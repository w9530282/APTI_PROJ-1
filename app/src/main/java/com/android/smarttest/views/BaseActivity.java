package com.android.smarttest.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.smarttest.AppConstants;
import com.android.smarttest.controller.AppController;

public class BaseActivity extends AppCompatActivity {


    SharedPreferences mSharedPref;
    SharedPreferences.Editor mEditor;
    long previousMinimizedTimeStamp;

   /* @Override
    public void onBackPressed() {
        showExitAlert();
    }*/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    /*private void showExitAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Do you want to exit?");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent  intent = new Intent(BaseActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialogBuilder.show();
    }*/

    @Override
    protected void onPause() {
        super.onPause();
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
            showSessionExpiredAlert();
        }
    }

    private void showSessionExpiredAlert() {
        AlertDialog.Builder dialogue = new AlertDialog.Builder(BaseActivity.this);
        dialogue.setTitle("Session Expired");
        dialogue.setMessage("You Are away from test for more than a minute. Your Session has been closed.");
        dialogue.setPositiveButton("Take Me Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(BaseActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        dialogue.setCancelable(false);
        dialogue.show();
    }

    private boolean isSessionOver() {
        return false;
        /*if(previousMinimizedTimeStamp==-1){
            return false;
        }
        long diff = System.currentTimeMillis() - previousMinimizedTimeStamp;
        long diffSeconds = diff / 1000 % 60;
        return diffSeconds> AppConstants.SESSION_TIMEOUT;*/
    }

}
