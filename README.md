# GoldenScissorsViewInject
### 前言
#### 金剪刀注解,是一款本人自主开发的非常值得大家一用的页面注解工具,代码量少,轻量级.之所以起这个名字,主要是他用着超级方便,性能非常高,基本能满足大部分开发者的需求.jar包非常小,源码也非常少,功能却很强大.

### 使用方法

#####1,注解绑定布局(省去setContentView)

    
    在继承activity的类位置添加注解,例如
    
    @LayoutViewCut(R.layout.activity_main)
    public class MainActivity extends Activity {
        @ViewCut({R.id.tv_1, R.id.tv_2})
        private TextView tv1, tv2;
    可以代替findviewbyid找控件.在成员位置上.


