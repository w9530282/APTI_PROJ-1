package com.android.smarttest.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.android.smarttest.R;
import com.android.smarttest.controller.AppController;
import com.android.smarttest.model.CandidateObj;

import java.util.List;

public class EmployeeDashBoard extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<CandidateObj> mList;
    private String mEmpCode;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dash_board);
        initUI();
        if(null!=getIntent()){
            mEmpCode = getIntent().getStringExtra("EmpCode");
        }
        initToolbar();
        loadData();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadData() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(EmployeeDashBoard.this));

        mList = AppController.getInstance(EmployeeDashBoard.this).getCandidateListByEmployee(mEmpCode);

        Log.v("For Employee :", "" + mEmpCode + " candidates : " + mList.size());

        EmployeeDashboardListAdapter adapter  = new EmployeeDashboardListAdapter(EmployeeDashBoard.this, mList);
        mRecyclerView.setAdapter(adapter);
    }

    private void initUI() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private class DividerItemDecoration extends RecyclerView.ItemDecoration{
        private Drawable mDivider;

        public DividerItemDecoration() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                mDivider =  ContextCompat.getDrawable(EmployeeDashBoard.this, R.drawable.line_divider);
            }
        }

        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
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
                Intent  intent = new Intent(EmployeeDashBoard.this, LoginActivity.class);
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
