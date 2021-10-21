package online.danbao.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView m_ListView;
//    String[] str = {"aaa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_ListView = (ListView) findViewById(R.id.lv);
        //1、data
        String[] dataarray = getResources().getStringArray(R.array.data_array);
        //2、adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataarray);
        //3、binder
        m_ListView.setAdapter(adapter);
    }
}