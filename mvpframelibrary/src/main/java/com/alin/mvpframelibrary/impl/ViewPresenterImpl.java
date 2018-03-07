package com.alin.mvpframelibrary.impl;

import com.alin.mvpframelibrary.base.XPresenter;
import com.alin.mvpframelibrary.factory.PresenterFactory;
import com.alin.mvpframelibrary.manager.PresenterLifecycleManager;

/**
 * @创建者 hailin
 * @创建时间 2017/11/22 10:16
 * @描述 ${具体presenter的设置}.
 */

public interface ViewPresenterImpl<P extends XPresenter> {

    P createPresenter();

    void setPresenterFactory(PresenterFactory<P> presenterFactory);

    PresenterFactory<P> getPresenterFactory();

    void setPresenterManager(PresenterLifecycleManager presenterManager);

    PresenterLifecycleManager getPresenterManager();
}
