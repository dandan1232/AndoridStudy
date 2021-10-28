package online.danbao.fileexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_name, et_content;
    Button bt_save,bt_open, bt_delete;
    String filename, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_content = (EditText) findViewById(R.id.et_content);
        bt_save = (Button) findViewById(R.id.bt_save);
        bt_open = (Button) findViewById(R.id.bt_open);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_save.setOnClickListener(this);
        bt_open.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_save:
                filename = et_name.getText().toString().trim();
                content = et_content.getText().toString().trim();
                if (TextUtils.isEmpty(filename)) {
                    Toast.makeText(this, "Name can not null", Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    FileOutputStream fileOutputStream = openFileOutput(filename, MODE_PRIVATE);
                    fileOutputStream.write(content.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(this, "Saved successfully", Toast.LENGTH_LONG).show();
                    et_name.setText("");
                    et_content.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bt_open:
                filename = et_name.getText().toString().trim();
                if (TextUtils.isEmpty(filename)) {
                    Toast.makeText(this,"Name can not null",Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    FileInputStream fileInputStream = openFileInput(filename);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    fileInputStream.close();
                    et_content.setText(new String(buffer));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.bt_delete:
                String x = et_name.getText().toString();
                filename = et_name.getText().toString().trim();
                if (TextUtils.isEmpty(filename)) {
                    Toast.makeText(this, "Name can not null", Toast.LENGTH_LONG).show();
                    return;
                }
                boolean deletefile = deleteFile(filename);
                if (deletefile) {
                    Toast.makeText(this, "Delete succeeded", Toast.LENGTH_LONG).show();
                    et_name.setText("");
                    et_content.setText("");
                }
                break;
        }

    }
}