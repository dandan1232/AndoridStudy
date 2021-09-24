package online.danbao.andoridstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb_male, rb_female, rb;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        rg = (RadioGroup) findViewById(R.id.rg);
//        rb_male=(RadioButton)findViewById(R.id.rb_male);
//        rb_female=(RadioButton)findViewById(R.id.rb_female);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) findViewById(checkedId);
                String str = rb.getText().toString();
                Toast.makeText(RadioButtonActivity.this, "Your sex is: " + str, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void submit(View view) {
        rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        String str = rb.getText().toString();
        if (str.equals("male")) {
            str = "BOY";
        } else
            str = "GIRL";
        Toast.makeText(RadioButtonActivity.this, "Your are a  " + str, Toast.LENGTH_LONG).show();
    }
}