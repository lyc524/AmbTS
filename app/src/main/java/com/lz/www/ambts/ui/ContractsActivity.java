package com.lz.www.ambts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.bean.Contacts;
import com.lz.www.ambts.presenter.jk.IContactsPresenter;
import com.lz.www.ambts.provider.ContactsResolver;
import com.lz.www.ambts.ui.component.DaggerContactsComponent;
import com.lz.www.ambts.ui.jk.IContactsView;
import com.lz.www.ambts.ui.module.ContactsModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016-06-29.
 */
public class ContractsActivity extends AppCompatActivity implements IContactsView {

    @Inject
    IContactsPresenter presenter;

    @InjectView(R.id.myTool)
    Toolbar toolbar;

    @InjectView(R.id.lvUserList)
    ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        ButterKnife.inject(this);
        DaggerContactsComponent.builder().contactsModule(new ContactsModule(this)).build().inject(this);

        toolbar.setTitle("通讯录");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        presenter.start();
    }

//    @OnClick(R.id.btnSearchUser)
//    public void OnClick(View view){
//        String key=etName.getText().toString();
//        presenter.searchContactsList(key);
//    }

    @Override
    public void showContactsList(List<Map<String, String>> list) {
        SimpleAdapter adapter= new SimpleAdapter(this,list,R.layout.item_list_news,new String[]{"name","number"},new int[]{R.id.tvTitle,R.id.tvContent});
        lvContacts.setAdapter(adapter);
    }

    @Override
    public void showLoadFail() {
        Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
    }
}
