package com.lz.www.ambts;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016-07-30.
 */
@Module
public class AppModule {

    private AppApplication application;
    public AppModule(AppApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Context provideApplicationContext(){
        return application;
    }
}
