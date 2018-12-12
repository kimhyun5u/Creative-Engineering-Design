package com.projectf5.changgong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class YBeltActivtiy extends AppCompatActivity {
    private CheckBox call;
    private CheckBox[] c;
    private TextView[] t;
    private Button b;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ybelt_activtiy);
        SharedPreferences Student = getSharedPreferences("STUDENT", MODE_PRIVATE);
        SharedPreferences check = getSharedPreferences("CHECK",MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = check.edit();
        final SharedPreferences.Editor editor = Student.edit();

        c = new CheckBox[8];
        t = new TextView[8];

        call = findViewById(R.id.call);

        c[0] = findViewById(R.id.c0);
        c[1] = findViewById(R.id.c1);
        c[2] = findViewById(R.id.c2);
        c[3] = findViewById(R.id.c3);
        c[4] = findViewById(R.id.c4);
        c[5] = findViewById(R.id.c5);
        c[6] = findViewById(R.id.c6);
        c[7] = findViewById(R.id.c7);

        t[0] = findViewById(R.id.t0);
        t[1] = findViewById(R.id.t1);
        t[2] = findViewById(R.id.t2);
        t[3] = findViewById(R.id.t3);
        t[4] = findViewById(R.id.t4);
        t[5] = findViewById(R.id.t5);
        t[6] = findViewById(R.id.t6);
        t[7] = findViewById(R.id.t7);

        b = findViewById(R.id.b);

        save = findViewById(R.id.save);

        call.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(call.isChecked() == true) {
                    for(int i = 0; i < 8; i++) {
                        c[i].setChecked(true);
                    }
                }
                else {
                    for(int i = 0; i < 8; i++) {
                        c[i].setChecked(false);
                    }
                }
            }
        });

        load();

        ArrayList<String> data = new ArrayList<>();

        data.add("3학년 경력활동계획서");
        data.add("추천도서 4권(누적 12권)");
        data.add("교내 멘토링프로그램 참가");
        data.add("사회(국내)봉사 20시간(누적 60시간)");
        data.add("정규토익 인문 750점 이상, 이공 700점 이상");
        data.add("기업탐방/기업체험 전공자격증 한국어능력시험 한국사능력시험 한자2급 이상 중 택1");
        data.add("취업상담(취업지원과 취업지원팀)");
        data.add("기업취업설명회 5회참가");

        for(int i = 0; i < data.size(); i++) {
            t[i].setText(data.get(i));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                editor.clear().commit();
                editor1.clear().commit();
                Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();
            }
        });

    }


    public void save(){
        SharedPreferences check = getSharedPreferences("CHECK",MODE_PRIVATE);
        SharedPreferences.Editor editor1 = check.edit();
        for(int i = 0; i < 8; i++) {
            editor1.putBoolean("check"+i, c[i].isChecked()).commit();
        }
    }

    public void load() {
        SharedPreferences check = getSharedPreferences("CHECK",MODE_PRIVATE);
        for(int i = 0; i < 8; i++) {
            c[i].setChecked(check.getBoolean("check"+i,false));
        }
    }
}
