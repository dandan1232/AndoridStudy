package online.danbao.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseAdapterActivity extends AppCompatActivity {
    private ListView lv;
    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    MyBaseAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseadapter);
        lv = (ListView) findViewById(R.id.lv);
        //1
        list = getData();
        //2
        myAdapter = new MyBaseAdapter();
        //3
        lv.setAdapter(myAdapter);
    }

    private ArrayList<Map<String, Object>> getData() {
//        ArrayList<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", R.drawable.a);
        map.put("title", "嵌入式课程");
        map.put("info", "基础课程");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.b);
        map.put("title", "C语言课程");
        map.put("info", "基础语言");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.c);
        map.put("title", "Java语言");
        map.put("info", "基础语言");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.d);
        map.put("title", "Android开发");
        map.put("info", "移动核心课程");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.e);
        map.put("title", "Python课程");
        map.put("info", "基础课程");
        list.add(map);
        return list;

    }

    class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            int count = 0;
            if (null != list) {
                count = list.size();
            }
            return count;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            //View view;
            if (convertView == null) {
                LayoutInflater mInflater = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.listview_custom, null);
                viewHolder = new ViewHolder();
                viewHolder.tv_title = (TextView) convertView.findViewById(R.id.title);
                viewHolder.tv_info = (TextView) convertView.findViewById(R.id.info);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.img);
                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tv_title.setText("Name:" + list.get(position).get("title").toString());
            viewHolder.tv_info.setText("Info:" + list.get(position).get("info").toString());
            Resources res = getResources();
            Bitmap bmp = BitmapFactory.decodeResource(res,
                    Integer.parseInt(list.get(position).get("img").toString()));
            viewHolder.iv.setImageBitmap(bmp);
            return convertView;
        }

        class ViewHolder {
            TextView tv_title;
            TextView tv_info;
            ImageView iv;

        }

    }
}