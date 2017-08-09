package com.jiang.zheng.yan.goldscissorsviewinject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jiang.zheng.yan.goldscissors.GoldScissors;
import com.jiang.zheng.yan.goldscissors.LayoutViewCut;
import com.jiang.zheng.yan.goldscissors.OnClickCut;
import com.jiang.zheng.yan.goldscissors.ViewCut;

/**
 *
 *    测试界面
 * @author jiang_yan
 * @Email
 */
@LayoutViewCut(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewCut({R.id.tv_1, R.id.tv_2})
    private TextView tv1, tv2;

    @ViewCut(R.id.tv_3)
    private TextView tv3;

    @ViewCut({R.id.tv_4})
    private TextView tv4;

    @ViewCut({R.id.tv_5, R.id.tv_6, R.id.tv_7, R.id.tv_8,})
    private TextView tv5, tv6, tv7, tv8;


    private TextView tv84;//干扰项


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        GoldScissors.cut(this);

        if (tv1 != null) {
            tv1.setText("金剪刀注入成功,tv1");
        } else {
            tv1.setText("金剪刀注入失败");
        }
        if (tv2 != null) {

            tv2.setText("金剪刀注入成功,tv2");

        } else {
            tv2.setText("金剪刀注入失败");
        }
        if (tv3 != null) {

            tv3.setText("金剪刀注入成功,tv3");

        } else {
            tv3.setText("金剪刀注入失败");
        }
        if (tv4 != null) {

            tv4.setText("金剪刀注入成功,tv4");

        } else {
            tv4.setText("金剪刀注入失败");
        }
        if (tv5 != null) {

            tv5.setText("金剪刀注入成功,tv4");

        } else {
            tv5.setText("金剪刀注入失败");
        }
        if (tv6 != null) {

            tv6.setText("金剪刀注入成功,tv4");

        } else {
            tv6.setText("金剪刀注入失败");
        }
        if (tv7 != null) {

            tv7.setText("金剪刀注入成功,tv4");

        } else {
            tv7.setText("金剪刀注入失败");
        }
        if (tv8 != null) {

            tv8.setText("金剪刀注入成功,tv4");

        } else {
            tv8.setText("金剪刀注入失败");
        }

    }

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

}
