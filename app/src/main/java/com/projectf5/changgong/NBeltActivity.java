package com.projectf5.changgong;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class NBeltActivity extends AppCompatActivity {
    private CheckBox call;
    private CheckBox[] c;
    private TextView[] t;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbelt);
        SharedPreferences Student = getSharedPreferences("STUDENT", MODE_PRIVATE);
        final SharedPreferences.Editor editor = Student.edit();

        c = new CheckBox[9];
        t = new TextView[9];

        call = findViewById(R.id.call);

        c[0] = findViewById(R.id.c0);
        c[1] = findViewById(R.id.c1);
        c[2] = findViewById(R.id.c2);
        c[3] = findViewById(R.id.c3);
        c[4] = findViewById(R.id.c4);
        c[5] = findViewById(R.id.c5);
        c[6] = findViewById(R.id.c6);
        c[7] = findViewById(R.id.c7);
        c[8] = findViewById(R.id.c8);

        t[0] = findViewById(R.id.t0);
        t[1] = findViewById(R.id.t1);
        t[2] = findViewById(R.id.t2);
        t[3] = findViewById(R.id.t3);
        t[4] = findViewById(R.id.t4);
        t[5] = findViewById(R.id.t5);
        t[6] = findViewById(R.id.t6);
        t[7] = findViewById(R.id.t7);
        t[8] = findViewById(R.id.t8);

        b = findViewById(R.id.b);

        call.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(call.isChecked() == true) {
                   for(int i = 0; i < 9; i++) {
                       c[i].setChecked(true);
                   }
                }
                else {
                    for(int i = 0; i < 9; i++) {
                        c[i].setChecked(false);
                    }
                }
            }
        });

        ArrayList<String> data = new ArrayList<>();

        data.add("경력활동계획서(1학년)");
        data.add("인성검사 적성검사 택1");
        data.add("진로교과목(진로설계)/진로캠프/대학생진로 지도프로그램(CDP)중 택1");
        data.add("추천도서 4권");
        data.add("진로상담(취업지원과 진로상담팀)");
        data.add("사회(국내)봉사 20시간");
        data.add("교내 멘토링프로그램 참가");
        data.add("토익점수 제출(모의토익 가능)");
        data.add("진로상담(취업지원과 진로상담팀)");

        for(int i = 0; i < data.size(); i++) {
            t[i].setText(data.get(i));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                editor.clear().commit();
                Intent intent = new Intent(getApplicationContext(),InformationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
