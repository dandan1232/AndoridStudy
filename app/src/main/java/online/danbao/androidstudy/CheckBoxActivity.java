package online.danbao.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;


public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    TextView tv_result;
    CheckBox cb_1, cb_2, cb_3;
    String str = "your course :";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        tv_result = (TextView) findViewById(R.id.tv_result);
        cb_1 = (CheckBox) findViewById(R.id.cb_1);
        cb_2 = (CheckBox) findViewById(R.id.cb_2);
        cb_3 = (CheckBox) findViewById(R.id.cb_3);
        btn = (Button) findViewById(R.id.btn);
        cb_1.setOnCheckedChangeListener(this);
        cb_2.setOnCheckedChangeListener(this);
        cb_3.setOnCheckedChangeListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "your course:";
                boolean f = false;
                if (cb_1.isChecked()) {
                    str += cb_1.getText() + ",";
                    f = true;
                }
                if (cb_2.isChecked()) {
                    str += cb_2.getText() + ",";
                    f = true;
                }
                if (cb_3.isChecked()) {
                    str += cb_3.getText() + ",";
                    f = true;
                }
                if (f) {
                    str = str.substring(0, str.length() - 1);
                }
                Toast.makeText(CheckBoxActivity.this, str, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        CheckBox cb = (CheckBox) buttonView;
        if (isChecked) {
            str += cb.getText().toString() + "; ";
        } else
            str = str.replace(cb.getText().toString() + "; ", " ");
        tv_result.setText(str);
    }
}