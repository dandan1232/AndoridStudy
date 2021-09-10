package online.danbao.andoridstudy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        通过find试图发现tv3对象
//        用(TextView)进行强制类型转换
        TextView textView =(TextView)findViewById(R.id.tv3);
//        对后台控件进行操作
        textView.setText("this is a third textview");
        textView.setTextSize(28);
        textView.setTextColor(0xf);
    }
}