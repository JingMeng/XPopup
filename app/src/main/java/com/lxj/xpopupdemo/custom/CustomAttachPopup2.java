package com.lxj.xpopupdemo.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.HorizontalAttachPopupView;
import com.lxj.xpopupdemo.R;

/**
 * Description:
 * Create by lxj, at 2019/3/13
 */
public class CustomAttachPopup2 extends AttachPopupView {
    public CustomAttachPopup2(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_attach_popup2;
    }

    @Override
    protected void onCreate() {
        super.onCreate();

    }

    //濡傛灉瑕佽嚜瀹氫箟寮圭獥鐨勮儗鏅紝涓嶈缁欏竷灞€璁剧疆鑳屾櫙鍥剧墖锛岄噸鍐欒繖涓柟娉曡繑鍥炰竴涓狣rawable鍗冲彲
    @Override
    protected Drawable getPopupBackground() {
        return getResources().getDrawable(R.drawable.shadow_bg);
    }
}

