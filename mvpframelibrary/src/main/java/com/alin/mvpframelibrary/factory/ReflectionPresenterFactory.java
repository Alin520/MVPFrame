package com.alin.mvpframelibrary.factory;


import com.alin.mvpframelibrary.base.XPresenter;

/**
 * @创建者 hailin
 * @创建时间 2017/11/21 17:24
 * @描述 ${}.
 */

public class ReflectionPresenterFactory<P extends XPresenter> implements PresenterFactory<P> {

    private Class<P> mPClass;

    public ReflectionPresenterFactory(Class<P> pClass) {
        this.mPClass = pClass;
    }

    /**
     *  1、获取PresenterFactory工厂实例
     * @return
     */
    public static <P extends XPresenter> ReflectionPresenterFactory<P> fromViewClass(Class<?> clzzz){
        ReflectionPresenterFactory factory = null;
        try {
            TargetPresenter annotation = clzzz.getAnnotation(TargetPresenter.class);
            if (annotation == null) {
                return null;
            }else {
                Class<? extends XPresenter> presenter = annotation.value();
                if (presenter != null) {
                    factory = new ReflectionPresenterFactory(presenter);
                }
            }
        }catch (Throwable t){
            t.printStackTrace();
        }
        return factory;

    }

    /**
     * 2、创建Presenter
     * @return
     */
    @Override
    public P createPresenter() {
        P pClass = null;
        if (mPClass != null) {
            try {
                pClass = mPClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return pClass;
    }
}
