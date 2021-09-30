package online.danbao.androidstudy;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt3,bt4,bt5;
    myclass Listenter=new myclass();
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        bt3=(Button) findViewById(R.id.bt3);
        bt4=(Button) findViewById(R.id.bt4);
        bt5=(Button) findViewById(R.id.bt5);
        tv=(TextView)findViewById(R.id.tv);
        et=(EditText)findViewById(R.id.et);

        //第二种
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(et.getText().toString());
//                Toast.makeText(ButtonActivity.this,"this is a button3",Toast.LENGTH_SHORT).show();
            }
        });
        bt4.setOnClickListener(Listenter);
        bt5.setOnClickListener(this);
    }
    //第四种
    @Override
    public void onClick(View view) {
        Toast.makeText(ButtonActivity.this,"this is a button5",Toast.LENGTH_SHORT).show();
    }

    //第三种
    class myclass implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Toast.makeText(ButtonActivity.this,"this is a button4",Toast.LENGTH_SHORT).show();
        }
    }

    //第一种
    public void Message(View view){
        int id =view.getId();
        switch (id){
            case R.id.bt1:
                String username =et.getText().toString();
                tv.setText(username);
                // tv.setTextColor(0xf00f);
                break;
            case R.id.bt2:
                Toast.makeText(this,"this is a button2",Toast.LENGTH_SHORT).show();
                break;
        }


    }
    public void addButton(View view){
        LinearLayout linearLayout=findViewById(R.id.linear);
        Button bt=new Button(this);
        bt.setText("press button");
        bt.setTextSize(20);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams
                ((LinearLayout.LayoutParams.MATCH_PARENT),(LinearLayout.LayoutParams.WRAP_CONTENT));
        bt.setLayoutParams(params);
        linearLayout.addView(bt);


    }

}