package online.danbao.fragmentexample;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt_right);
        transationFragment(new LeftFragment());
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OtherFragment otherFragment = new OtherFragment();
                transationFragment(otherFragment);
            }
        });

    }

    private void transationFragment(Fragment fragment) {
        //manger
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_left, fragment);
        //将fragment加入回退栈，但后续不再访问（可选）
        transaction.addToBackStack(null);
        transaction.commit();

    }

}