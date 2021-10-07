package online.danbao.androidstudy;

import android.app.Application;

//全局应用级别共享
public class MyApplication extends Application {
    String authorname;
    int age;
    String sex;
//    写数据
    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
//    读数据
    public String getAuthorname(){
        return authorname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
}