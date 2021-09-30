package online.danbao.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img_photo;
    Button btn_prev, btn_next;
    int[] drawChange = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};
    int nowIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);
        img_photo = (ImageView) findViewById(R.id.iv);
        btn_prev = (Button) findViewById(R.id.btn_previous);
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_prev.setOnClickListener(this);

        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_previous) {
            if (nowIndex > 0) {
                img_photo.setImageResource(drawChange[--nowIndex]);
            } else if (nowIndex == 0) {
                nowIndex = drawChange.length - 1;
                img_photo.setImageResource(drawChange[nowIndex]);
            }
        }
        if (v.getId() == R.id.btn_next) {
            if (++nowIndex < drawChange.length) {
                img_photo.setImageResource(drawChange[nowIndex]);
            } else {
                nowIndex = 0;
                img_photo.setImageResource(drawChange[nowIndex]);
            }
        }

    }
}