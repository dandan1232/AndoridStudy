package online.danbao.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PassValue1Activity extends AppCompatActivity {
    Button bt;

    FragmentManager manager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_value1);
        bt = (Button) findViewById(R.id.bt);
        manager = getSupportFragmentManager();

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                fragmentTransaction = manager.beginTransaction();
                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("Key","I am meaasge to be sent...");
                fragment.setArguments(args);
                fragmentTransaction.replace(R.id.fl_container, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}