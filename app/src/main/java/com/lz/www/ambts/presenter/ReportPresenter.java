package com.lz.www.ambts.presenter;

import com.lz.www.ambts.model.BigSorts;
import com.lz.www.ambts.model.SubSorts;
import com.lz.www.ambts.model.bean.Report;
import com.lz.www.ambts.model.jk.IReportService;
import com.lz.www.ambts.presenter.jk.IReportPresenter;
import com.lz.www.ambts.ui.jk.IReportView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-03.
 */
public class ReportPresenter implements IReportPresenter {

    IReportView mView;
    IReportService mModel;

    public ReportPresenter(IReportView mView) {
        this.mView = mView;
        this.mModel = mModel;
    }

    @Override
    public void loadAllList() {
        ArrayList<Report> allList = null;
        ArrayList<Report> groupList = null;
        ArrayList<ArrayList<Report>> subListList = null;
        ArrayList<Report> subList = null;
//
//        //数据准备
//        groupList = new ArrayList<Report>();
//        groupList.add(new BigSorts("收入"));
//        groupList.add(new BigSorts("费用"));
//        groupList.add(new BigSorts("利润"));
//
//        subListList = new ArrayList<ArrayList<SubSorts>>();
//
//        subList = new ArrayList<SubSorts>();
//
//        //收入组
//        subList.add(new SubSorts("001","A商品销售"));
//        subList.add(new SubSorts("002","B商品销售"));
//        subList.add(new SubSorts("003","C商品销售"));
//        subListList.add(subList);
//
//        //费用组
//        subList = new ArrayList<SubSorts>();
//        subList.add(new SubSorts("001","变动费用"));
//        subList.add(new SubSorts("002","固定费用"));
//        subList.add(new SubSorts("003","人工成本"));
//        subListList.add(subList);
//
//        //利润组
//        subList = new ArrayList<SubSorts>();
//        subList.add(new SubSorts("001","销售利润"));
//        subList.add(new SubSorts("002","节约利润"));
//        subList.add(new SubSorts("003","固定资产"));
//        subListList.add(subList);
        allList=mModel.getAllList();


        mView.showAllList(groupList,subListList);
    }

    @Override
    public void start() {
        loadAllList();
    }
}
