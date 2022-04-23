package com.android.smarttest.controller;


import android.content.Context;

import com.android.smarttest.database.DatabaseHelper;
import com.android.smarttest.model.CandidateObj;
import com.android.smarttest.model.EmployeeObj;

import java.util.List;

public class AppController {

    private static AppController mAppController = null;
    private static DatabaseHelper mDBHelper;

    public static AppController getInstance(Context context) {
        if(mAppController == null){
            mAppController = new AppController();
            mDBHelper = new DatabaseHelper(context);
        }
        return mAppController;
    }

    public void insertCandidateDetails(CandidateObj candidateObj){
        mDBHelper.insertCandidateDetails(candidateObj);
    }

    public void insertEmployeeDetails(EmployeeObj employeeObj){
        mDBHelper.insertEmployeeDetails(employeeObj);
    }

    public CandidateObj getCandidateInformation(String cCode){
        return mDBHelper.getCandidateInformation(cCode);
    }

    public boolean isValidCandidate(String cCode){
        return mDBHelper.isValidCandidate(cCode);
    }

    public List<EmployeeObj> getAllEmployees(){
        return mDBHelper.getAllEmployees();
    }

    public List<CandidateObj> getCandidateListByEmployee(String empCode){
        return mDBHelper.getCandidateListByEmployee(empCode);
    }

    public boolean isValidEmployee(String s) {
        return mDBHelper.isValidEmployee(s);
    }

    public void updateResult(String resultStatus, String mCCOde) {
        mDBHelper.updateResult(resultStatus, mCCOde);
    }
}
