package online.danbao.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class PassValue3Activity extends AppCompatActivity implements ContentFragment.OnTextSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_value3);
    }


    public  void OnContentSelected(String myMsg) {
        Toast.makeText(this,"this message:"+myMsg,Toast.LENGTH_LONG).show();
    }
}