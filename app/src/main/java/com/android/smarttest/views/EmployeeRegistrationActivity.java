package com.android.smarttest.views;

import android.os.Bundle;
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
import com.android.smarttest.model.EmployeeObj;

public class EmployeeRegistrationActivity extends AppCompatActivity {

    private EditText mEmpIDEditText;
    private EditText mEmpNameEditText;
    private Spinner mEmpDesignationSpinner;

    private String[] mDesignations = {"HR"};
    private String mSelectedDesignation;
    private Button mSave;
    private AppController mAppController;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_registration);
        initUI();
        initToolbar();
    }

    public void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    private void initUI() {

        mEmpIDEditText = (EditText) findViewById(R.id.emp_code);
        mEmpNameEditText = (EditText) findViewById(R.id.emp_name);
        mEmpDesignationSpinner = (Spinner) findViewById(R.id.spinner_designation);

        mAppController = AppController.getInstance(EmployeeRegistrationActivity.this);

        mSave = (Button) findViewById(R.id.btn_emp_register);

        mEmpDesignationSpinner.setSelection(0);

        ArrayAdapter<String> technologiesAdapter = new ArrayAdapter<String>(EmployeeRegistrationActivity.this, android.R.layout.simple_spinner_item, mDesignations);
        technologiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEmpDesignationSpinner.setAdapter(technologiesAdapter);

        mEmpDesignationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedDesignation = mDesignations[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EmployeeObj employeeObj = new EmployeeObj();
                employeeObj.setEmpID(mEmpIDEditText.getEditableText().toString());
                employeeObj.setName(mEmpNameEditText.getEditableText().toString());
                employeeObj.setDesignation(mSelectedDesignation);
                mAppController.insertEmployeeDetails(employeeObj);
                finish();

            }
        });


    }
}
