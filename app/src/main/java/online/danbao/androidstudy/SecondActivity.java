package online.danbao.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    MyApplication app;
    TextView tv;
    CheckBox cb;
    Button btn;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        实例化
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.tv);
        cb = (CheckBox) findViewById(R.id.cb_sign);
        btn = (Button) findViewById(R.id.btn_return);
        Intent intent = getIntent();
//        单个值传递
//        String str = intent.getStringExtra("username");
//        int pwd = intent.getIntExtra("password",0);
//        tv.setText("name:"+str+".\n"+"pwd:"+pwd+".");
//        bundle多个值传递
//        Bundle bundle = intent.getExtras();
//        String str = bundle.getString("username");
//        int pwd = bundle.getInt("password",0);
//        tv.setText("name:"+str+".\n"+"pwd:"+pwd+".");
//        application全局值传递
//        app = (MyApplication) getApplication();
//        String str = app.getAuthorname();
//        String sex = app.getSex();
//        int age = app.getAge();
//        tv.setText("AuthorName is "+ str+" Age is "+age+"  sex is "+sex);
//        result回传（有结果的值）
        str = intent.getStringExtra("username");
        tv.setText(str + ", your need to sign!");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String return_str;
                if (cb.isChecked()) {
                    return_str = str + "YES!";
                } else return_str = str + "NO!";
                Intent intent1 = new Intent();
                intent1.putExtra("return_str", return_str);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

    }
}