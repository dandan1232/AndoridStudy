package online.danbao.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PassValue2Activity extends AppCompatActivity {
    Button bt;

    FragmentManager manager;
    FragmentTransaction fragmentTransaction;
    ContentFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_value2);
        bt = (Button) findViewById(R.id.bt);
        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        fragment = new ContentFragment();
        fragmentTransaction.add(R.id.fl_container, fragment, "x");
        fragmentTransaction.commit();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment =(ContentFragment) manager.findFragmentByTag("x");
                fragment.setMsg("Pass Value!");
            }
        });
    }
}