package com.lxj.xpopupdemo.custom;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopupdemo.DemoActivity;
import com.lxj.xpopupdemo.R;

import java.util.Random;

/**
 * Description: 鑷畾涔夋娊灞夊脊绐? * Create by dance, at 2018/12/20
 */
public class CustomDrawerPopupView extends DrawerPopupView {
    TextView text;
    public CustomDrawerPopupView(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_drawer_popup;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        Log.e("tag", "CustomDrawerPopupView onCreate");
        text = findViewById(R.id.text);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        text.setText(new Random().nextInt()+"");

        //閫氳繃璁剧疆topMargin锛屽彲浠ヨDrawer寮圭獥杩涜灞€閮ㄩ槾褰卞睍绀?//        ViewGroup.MarginLayoutParams params = (MarginLayoutParams) getPopupContentView().getLayoutParams();
//        params.topMargin = 450;
    }

    @Override
    protected void onShow() {
        super.onShow();
        Log.e("tag", "CustomDrawerPopupView onShow");
    }

    @Override
    protected void onDismiss() {
        super.onDismiss();
        Log.e("tag", "CustomDrawerPopupView onDismiss");
    }
}
