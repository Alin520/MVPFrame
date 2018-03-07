package com.alin.mvpframelibrary;

import com.alin.mvpframelibrary.base.IBaseView;
import com.alin.mvpframelibrary.base.XPresenter;

/**
 * @创建者 hailin
 * @创建时间 2017/11/22 13:22
 * @描述 ${}.
 */

public interface Contract {

    interface IView<T> extends IBaseView {
        void showContentData(T data);
    }

    class IPresenter extends XPresenter<IView> {

       public void  getDataFromNet(Object obj){}

       public void getMoreDataFromNet(){}
    }
}
