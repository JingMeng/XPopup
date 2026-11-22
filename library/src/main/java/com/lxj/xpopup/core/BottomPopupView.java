package com.lxj.xpopup.core;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lxj.xpopup.R;
import com.lxj.xpopup.animator.PopupAnimator;
import com.lxj.xpopup.enums.PopupStatus;
import com.lxj.xpopup.util.KeyboardUtils;
import com.lxj.xpopup.util.XPopupUtils;
import com.lxj.xpopup.widget.SmartDragLayout;

/**
 * Description: 鍦ㄥ簳閮ㄦ樉绀虹殑Popup
 * Create by lxj, at 2018/12/11
 */
public class BottomPopupView extends BasePopupView {
    protected SmartDragLayout bottomPopupContainer;
    public BottomPopupView(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getPopupLayoutId() {
        return R.layout._xpopup_bottom_popup_view;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        bottomPopupContainer = findViewById(R.id.bottomPopupContainer);
        View contentView = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), bottomPopupContainer, false);
        bottomPopupContainer.addView(contentView);
        bottomPopupContainer.enableDrag(popupInfo.enableDrag);
        bottomPopupContainer.dismissOnTouchOutside(popupInfo.isDismissOnTouchOutside);
        bottomPopupContainer.hasShadowBg(popupInfo.hasShadowBg);

        getPopupImplView().setTranslationX(popupInfo.offsetX);
        getPopupImplView().setTranslationY(popupInfo.offsetY);

        XPopupUtils.applyPopupSize((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight());

        bottomPopupContainer.setOnCloseListener(new SmartDragLayout.OnCloseListener() {
            @Override
            public void onClose() {
                doAfterDismiss();
            }
            @Override
            public void onOpen() {
                BottomPopupView.super.doAfterShow();
            }
        });

        bottomPopupContainer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


    @Override
    protected void doAfterShow() {
        if(popupInfo.enableDrag){
            //do nothing self.
        }else {
            super.doAfterShow();
        }
    }

    @Override
    public void doShowAnimation() {
        if (popupInfo.enableDrag) {
            bottomPopupContainer.open();
        } else {
            super.doShowAnimation();
        }
    }

    @Override
    public void doDismissAnimation() {
        if (popupInfo.enableDrag) {
            bottomPopupContainer.close();
        } else {
            super.doDismissAnimation();
        }
    }

    /**
     * 鍔ㄧ敾鏄窡闅忔墜鍔垮彂鐢熺殑锛屾墍浠ヤ笉闇€瑕侀澶栫殑鍔ㄧ敾鍣紝鍥犳鍔ㄧ敾鏃堕棿涔熸竻闆?     *
     * @return
     */
    @Override
    public int getAnimationDuration() {
        return popupInfo.enableDrag ? 0 : super.getAnimationDuration();
    }

    @Override
    protected PopupAnimator getPopupAnimator() {
        // 绉婚櫎榛樿鐨勫姩鐢诲櫒
        return popupInfo.enableDrag ? null : super.getPopupAnimator();
    }

    @Override
    public void dismiss() {
        if (popupInfo.enableDrag) {
            if (popupStatus == PopupStatus.Dismissing) return;
            popupStatus = PopupStatus.Dismissing;
            if (popupInfo.autoOpenSoftInput) KeyboardUtils.hideSoftInput(this);
            clearFocus();
            // 鍏抽棴Drawer锛岀敱浜嶥rawer娉ㄥ唽浜嗗叧闂洃鍚紝浼氳嚜鍔ㄨ皟鐢╠ismiss
            bottomPopupContainer.close();
        } else {
            super.dismiss();
        }
    }

    /**
     * 鍏蜂綋瀹炵幇鐨勭被鐨勫竷灞€
     *
     * @return
     */
    protected int getImplLayoutId() {
        return 0;
    }

    protected int getMaxWidth() {
        return popupInfo.maxWidth == 0 ? XPopupUtils.getWindowWidth(getContext())
                : popupInfo.maxWidth;
    }

    @Override
    protected View getTargetSizeView() {
        return getPopupImplView();
    }

}

