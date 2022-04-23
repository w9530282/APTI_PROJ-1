package com.android.smarttest.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.smarttest.R;
import com.android.smarttest.controller.AppController;

public class LoginActivity extends AppCompatActivity {

    Button mCandidateLoginBtn;
    Button mEmpLoginBtn;
    TextView mLoginAsCandidateText;
    TextView mLoginAsEmployeeText;
    CardView mCard_candidate;
    CardView mCard_employee;
    TextView mText_Candidate;
    TextView mText_Employee;
    TextView mCandidateRegister;
    TextView mEmployeeRegister;
    AppController mAppController;
    EditText mCandidateCode;
    EditText mEmpCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        loadData();
    }

    private void loadData() {
        if(null!=getIntent()){
            if(getIntent().getBooleanExtra("SessionTimeout" , false)){
                showSessionExpiredAlert();
            }
        }
    }

    private void showSessionExpiredAlert() {
        AlertDialog.Builder dialogue = new AlertDialog.Builder(this);
        dialogue.setTitle("Time up");
        dialogue.setMessage("Your test has been completed.");
        dialogue.setCancelable(false);
        dialogue.show();
    }

    private void initUI() {
        mCandidateCode = (EditText) findViewById(R.id.input_candidate_code);
        mEmpCode = (EditText) findViewById(R.id.input_emp_id);
        mCandidateLoginBtn = (Button)findViewById(R.id.btn_candidate_go);
        mEmpLoginBtn = (Button)findViewById(R.id.btn_emp_go);

        mLoginAsCandidateText = (TextView)findViewById(R.id.text_login_as_candidate);
        mLoginAsEmployeeText = (TextView)findViewById(R.id.text_login_as_employee);

        mCard_candidate=(CardView)findViewById(R.id.card_candidate);
        mCard_employee=(CardView)findViewById(R.id.card_employee);

        mCandidateRegister = (TextView) findViewById(R.id.text_candidate_register);
        mEmployeeRegister = (TextView) findViewById(R.id.text_employee_register);

        mAppController = AppController.getInstance(LoginActivity.this);


        mLoginAsEmployeeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard_candidate.setVisibility(View.GONE);
                mCard_employee.setVisibility(View.VISIBLE);
            }
        });

        mLoginAsCandidateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard_candidate.setVisibility(View.VISIBLE);
                mCard_employee.setVisibility(View.GONE);
            }
        });

        mCandidateRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CandidateRegistrationActivity.class);
                startActivity(intent);
            }
        });

        mEmployeeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, EmployeeRegistrationActivity.class);
                startActivity(intent);
            }
        });


        mCandidateLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAppController.isValidCandidate(mCandidateCode.getEditableText().toString())){
                    Intent intent = new Intent(LoginActivity.this, CandidateDashBoardActivity.class);
                    intent.putExtra("ccode", mCandidateCode.getEditableText().toString());
                    startActivity(intent);
                }else{
                    showNoUserFoundAlert();
                }

            }
        });

        mEmpLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAppController.isValidEmployee(mEmpCode.getEditableText().toString())){
                    Intent intent = new Intent(LoginActivity.this, EmployeeDashBoard.class);
                    intent.putExtra("EmpCode", mEmpCode.getEditableText().toString());
                    startActivity(intent);
                }else{
                    showNoUserFoundAlert();
                }
            }
        });

    }


    private void showNoUserFoundAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Error");
        alertDialogBuilder.setMessage("No Information Found");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.show();
    }
}

