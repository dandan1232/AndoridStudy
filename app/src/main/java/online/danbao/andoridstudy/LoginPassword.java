package online.danbao.andoridstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginPassword extends AppCompatActivity {
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
    EditText username,pwd;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        username=(EditText)findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =username.getText().toString();
                String password =pwd.getText().toString();
                Toast.makeText(LoginPassword.this,"user input message include name:"+name+" password:"+password,Toast.LENGTH_SHORT).show();
            }
        });
    }
}