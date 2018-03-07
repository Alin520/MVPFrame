package com.alin.mvpframe.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alin.commonlibrary.annotations.TargetLog;
import com.alin.commonlibrary.util.ToastUtil;
import com.alin.commonlibrary.view.RoundRectLinearLayout;
import com.alin.mvpframe.R;
import com.alin.mvpframe.model.TestBean;
import com.alin.mvpframelibrary.Contract;
import com.alin.mvpframelibrary.MvpActivity;
import com.alin.mvpframelibrary.factory.TargetPresenter;

import butterknife.OnClick;

/**
 * ================================================
 * 作    者   ： hailinhe
 * github地址 ： https://github.com/Alin520/Mvp-Rxjava-Retrofit
 * CSDN地址   ： http://blog.csdn.net/hailin123123/article/details/78643330
 * 创建时间    ： 2018/3/7 9:55
 * 版    本   ： ${TODO}
 * 描    述   ：  ${MVP架构测试类——Activity}
 * ================================================
 */
@TargetLog(TestMvpActivity.class)
@TargetPresenter(TestMvpPresent.class)
public class TestMvpActivity extends MvpActivity<TestMvpPresent> implements Contract.IView<TestBean>, View.OnClickListener {
    private TestMvpPresent mPresenter;
    private RoundRectLinearLayout mTestRllyt;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_mvp;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mTestRllyt = findViewById(R.id.test_rllyt);
        findViewById(R.id.start_tv).setOnClickListener(this);
        findViewById(R.id.skip_tv).setOnClickListener(this);
        //        创建说需要的Presenter
        mPresenter = createPresenter();
    }

//    @OnClick({R.id.start_tv,R.id.skip_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.start_tv:
                mPresenter.startWork();//调用Presenter的初始化方法
                break;
            case R.id.skip_tv:
                startActivity(new Intent(TestMvpActivity.this,TestCommonActivity.class));
                break;
        }
    }
    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void showContentView() {
        mTestRllyt.showContentView();
    }

    //    数据请求失败回调
    @Override
    public void showError(String errorInfo, int errorCode) {
        mTestRllyt.showEmptyView();
    }


    //    数据请求成功回调
    @Override
    public void showContentData(TestBean data) {
        if (data != null) {
            showLog(data.toString());
            ToastUtil.showCenterToast(this,"TestMvpActivity测试数据 : : " + data.toString());
        }
    }
}