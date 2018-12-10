package com.projectf5.changgong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class InformationActivity extends AppCompatActivity {
    private Button btsave;
    private Button btcancel;
//    private RadioButton rbgd1;
//    private RadioButton rbgd2;
//    private RadioButton rbgd3;
//    private RadioButton rbgd4;
//    private RadioButton rbbtn;
//    private RadioButton rbbtwt;
//    private RadioButton rbbtyl;
//    private RadioButton rbbtbl;
//    private RadioButton rbbtrd;
    private RadioGroup rggd;
    private RadioGroup rgbt;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        load();

        btsave = findViewById(R.id.bt_save);
        btcancel = findViewById(R.id.bt_cancel);
//        rbgd1 = findViewById(R.id.rb_gd_1);
//        rbgd2 = findViewById(R.id.rb_gd_2);
//        rbgd3 = findViewById(R.id.rb_gd_3);
//        rbgd4 = findViewById(R.id.rb_gd_4);
//
//        rbbtn = findViewById(R.id.rb_bt_n);
//        rbbtwt = findViewById(R.id.rb_bt_wt);
//        rbbtyl = findViewById(R.id.rb_bt_yl);
//        rbbtbl = findViewById(R.id.rb_bt_bl);
//        rbbtrd = findViewById(R.id.rb_bt_rd);
        rggd = findViewById(R.id.rggd);
        rgbt = findViewById(R.id.rgbt);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idbt = rgbt.getCheckedRadioButtonId();
                int idgd = rggd.getCheckedRadioButtonId();
                RadioButton rbbt = findViewById(idbt);
                RadioButton rbgd = findViewById(idgd);
                save(idbt,idgd);
                load();
            }
        });

        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        }


    public void save(int idbt, int idgd) {
        SharedPreferences student = getSharedPreferences("STUDENT",MODE_PRIVATE);
        SharedPreferences.Editor editor = student.edit();
        editor.putInt("belt",idbt);
        editor.putInt("grade",idgd);
        editor.commit();
    }
    public void load() {
        SharedPreferences student = getSharedPreferences("STUDENT",MODE_PRIVATE);
        int belt = student.getInt("belt",0);
        int grade = student.getInt("grade",0);
        if(belt == R.id.rb_bt_n) {
            Intent intent = new Intent(getApplicationContext(), NBeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_wt) {
            Intent intent = new Intent(getApplicationContext(), WbeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_yl) {
            Intent intent = new Intent(getApplicationContext(), YBeltActivtiy.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_bl) {
            Intent intent = new Intent(getApplicationContext(), BBeltActivity.class);
            startActivity(intent);
            finish();
        }

        else if(belt == R.id.rb_bt_rd) {
            Intent intent = new Intent(getApplicationContext(), RBeltActivity.class);
            startActivity(intent);
            finish();
        }
    }
}


