package online.danbao.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_name, et_age;
    Button btn_save, btn_resume;
    SharedPreferences sp;
    String name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        btn_save = (Button) findViewById(R.id.btn_save);
        btn_resume = (Button) findViewById(R.id.btn_resume);
        btn_save.setOnClickListener(this);
        btn_resume.setOnClickListener(this);

        sp = getSharedPreferences("stu_info", MODE_PRIVATE);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                name = et_name.getText().toString().trim();
                age = et_age.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
                    return;
                }
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", name);
                editor.putString("age", age);
                boolean commit = editor.commit();
                if (commit) {
                    Toast.makeText(this, "save successing", Toast.LENGTH_LONG).show();
                    et_name.setText("");
                    et_age.setText("");
                }
                break;
            case R.id.btn_resume:
                name = sp.getString("name", "");
                age = sp.getString("age", "");
                et_name.setText(name);
                et_age.setText(age);
                break;
        }

    }
}