package com.android.smarttest.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.smarttest.R;

public class QuestionModuleActivity extends AppCompatActivity {


    Button mModule1,mModule2,mModule3,mModule4,mModule5,mModule6,mModule7,mModule8,mModule9,mModule10;
    String mCCOde;
    String moduleone = "number1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_module);

//
        mModule1 = (Button) findViewById(R.id.module_one);
        mModule2 = (Button) findViewById(R.id.module_two);
        mModule3 = (Button) findViewById(R.id.module_three);
        mModule4 = (Button) findViewById(R.id.module_four);
        mModule5 = (Button) findViewById(R.id.module_five);
        mModule6 = (Button) findViewById(R.id.module_six);
        mModule7 = (Button) findViewById(R.id.module_seven);
        mModule8 = (Button) findViewById(R.id.module_eight);
        mModule9 = (Button) findViewById(R.id.module_nine);
        mModule10 = (Button) findViewById(R.id.module_ten);

        if(null!=getIntent()){
            mCCOde = getIntent().getStringExtra("CCOde");
            Log.v("TAG","QMA candidate code"+mCCOde);
        }

        mModule1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent1.putExtra("FCCOde",mCCOde);
                intent1.putExtra("ModuleNum","number1");
                System.out.println("Button clicked");
                startActivity(intent1);
            }
        });
        mModule2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent2.putExtra("FCCOde",mCCOde);
                intent2.putExtra("ModuleNum","number2");
                startActivity(intent2);
            }
        });
        mModule3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent3.putExtra("FCCOde",mCCOde);
                intent3.putExtra("ModuleNum","number3");
                startActivity(intent3);
            }
        });
        mModule4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent4.putExtra("FCCOde",mCCOde);
                intent4.putExtra("ModuleNum","number4");
                startActivity(intent4);
            }
        });
        mModule5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent5.putExtra("FCCOde",mCCOde);
                intent5.putExtra("ModuleNum","number5");
                startActivity(intent5);
            }
        });
        mModule6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent6.putExtra("FCCOde",mCCOde);
                intent6.putExtra("ModuleNum","number6");
                startActivity(intent6);
            }
        });
        mModule7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent7.putExtra("FCCOde",mCCOde);
                intent7.putExtra("ModuleNum","number7");
                startActivity(intent7);
            }
        });
        mModule8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent8.putExtra("FCCOde",mCCOde);
                intent8.putExtra("ModuleNum","number8");
                startActivity(intent8);
            }
        });
        mModule9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent9 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent9.putExtra("FCCOde",mCCOde);
                intent9.putExtra("ModuleNum","number9");
                startActivity(intent9);
            }
        });
        mModule10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(QuestionModuleActivity.this, QuestionActivity1.class);
                intent10.putExtra("FCCOde",mCCOde);
                intent10.putExtra("ModuleNum","number10");
                startActivity(intent10);
            }
        });


    }


}
