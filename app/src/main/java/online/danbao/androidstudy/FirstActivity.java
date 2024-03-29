package online.danbao.androidstudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    Intent intent;
    MyApplication app;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        tv = (TextView) findViewById(R.id.tv_result);
    }

    public void send(View v) {
        int ID = v.getId();
        switch (ID) {
            case R.id.btn_1:
                intent = new Intent(FirstActivity.this, SecondActivity.class);
//                  一条一条消息的传递：传简单值方法之一：putExtra
                intent.putExtra("username", "zhangsan");
                intent.putExtra("password", 123456);
                startActivity(intent);
                break;
            case R.id.btn_2:
//                创建Bundle
                intent = new Intent(FirstActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", "LIsi");
                bundle.putInt("password", 123456);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.btn_3:
                //设置app全局变量对象
                intent = new Intent(FirstActivity.this, SecondActivity.class);
                app = (MyApplication) getApplication();
                app.setAuthorname("wanger");
                app.setAge(21);
                app.setSex("female");
                startActivity(intent);
                break;
            case R.id.btn_4:
                //result要回应
                intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("username", "zhangsan");
                //响应码
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                String str = data.getStringExtra("return_str");
                tv.setText(str);

            }
        }
    }
}