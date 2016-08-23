package com.lz.www.ambts.ui.module;

import com.lz.www.ambts.model.jk.ISbuService;
import com.lz.www.ambts.model.jk.IWoService;
import com.lz.www.ambts.presenter.SbuPresenter;
import com.lz.www.ambts.presenter.WoPresenter;
import com.lz.www.ambts.presenter.jk.ISbuPresenter;
import com.lz.www.ambts.presenter.jk.IWoPresenter;
import com.lz.www.ambts.ui.fragment.WoFragment;
import com.lz.www.ambts.ui.jk.ISbuView;
import com.lz.www.ambts.ui.jk.IWoView;
import com.lz.www.ambts.util.Config;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016-08-22.
 */
@Module
public class WoModule {
    WoFragment fragment;

    public WoModule(WoFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    IWoView provideView(){
        return fragment;
    }

    @Provides
    IWoService provideModel(){
        return  new Retrofit.Builder()
                .baseUrl(Config.AMB_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IWoService.class);
    }

    @Provides
    IWoPresenter providePresenter(IWoView view, IWoService model){
        return new WoPresenter(view,model);
    }
}
