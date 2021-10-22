package online.danbao.examsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;



public class SecondActivity extends AppCompatActivity {



    int score = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);



        final EditText editText3 = (EditText) findViewById(R.id.editText3);

        final EditText editText4 = (EditText) findViewById(R.id.editText4);



        Button button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if (editText3.getText().toString().equals("下划线"))

                    score = score + 10;

                if (editText4.getText().toString().equals("美元符号"))

                    score = score + 10;



                int data = score;

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

                intent.putExtra("data", data);

                startActivity(intent);

            }

        });

    }

}