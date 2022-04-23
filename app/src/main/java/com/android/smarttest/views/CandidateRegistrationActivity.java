package com.android.smarttest.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.smarttest.R;
import com.android.smarttest.controller.AppController;
import com.android.smarttest.model.CandidateObj;
import com.android.smarttest.model.EmployeeObj;

import java.util.ArrayList;
import java.util.List;

public class CandidateRegistrationActivity extends AppCompatActivity {

    private String[] mTechnologies = {"IBPS"};
   // private String[] mEmployeeDetails = {"EJ12289-Ramu", "EJ12389-Raju","EJ12689-Sam"};

    private EditText mCandidateCodeEditText;
    private EditText mCandidateNameEditText;
    private EditText mCandidateEmailEditText;
    private EditText mCandidateNumberEditText;
    private Spinner mTechnologySpinner;
    private Spinner mPOCSpinner;
    private Button mRegisterButton;
    private String mSelectedTechnology;
    private String mSelectedPOC;
    private AppController mAppController;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_registration);

        initUI();
        initToolbar();
        loadData();

    }

    public void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadData() {
        mAppController = AppController.getInstance(CandidateRegistrationActivity.this);
        mTechnologySpinner.setSelection(0);
        mPOCSpinner.setSelection(0);

        ArrayAdapter<String> technologiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mTechnologies);
        technologiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTechnologySpinner.setAdapter(technologiesAdapter);

        ArrayAdapter<String> pocAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fetchEmpNames());
        pocAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPOCSpinner.setAdapter(pocAdapter);


        mTechnologySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mSelectedTechnology = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mPOCSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mSelectedPOC = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty(mCandidateCodeEditText) || isEmpty(mCandidateNameEditText) || isEmpty(mCandidateEmailEditText) || isEmpty(mCandidateNumberEditText)){
                    showErrorAlert();
                }else{
                    CandidateObj candidateObj = new CandidateObj();
                    candidateObj.setCode(mCandidateCodeEditText.getEditableText().toString().trim());
                    candidateObj.setName(mCandidateNameEditText.getEditableText().toString().trim());
                    candidateObj.setEmail(mCandidateEmailEditText.getEditableText().toString().trim());
                    candidateObj.setNumber(mCandidateNumberEditText.getEditableText().toString().trim());
                    candidateObj.setTechnology(mSelectedTechnology);
                    candidateObj.setPoc(fetchID(mSelectedPOC));
                    mAppController.insertCandidateDetails(candidateObj);

                    Intent intent = new Intent(CandidateRegistrationActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private List<String> fetchEmpNames() {
        List<String> list = new ArrayList<>();
        for(EmployeeObj employeeObj : mAppController.getAllEmployees()){
            list.add(employeeObj.getEmpID()+" - "+employeeObj.getName());
        }
        return list;
    }


    private String fetchID(String selectedPOC) {
        String[] pocName = selectedPOC.split("-");
        return pocName[0].trim();
    }

    private boolean isEmpty(EditText editText) {
        return editText.getEditableText().toString().trim().length()==0;
    }

    private void showErrorAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Error");
        alertDialogBuilder.setMessage("Please fill the required fields");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialogBuilder.show();

    }

    private void initUI() {
        mCandidateCodeEditText = (EditText) findViewById(R.id.candidate_code);
        mCandidateNameEditText = (EditText) findViewById(R.id.candidate_name);
        mCandidateEmailEditText = (EditText) findViewById(R.id.candidate_email);
        mCandidateNumberEditText = (EditText) findViewById(R.id.candidate_number);
        mTechnologySpinner = (Spinner) findViewById(R.id.spinner_technology);
        mPOCSpinner = (Spinner) findViewById(R.id.spinner_poc);
        mRegisterButton = (Button) findViewById(R.id.btn_register);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
