package com.alin.mvpframe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alin.mvpframe.R;
import com.alin.mvpframe.base.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        super.initialize(savedInstanceState);
        findViewById(R.id.mvp_activity_tv).setOnClickListener(this);
        findViewById(R.id.mvp_fragment_tv).setOnClickListener(this);

    }

    //    @OnClick({R.id.mvp_activity_tv,R.id.mvp_fragment_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.mvp_activity_tv:
                startActivity(new Intent(MainActivity.this, TestMvpActivity.class));
                break;
            case R.id.mvp_fragment_tv:
                startActivity(new Intent(MainActivity.this, TestFragmentActivity.class));
                break;
        }
    }
}
