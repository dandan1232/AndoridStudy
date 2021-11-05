package online.danbao.studentinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPasswordActivity extends AppCompatActivity {

    EditText input_id, edit_load_zhanghao,textinput_p,edit_load_password;
    Button imagebutton, button_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        edit_load_zhanghao = (EditText) findViewById(R.id.edit_load_zhanghao);
        edit_load_password = (EditText) findViewById(R.id.edit_load_password);
        button_load = (Button) findViewById(R.id.button_load);
        button_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edit_load_zhanghao.getText().toString();
                String password = edit_load_password.getText().toString();
                Toast.makeText(LoginPasswordActivity.this, "欢迎您，" + name + "！您正在使用学生身份登录。",
                        Toast.LENGTH_SHORT).show();
                //显示intent
                Intent intent = new Intent(LoginPasswordActivity.this, BasicInfoActivity.class);
                startActivity(intent);

            }
        });

    }
}