package com.lxj.xpopup.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import com.lxj.xpopup.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnCancelListener;
import com.lxj.xpopup.interfaces.OnInputConfirmListener;
import com.lxj.xpopup.util.XPopupUtils;

/**
 * Description: 甯﹁緭鍏ユ锛岀‘瀹氬拰鍙栨秷鐨勫璇濇
 * Create by dance, at 2018/12/16
 */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener{

    public InputConfirmPopupView(@NonNull Context context) {
        super(context);
    }

    /**
     * 缁戝畾宸叉湁甯冨眬
     * @param layoutId 鍦–onfirm寮圭獥鍩虹涓婇渶瑕佸鍔犱竴涓猧d涓篹t_input鐨凟ditText
     * @return
     */
    public InputConfirmPopupView bindLayout(int layoutId){
        bindLayoutId = layoutId;
        return this;
    }

    AppCompatEditText et_input;
    public String inputContent;
    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        et_input = findViewById(R.id.et_input);
        et_input.setVisibility(VISIBLE);
        if(!TextUtils.isEmpty(hint)){
            et_input.setHint(hint);
        }
        if(!TextUtils.isEmpty(inputContent)){
            et_input.setText(inputContent);
            et_input.setSelection(inputContent.length());
        }
        applyPrimary();
    }

    public AppCompatEditText getEditText() {
        return et_input;
    }

    protected void applyPrimary(){
        super.applyPrimaryColor();
        XPopupUtils.setCursorDrawableColor(et_input, XPopup.getPrimaryColor());
        et_input.post(new Runnable() {
            @Override
            public void run() {
                BitmapDrawable defaultDrawable = XPopupUtils.createBitmapDrawable(getResources(), et_input.getMeasuredWidth(), Color.parseColor("#888888"));
                BitmapDrawable focusDrawable = XPopupUtils.createBitmapDrawable(getResources(), et_input.getMeasuredWidth(), XPopup.getPrimaryColor());
                et_input.setBackgroundDrawable(XPopupUtils.createSelector(defaultDrawable, focusDrawable));
            }
        });

    }

    OnCancelListener cancelListener;
    OnInputConfirmListener inputConfirmListener;
    public void setListener( OnInputConfirmListener inputConfirmListener,OnCancelListener cancelListener){
        this.cancelListener = cancelListener;
        this.inputConfirmListener = inputConfirmListener;
    }

    @Override
    public void onClick(View v) {
        if(v==tv_cancel){
            if(cancelListener!=null)cancelListener.onCancel();
            dismiss();
        }else if(v==tv_confirm){
            if(inputConfirmListener!=null)inputConfirmListener.onConfirm(et_input.getText().toString().trim());
            if(popupInfo.autoDismiss)dismiss();
        }
    }
}

