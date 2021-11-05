package online.danbao.studentinfoapp.utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtils {

    /**
     * 读取文件内容——>String
     * @param context Context对象
     * @param fileName assets 下的文件名
     * @return
     */
    public static String readFileToString(Context context, String fileName){
        InputStream is = null;

        try {
            //获取地址信息
            is = context.getResources().getAssets().open(fileName);
                //FileInputStream 用于读取诸如图像数据之类的原始字节流。要读取字符流，请考虑使用 FileReader。

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buffer=new byte[1024];
                int length=-1;
                while( (length = is.read(buffer)) != -1)
                {
                    bos.write(buffer,0,length);
                }
                bos.close();
                is.close();
                return bos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
