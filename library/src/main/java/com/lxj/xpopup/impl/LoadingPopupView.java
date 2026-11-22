package com.lxj.xpopup.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import android.widget.TextView;
import com.lxj.xpopup.R;
import com.lxj.xpopup.core.CenterPopupView;

/**
 * Description: 鍔犺浇瀵硅瘽妗? * Create by dance, at 2018/12/16
 */
public class LoadingPopupView extends CenterPopupView {
    private TextView tv_title;
    public LoadingPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return bindLayoutId != 0 ? bindLayoutId : R.layout._xpopup_center_impl_loading;
    }

    /**
     * 缁戝畾宸叉湁甯冨眬
     * @param layoutId 濡傛灉瑕佹樉绀烘爣棰橈紝鍒欒姹傚繀椤绘湁id涓簍v_title鐨凾extView锛屽惁鍒欐棤浠讳綍瑕佹眰
     * @return
     */
    public LoadingPopupView bindLayout(int layoutId){
        bindLayoutId = layoutId;
        return this;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        tv_title = findViewById(R.id.tv_title);
        setup();
    }

    protected void setup(){
        if(title!=null && tv_title!=null){
            tv_title.setVisibility(VISIBLE);
            tv_title.setText(title);
        }
    }

    private String title;
    public LoadingPopupView setTitle(String title){
        this.title = title;
        setup();
        return this;
    }
}

