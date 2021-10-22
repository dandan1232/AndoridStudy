package online.danbao.examsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;



public class FifthActivity extends AppCompatActivity {

    int score = 0;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fifth_layout);



        final Intent intent = getIntent();

        score = intent.getIntExtra("data",0);



        TextView textView9 = (TextView)findViewById(R.id.textView9);

        textView9.setText(String.valueOf(score));



        Button button8 = (Button)findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent1 = new Intent(FifthActivity.this,SecondActivity.class);

                startActivity(intent1);

            }

        });



        Button button9 = (Button)findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Intent intent1 = new Intent(Intent.ACTION_MAIN);

                intent1.addCategory(Intent.CATEGORY_HOME);

                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent1);

                System.exit(0);

            }

        });

    }

}