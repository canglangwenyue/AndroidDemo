package me.androiddemo.canglangwenyue.androiddemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by canglangwenyue on 12/5/14.
 * Parcelable常用于Intent中进行自定义对象的传递
 */
public class Person implements Parcelable {


    public String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);

    }

    /*
    需要重写Creator实现android.os.Parcelable接口的类必须持有一个实现了android.os.Parcelable接口的名为 CREATOR 的静态字段
     */

    public static final Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

        /*
        重写Creator方法
         */
        @Override
        public Person createFromParcel(Parcel source) {
            Person person = new Person();
            person.name = source.readString();
            return person;
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }

    };


}
