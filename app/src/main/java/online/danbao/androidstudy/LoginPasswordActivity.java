package online.danbao.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPasswordActivity extends AppCompatActivity {
/*    //    (9.16)
    TextView textView;
    EditText ET;
    String str;
    String str1;
    EditText ET_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
//        通过find视图发现tv3对象
//        用(TextView)进行强制类型转换
        textView = (TextView)findViewById(R.id.tv3);
//    （9.16）
        ET = (EditText)findViewById(R.id.ET);
        ET_pwd = (EditText)findViewById(R.id.ET_pwd);
//        对后台控件进行操作
        textView.setText("this is a result");
        textView.setTextSize(28);
//        textView.setTextColor(0xf00f);
//     (9.16)将得到的内容展示(单机监听)
//        ET.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                //（9.16）获得用户输入文本框里的内容
//                str = ET.getText().toString();
//                textView.setText(str);
//            }
//        });
//        ET.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v,boolean hasFocus){
//                //（9.16）获得用户输入文本框里的内容
//                str = ET.getText().toString();
//                textView.setText(str);
//            }
//        });
        textView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                str = ET.getText().toString();
                str1 = ET_pwd.getText().toString();
                textView.setText("user:"+str+"   password:"+str1);
                return true;
            }
        });
    }*/

    //9.17作业版
    EditText username, pwd;
    Button submit, btn_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        submit = (Button) findViewById(R.id.submit);
        btn_call = (Button) findViewById(R.id.btn_call);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String password = pwd.getText().toString();
                Toast.makeText(LoginPasswordActivity.this, "user input message include name:" + name + " password:" + password, Toast.LENGTH_SHORT).show();
                //显示intent
////                Intent intent = new Intent(LoginPasswordActivity.this, LoginActivity.class);
//                //一
//                Intent intent = new Intent();
//                //二
//                intent.setClassName("online.danbao.andoridstudy", "online.danbao.andoridstudy.LoginActivity");
//                startActivity(intent);

                //隐式intent
                Intent intent = new Intent();
                intent.setAction("online.danbao.androidstudy.stu_info");
                startActivity(intent);
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18962494510"));
                startActivity(intent);
            }
        });
    }
}