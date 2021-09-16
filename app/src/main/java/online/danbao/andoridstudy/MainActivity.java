package online.danbao.andoridstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText ET;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        通过find试图发现tv3对象
//        用(TextView)进行强制类型转换
        textView = (TextView) findViewById(R.id.tv3);
        ET = (EditText) findViewById(R.id.ET);
//        对后台控件进行操作
        textView.setText("this is a third textview");
        textView.setTextSize(28);
//        textView.setTextColor(0xf00f);

        ET.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //（9.16）获得用户输入文本框里的内容
                str = ET.getText().toString();
                textView.setText(str);
            }
        });
//        ET.setOnFocusChangeListener(new View.OnFocusChangeListener(){
//            @Override
//            public void onFocusChange(View v,boolean hasFocus){
//                //（9.16）获得用户输入文本框里的内容
//                str = ET.getText().toString();
//                textView.setText(str);
//            }
//        });
    }
}