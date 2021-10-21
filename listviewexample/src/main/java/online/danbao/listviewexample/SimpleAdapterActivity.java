package online.danbao.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {
    ListView lv;
    List<Map<String, Object>> list;
    //    private int[] images = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
//            R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
//            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    private int[] images = {R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter);
        lv = (ListView) findViewById(R.id.lv);
        //1
        list = new ArrayList<Map<String, Object>>();
        for (int i = 1; i < 7; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", images[i - 1]);
            map.put("text", "薛之谦的第" + i + "张照片");
            list.add(map);
        }
        //2
        SimpleAdapter adapter = new SimpleAdapter(this, list,
                R.layout.simpleadapteritem,
                new String[]{"img", "text"},
                new int[]{R.id.iv, R.id.tv});
        //3
        lv.setAdapter(adapter);
    }
}