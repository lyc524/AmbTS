package com.lz.www.ambts.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import com.lz.www.ambts.R;
import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.model.bean.Fa;
import com.lz.www.ambts.model.bean.Report;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-06-06.
 */
public class FaAdapter extends BaseExpandableListAdapter {
    private ArrayList<Fa> groupList;
    private ArrayList<ArrayList<Fa>> itemList;
    private Context mContext;

    public FaAdapter(ArrayList<Fa> gData, ArrayList<ArrayList<Fa>> iData, Context mContext) {
        this.groupList = gData;
        this.itemList = iData;
        this.mContext = mContext;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return itemList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return groupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return itemList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup holderGroup;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_elist_fa_group,viewGroup,false);
            holderGroup=new ViewHolderGroup();
            holderGroup.tv_group_name=(TextView)view.findViewById(R.id.tvGroupName);
            holderGroup.tv_group_money=(TextView)view.findViewById(R.id.tvGroupMoney);
            view.setTag(holderGroup);
        }else {
            holderGroup=(ViewHolderGroup)view.getTag();
        }
        holderGroup.tv_group_name.setText(groupList.get(i).getName());
        String code=groupList.get(i).getCode();
        if(code.equals("400")||code.equals("700")){
            holderGroup.tv_group_money.setText(groupList.get(i).getMoney().toString() + "%");
        }else {
            holderGroup.tv_group_money.setText("￥" + String.format("%.0f",groupList.get(i).getMoney()));
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderItem holderItem;
        if(view==null){
            view= LayoutInflater.from(mContext).inflate(R.layout.item_elist_fa_sub,viewGroup,false);
            holderItem=new ViewHolderItem();
            holderItem.tv_name=(TextView)view.findViewById(R.id.tvChildName);
            holderItem.tv_money=(TextView)view.findViewById(R.id.tvChildMoney);
            view.setTag(holderItem);
        }else {
            holderItem=(ViewHolderItem) view.getTag();
        }
        holderItem.tv_name.setText(itemList.get(i).get(i1).getName());
        holderItem.tv_money.setText("￥" + String.format("%.0f",itemList.get(i).get(i1).getMoney()));

        return view;
    }


    private static class ViewHolderGroup{
        private TextView tv_group_name;
        private TextView tv_group_money;

    }

    private static class ViewHolderItem{
        //private ImageView img_icon;
        private TextView tv_name;
        private TextView tv_money;
    }


}


