package com.example.companymanagementsystem;

import android.app.Application;
import android.util.Log;

import com.example.companymanagementsystem.model.Person;

import java.util.ArrayList;

public class ManagementApplication extends Application {
    public static ArrayList<Person> personList;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("LifeCycle Method:: ","In onCreate");
        initializeData();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d("LifeCycle Method:: ","In onTrimMemory");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("LifeCycle Method:: ","In onLowMemory");
    }

    /**
     * Initialize the Views
     */
    private void initializeData() {
        personList = new ArrayList<>();
        personList.add(new Person("Swati", "Khobragade", "Nagpur", "B.E"));
        personList.add(new Person("Ragini", "Jain", "Sagar", "B.E"));
        personList.add(new Person("Komal", "Nistane", "Akola", "B.E"));
        personList.add(new Person("Sayali", "Deshpande", "Amravati", "B.E"));
        personList.add(new Person("Neha", "Ghugare", "Bhandara", "B.E"));
    }

    @Override
    public void onTerminate() {
        personList.clear();
        Log.i("On Terminate", String.valueOf(personList));
        super.onTerminate();
    }
}
