package com.alin.mvpframe.activity;

import com.alin.commonlibrary.util.AppUtil;
import com.alin.commonlibrary.util.LogUtil;
import com.alin.mvpframe.model.TestBean;
import com.alin.mvpframelibrary.Contract;

/**
 * ================================================
 * 作    者   ： hailinhe
 * github地址 ： https://github.com/Alin520/Mvp-Rxjava-Retrofit
 * CSDN地址   ： http://blog.csdn.net/hailin123123/article/details/78643330
 * 创建时间    ： 2018/3/7 9:58
 * 版    本   ： ${TODO}
 * 描    述   ：  ${Presenter逻辑处理层}
 * ================================================
 */
public class TestMvpPresent extends Contract.IPresenter {

    @Override
    public void startWork() {
        getDataFromNet("");
    }

    @Override
    public void getDataFromNet(Object o) {
        AppUtil.checkNotNull(mView,"View == null,use TestPresenter is not attachView view!");
        TestBean bean = new TestBean("测试mvp架构", 12);
        mView.showContentData(bean);
        mView.showContentView();
    }


    public void onCreate(){
        LogUtil.showLog(TestMvpPresent.class,"onCreate");
    }

    public void onStart(){
        LogUtil.showLog(TestMvpPresent.class,"onStart");
    }

    public void onResume(){
        LogUtil.showLog(TestMvpPresent.class,"onResume");
    }

    public void onPause(){
        LogUtil.showLog(TestMvpPresent.class,"onPause");
    }

    public void onStop(){
        LogUtil.showLog(TestMvpPresent.class,"onStop");
    }

    @Override
    public void onDestory() {
        super.onDestory();
        LogUtil.showLog(TestMvpPresent.class,"onDestory");
    }
}