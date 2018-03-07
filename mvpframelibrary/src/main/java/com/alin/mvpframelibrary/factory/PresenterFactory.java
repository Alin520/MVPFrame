package com.alin.mvpframelibrary.factory;


import com.alin.mvpframelibrary.base.XPresenter;

/**
 * @创建者 hailin
 * @创建时间 2017/11/21 16:30
 * @描述 ${Presenter 工厂}.
 */

public interface PresenterFactory<P extends XPresenter> {
    P createPresenter();
}
