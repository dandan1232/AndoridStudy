package online.danbao.examsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.CheckBox;

import android.widget.CompoundButton;



public class FourthActivity extends AppCompatActivity {



    int score = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fourth_layout);



        Intent intent = getIntent();

        score = intent.getIntExtra("data",0);



        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);



        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override

            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)

                    score = score + 20;

            }

        });



        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)

                    score = score + 20;

            }

        });



        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override

            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)

                    score = score + 20;

            }

        });



        Button button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent1 = new Intent(FourthActivity.this, ThirdActivity.class);

                startActivity(intent1);

            }

        });



        Button button7 = (Button) findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                int data = score;

                Intent intent2 = new Intent(FourthActivity.this,FifthActivity.class);

                intent2.putExtra("data",data);

                startActivity(intent2);

            }

        });

    }

}