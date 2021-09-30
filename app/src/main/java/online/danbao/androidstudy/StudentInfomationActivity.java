package online.danbao.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class StudentInfomationActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    EditText name,phone;
    RadioGroup rg;
    RadioButton rb_male,rb_female,rb;
    CheckBox cb_1,cb_2,cb_3,cb_4,cb;
    String str = "your course:   ";
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfomation);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        rg = (RadioGroup)findViewById(R.id.rg);
        cb_1 = (CheckBox)findViewById(R.id.cb_1);
        cb_2 = (CheckBox)findViewById(R.id.cb_2);
        cb_3 = (CheckBox)findViewById(R.id.cb_3);
        cb_4 = (CheckBox)findViewById(R.id.cb_4);
        submit = (Button)findViewById(R.id.submit);
        cb_1.setOnCheckedChangeListener(this);
        cb_2.setOnCheckedChangeListener(this);
        cb_3.setOnCheckedChangeListener(this);
        cb_4.setOnCheckedChangeListener(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str3= name.getText().toString();
                String str4= phone.getText().toString();
                rb = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
                String str1 = rb.getText().toString();
                if (str1.equals("male")) {
                    str1 = "Boy";
                }else if(str1.equals("female")){
                    str1 = "Girl";
                }
                String str = "我喜欢的专业课:";
                boolean f = false;
                if(cb_1.isChecked()){
                    str += cb_1.getText()+",";
                    f = true;
                }
                if(cb_2.isChecked()){
                    str += cb_2.getText()+",";
                    f = true;
                }
                if(cb_3.isChecked()){
                    str += cb_3.getText()+",";
                    f = true;
                }
                if(cb_4.isChecked()){
                    str += cb_4.getText()+",";
                    f = true;
                }
                if(f){
                    str = str.substring(0, str.length()-1);
                }
                Toast.makeText(StudentInfomationActivity.this, "我叫"+str3+";"+"我的手机号是"+str4+";"+"我的性别为:" + str1 +";"+str, Toast.LENGTH_LONG).show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
                String str = rb.getText().toString();
                Toast.makeText(StudentInfomationActivity.this,"your gender is:" + str,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}