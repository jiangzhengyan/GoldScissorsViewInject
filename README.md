# GoldenScissorsViewInject
### 前言
#### 金剪刀注解工具,是本人写的一个轻量级的android开发页面注解工具,代码量少,非常轻量级.之所以起这个名字,主要是他jar包非常小,源码也非常少,使用方便,性能高,基本能满足大部分开发者的需求.
### detail more to read my blog : http://blog.csdn.net/qq_33275672/article/details/77018935

## 三个最主要的注解类型 


@LayoutViewCut 绑定activity布局

@ViewCut 绑定控件资源 省去繁琐的findViewById

@OnClickCut 控件点击事件

 

### 使用方法


**(1) 把libs下面的GoldenScissors.jar导进自己的项目中或者把library下的源码放到自己的项目中**

**(2) 在onCreate方法中绑定此工具**

     GoldenScissors.cut(this); 

**(3) 根据需要,按照以下的方式去使用**


### 1,@LayoutViewCut 注解绑定布局,(省去setContentView)

在继承activity的类位置添加注解(如 @LayoutViewCut(R.layout.activity_main)),例如
    
    @LayoutViewCut(R.layout.activity_main)
    public class MainActivity extends Activity {
        @ViewCut({R.id.tv_1, R.id.tv_2})
        private TextView tv1, tv2;
        
        
###   2,@ViewCut,可以代替findviewbyid找控件,在成员变量上面添加

          1,@ViewCut(R.id.tv_1).//单个控件
          
          2,@ViewCut({R.id.tv_1})  //单个控件
          
          3,@ViewCut({R.id.tv_1, R.id.tv_2}) //多个控件
        
         如下
         
        @ViewCut({R.id.tv_1, R.id.tv_2})
        private TextView tv1, tv2;

        @ViewCut(R.id.tv_3)
        private TextView tv3;
    
        @ViewCut({R.id.tv_4})
        private TextView tv4;
    
        @ViewCut({R.id.tv_5, R.id.tv_6, R.id.tv_7, R.id.tv_8,})
        private TextView tv5, tv6, tv7, tv8;
    
    
    
### 3, @OnClickCut 点击事件 


注:方法的的命名参数名必须为View,方法名只要符合基本命名规则就行

     @OnClickCut({R.id.tv_1, R.id.tv_2, R.id.tv_3, R.id.tv_4, R.id.btn})
    private void click(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                Toast.makeText(this, "点击了" + "tv1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_2:
                Toast.makeText(this, "点击了" + "tv2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_3:
                Toast.makeText(this, "点击了" + "tv3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_4:
                Toast.makeText(this, "点击了" + "tv4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn:
                Toast.makeText(this, "点击了" + "按钮 5", Toast.LENGTH_SHORT).show();
                break;

        }


    }
