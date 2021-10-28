package online.danbao.fileexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalActivity extends AppCompatActivity {
    private static final String FILE_NAME = "a.png";
    private ImageView ivPic;
    Button btnSave, btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);

        ivPic =findViewById(R.id.iv_pic);
        btnSave = (Button) findViewById(R.id.btn_save_sd);
        btnRead = (Button) findViewById(R.id.btn_read_sd);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToSD();
                Toast.makeText(ExternalActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFormSD();
            }
        });
    }

    //SD卡：外部的公有文件夹，需要申请运行时权限
    private void saveToSD() {
        //申请写SD的权限，要求android的版本大于6.0(Build.VERSION_CODES.M)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return;
            }
        }

        //写SD卡的步骤
        //获取外部存储的pictures目录，创建存储文件
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
        );
        File file = new File(path, ExternalActivity.FILE_NAME);
        try {
//            if (!file.exists()) {
//                file.mkdirs();
//            }
            file.createNewFile();
            //获取ImageView的Bitmap图片对象
            BitmapDrawable drawable = (BitmapDrawable) ivPic.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            //将Bitmap对象写入SD卡
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            //关闭输出流
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFormSD() {
        //申请写SD的权限，要求android的版本大于6.0(Build.VERSION_CODES.M)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 2);
                return;
            }
        }

        //读取SD卡上文件
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File file = new File(path, ExternalActivity.FILE_NAME);
        try {
            if (!file.exists()) {

                //创建file的文件输入流
                FileInputStream fis = new FileInputStream(file);
                //将文件流写入imageview
                ivPic.setImageBitmap(BitmapFactory.decodeStream(fis));
                //关闭输入流
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "文件不存在或读取失败", Toast.LENGTH_SHORT).show();
        }
    }

    //权限请求需要回调，需要重写onRequestPermissionResult
    @Override
    public  void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0 ||
        grantResults[0]!=PackageManager.PERMISSION_GRANTED) {
            return;
        }
        switch (requestCode) {
            case 1: //写SD卡
                saveToSD();
                break;

        case 2: //读SD卡
        readFormSD();
        break;
        }
    }

    //将assets目录下的db文件写入/data/data/包名/databases、数据库文件名
//    private void
}