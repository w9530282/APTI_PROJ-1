package com.android.smarttest.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.smarttest.R;
import com.android.smarttest.controller.AppController;
import com.android.smarttest.model.CandidateObj;
import com.android.smarttest.model.TechnologyObj;

import java.util.ArrayList;
import java.util.List;

public class CandidateDashBoardActivity extends BaseActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    Toolbar mToolBar;
    String mCandidateCode;


    EditText mDashBoardCCode;
    EditText mDashBoardCName;
    EditText mDashBoardCEmail;
    EditText mDashBoardCNumber;
    EditText mDashBoardCPOC;
    Button mStartBtn;
    SharedPreferences mSharedPref;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionsmenu);
        initUI();
        initToolbar();

       // initRecyclerView();
        if(null!=getIntent()){
            mCandidateCode = getIntent().getStringExtra("ccode");
            Log.v("KEY","CandidateCode : " + mCandidateCode);
        }

        loadData();
    }

    private void loadData() {

        CandidateObj candidateObj = AppController.getInstance(CandidateDashBoardActivity.this).getCandidateInformation(mCandidateCode);

        mDashBoardCCode.setText(candidateObj.getCode());
        mDashBoardCName.setText(candidateObj.getName());
        mDashBoardCEmail.setText(candidateObj.getEmail());
        mDashBoardCNumber.setText(candidateObj.getNumber());
        mDashBoardCPOC.setText(candidateObj.getPoc());

    }

    private void initUI() {
        mDashBoardCCode = (EditText) findViewById(R.id.dashboard_c_code);
        mDashBoardCName = (EditText) findViewById(R.id.dashboard_c_name);
        mDashBoardCEmail = (EditText) findViewById(R.id.dashboard_c_email);
        mDashBoardCNumber = (EditText) findViewById(R.id.dashboard_c_number);
        mDashBoardCPOC = (EditText) findViewById(R.id.dashboard_c_poc);
        mStartBtn = (Button) findViewById(R.id.dashboard_start_test);

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
                Intent intent = new Intent(CandidateDashBoardActivity.this,
                        QuestionModuleActivity.class);
                intent.putExtra("CCOde",mCandidateCode);
                startActivity(intent);
            }
        });

    }

    private void resetTimer() {
        mSharedPref = getSharedPreferences("smart_test_pref", MODE_PRIVATE);
        mEditor = mSharedPref.edit();
        mEditor.putLong("TimeStamp" , -1);
        mEditor.commit();
    }

    private void initToolbar() {
        mToolBar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        try {
            getSupportActionBar().setTitle("Home");
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }

    private void initRecyclerView() {
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, prepareTechnologyList());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<TechnologyObj> prepareTechnologyList() {
        List<TechnologyObj> list = new ArrayList<>();

        TechnologyObj android = new TechnologyObj();
        android.setId(R.drawable.icon_android);
        android.setName("Android");

        TechnologyObj iOS = new TechnologyObj();
        iOS.setId(R.drawable.icon_ios);
        iOS.setName("iOS");

        list.add(android);
        list.add(iOS);

        return  list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showExitAlert();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showExitAlert();
    }

    private void showExitAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Do you want to exit?");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                Intent  intent = new Intent(CandidateDashBoardActivity.this, LoginActivity.class);
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
    }

}