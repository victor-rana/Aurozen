package com.test.aurozen;

import android.app.Application;
import android.content.Context;

import com.test.aurozen.data.DataFactory;
import com.test.aurozen.data.DataService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class Singleton extends Application {
    private DataService dataService;
    private Scheduler scheduler;
    static Singleton application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Singleton get(Context context){

        return application;
    }

    public static Context create(Context context){
        return Singleton.get(context);
    }


    public DataService getDataService(){
        if (dataService == null){
            dataService= DataFactory.create();

        }
        return dataService;
    }


    public Scheduler subscribeScheduler(){
        if (scheduler == null) {
            scheduler = Schedulers.io();
        }

        return scheduler;
    }


}
