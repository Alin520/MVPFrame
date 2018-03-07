
# MvpFrame
[![License](https://img.shields.io/badge/license-Apache%202-green.svg)](https://www.apache.org/licenses/LICENSE-2.0) [![Download](https://api.bintray.com/packages/alinlibrary/alinbanner/bannerview/images/download.svg) ](https://bintray.com/alinlibrary/alinbanner/bannerview/_latestVersion)

> [MvpFrame](https://github.com/Alin520/MvpFrame)是一款是一款MVP通用框架，使用简单，有效的解决项目中的高度耦合性，使项目更有层次结构。 


## 版本更新记录

[版本更新记录](https://github.com/Alin520/MvpFrame/blob/master/CHANGELOG.md)

# 前序

>随着项目的功能迭代，传统的MVC架构已经很难满足开发需求了，高耦合让维护成本变得越来越高，代码冗余程度也越来越高，代码最后变得臃肿不堪。所以，在实际项目中，我们跟多的选择MVP架构。MVP架构是代码结构层次更加清晰、项目更加容易维护，代码耦合性降低了。本文对于基础的mvp使用不做解释。

# 一、MvpFrame架构优点：
>	1）用泛型指定Presenter层，然后直接createPresenter方法即可获取到对于的presenter。</br>
	2）Presenter的生命周期与Activity生命周期同步绑定。</br>
	3）抽象工厂模式和反射机制，获取每个Presenter对象。</br>
	4）对Presenter的缓存处理。</br>
	5）异常情况下（如内存吃紧），对Presenter进行onSaveInstanceState保存数据的异常处理。</br>


# 二、使用说明
### step1、添加依赖（ 必选）

```
dependencies {
   implementation 'com.alin:common-library:1.0.2'
}
    
```

### step2、注解@TargetPresenter(具体Presenter.class)（ 必选）


### step3、需要继承MvpActivity，并且指定Presenter的泛型类型TestMvpPresent（若有）（ 必选）

### step4、同时，实现Contract.IView<数据类型>（ 可选）
### step5、获取需要的Presenter,调用Presenter的初始化方法startWork（）（ 必选）。
```
 TestMvpPresent mPresenter = createPresenter();
 mPresenter.startWork();
```

### Activity使用示例：

```
@TargetPresenter(TestMvpPresent.class)
public class TestMvpActivity extends MvpActivity<TestMvpPresent> implements Contract.IView<TestBean>, View.OnClickListener {
    private TestMvpPresent mPresenter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_activity;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        //        创建说需要的Presenter
        mPresenter = createPresenter();
    }

    @OnClick({R.id.start_tv,R.id.skip_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.start_tv:
                mPresenter.startWork();//调用Presenter的初始化方法
                break;
        }
    }

    @Override
    public Context getViewContext() {
        return this;
    }

    @Override
    public void showContentView() {
     
    }

    //    数据请求失败回调
    @Override
    public void showError(String errorInfo, int errorCode) {
   
    }


//    数据请求成功回调
    @Override
    public void showContentData(TestBean data) {
        if (data != null) {
            showLog(data.toString());
            ToastUtil.showCenterToast(this,"TestMvpActivity : " + data.toString());
        }
    }
}
```

### Fragment使用示例：
```
@TargetPresenter(TestMvpPresent.class)
public class TestMvpFragment  extends MvpFragment<TestMvpPresent> implements Contract.IView<TestBean>, View.OnClickListener {
    private TestMvpPresent mPresenter;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_test_mvp;
    }

    @Override
    protected void init(Bundle savedInstanceState, View view) {
        //        创建说需要的Presenter
        mPresenter = createPresenter();
    }

    @OnClick({R.id.start_fm_tv})
    public void onClick(View view ){
        switch (view.getId()){
            case R.id.start_fm_tv:
                mPresenter.startWork();
                break;
        }
    }

    @Override
    public Context getViewContext() {
        return getContext();
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
            ToastUtil.showCenterToast(getContext(),"TestMvpFragment : " + data.toString());
        }
    }
}

```

# 三、补充说明：

>如果只是简单的Activity、Fragment,不想继承MvpActivity、MvpFragment，可以直接继承CommonActivity。

#### 普通的Activity使用示例：
```
public class TestCommonActivity extends CommonActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_common;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
    }
}
    
```

#### 普通的Fragment使用示例：
```
public class TestCommonFragment extends CommonFragment {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_common;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
    }
}
 ```

# 四、架构设计策略
[架构设计策略](https://github.com/Alin520/MvpFrame/blob/master/%E8%AE%BE%E8%AE%A1%E7%AD%96%E7%95%A5.md)

# 五、可能遇到的问题说明

###### 1、QA：common-library库的版本问题？ 
解决方式：请[点击查看CommonLibrary](https://github.com/Alin520/CommonLibrary),使用最新版本。</br>
```
dependencies {
   
   implementation 'com.alin:common-library:1.0.2'
}
    
```


如果你觉得[MvpFrame](https://github.com/Alin520/MvpFrame) 能帮到你真正解决项目中的问题，就在博客中个我点个赞，或者去我的[MvpFrame](https://github.com/Alin520/MvpFrame)中star。
如果项目中有问题，可以直接给我留言。 </br>  

# 联系方式</br>
      github地址：https://github.com/Alin520/MvpFrame。
      掘金地址：https://juejin.im/post/5a7941c96fb9a0633f0dfe64
      CSDN地址：http://blog.csdn.net/hailin123123
      联系方式:
      欢迎加入QQ群：707202045
  ![indicator样式风格](https://user-gold-cdn.xitu.io/2018/2/6/1616a124eff7cae3?w=412&h=562&f=png&s=56165)
