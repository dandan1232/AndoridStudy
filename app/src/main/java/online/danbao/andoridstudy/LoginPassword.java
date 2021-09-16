package online.danbao.andoridstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPassword extends AppCompatActivity {
    //    (9.16)
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
    }
}