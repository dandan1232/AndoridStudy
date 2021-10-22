package online.danbao.examsystem;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;



public class FirstActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_layout);



        final EditText editText1 = (EditText) findViewById(R.id.editText1);

        final EditText editText2 = (EditText) findViewById(R.id.editText2);



        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (editText1.getText().toString().equals("ldd"))

                {

                    if (editText2.getText().toString().equals("01010101")) {

                        Toast.makeText(FirstActivity.this,"登录成功，欢迎进入考试系统",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                        startActivity(intent);

                    } else {

                        Toast.makeText(FirstActivity.this, "用户名和密码不正确，请重新输入", Toast.LENGTH_SHORT).show();

                    }

                }

                else

                {

                    Toast.makeText(FirstActivity.this, "用户名和密码不正确，请重新输入", Toast.LENGTH_SHORT).show();

                }

            }

        });



        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                finish();

            }

        });

    }

}