package com.projectf5.changgong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NBeltActivity extends AppCompatActivity {
    private CheckBox call;
    private CheckBox[] c;
    private TextView[] t;
    private Button[] bt_detail;
    private Button b;
    private Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nbelt);
        SharedPreferences Student = getSharedPreferences("STUDENT", MODE_PRIVATE);
        SharedPreferences check = getSharedPreferences("CHECK", MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = check.edit();
        final SharedPreferences.Editor editor = Student.edit();


        c = new CheckBox[8];
        t = new TextView[8];
        bt_detail = new Button[8];

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


        bt_detail[0] = findViewById(R.id.bt_detail1);
        bt_detail[1] = findViewById(R.id.bt_detail2);
        bt_detail[2] = findViewById(R.id.bt_detail3);
        bt_detail[3] = findViewById(R.id.bt_detail4);
        bt_detail[4] = findViewById(R.id.bt_detail5);
        bt_detail[5] = findViewById(R.id.bt_detail6);
        bt_detail[6] = findViewById(R.id.bt_detail7);
        bt_detail[7] = findViewById(R.id.bt_detail8);


        b = findViewById(R.id.b);
        save = findViewById(R.id.save);

        load();

        call.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (call.isChecked() == true) {
                    for (int i = 0; i < 8; i++) {
                        c[i].setChecked(true);
                    }
                }

                else {
                    for (int i = 0; i < 8; i++) {
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

        for (int i = 0; i < data.size(); i++) {
            t[i].setText(data.get(i));
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 초기화 버튼
                editor.clear().commit();
                editor1.clear().commit();
                Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

        bt_detail[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",0);
                startActivity(intent);
            }
        });

        bt_detail[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",1);
                startActivity(intent);
            }
        });

        bt_detail[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",2);
                startActivity(intent);
            }
        });

        bt_detail[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",3);
                startActivity(intent);
            }
        });

        bt_detail[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",4);
                startActivity(intent);
            }
        });

        bt_detail[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",5);
                startActivity(intent);
            }
        });

        bt_detail[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",6);
                startActivity(intent);
            }
        });

        bt_detail[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                intent.putExtra("NOTICE_KEY",7);
                startActivity(intent);
            }
        });

    }


    private void save() {
        SharedPreferences check = getSharedPreferences("CHECK", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = check.edit();
        for (int i = 0; i < 8; i++) {
            editor1.putBoolean("check" + i, c[i].isChecked()).commit();
        }
    }

    private void load() {
        SharedPreferences check = getSharedPreferences("CHECK", MODE_PRIVATE);
        for (int i = 0; i < 8; i++) {
            c[i].setChecked(check.getBoolean("check" + i, false));
        }
    }
}
