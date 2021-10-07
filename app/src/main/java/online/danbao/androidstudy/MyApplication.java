package online.danbao.androidstudy;

import android.app.Application;

public class MyApplication extends Application {
    String authorname;
    int age;
    String sex;
    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }
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