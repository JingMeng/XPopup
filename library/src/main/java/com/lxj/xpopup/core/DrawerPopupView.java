package com.lxj.xpopup.core;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.lxj.xpopup.R;
import com.lxj.xpopup.enums.PopupPosition;
import com.lxj.xpopup.widget.PopupDrawerLayout;

/**
 * Description: 甯rawer鐨勫脊绐? * Create by dance, at 2018/12/20
 */
public abstract class DrawerPopupView extends BasePopupView {
    PopupDrawerLayout drawerLayout;
    protected FrameLayout drawerContentContainer;

    public DrawerPopupView(@NonNull Context context) {
        super(context);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerContentContainer = findViewById(R.id.drawerContentContainer);
        View contentView = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), drawerContentContainer, false);
        drawerContentContainer.addView(contentView);
    }

    @Override
    protected int getPopupLayoutId() {
        return R.layout._xpopup_drawer_popup_view;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        drawerLayout.enableShadow = popupInfo.hasShadowBg;
        drawerLayout.isCanClose = popupInfo.isDismissOnTouchOutside;
        drawerLayout.setOnCloseListener(new PopupDrawerLayout.OnCloseListener() {
            @Override
            public void onClose() {
                DrawerPopupView.super.dismiss();
            }

            @Override
            public void onOpen() {
                DrawerPopupView.super.doAfterShow();
            }

            @Override
            public void onDismissing(float fraction) {
                drawerLayout.isDrawStatusBarShadow = popupInfo.hasStatusBarShadow;
            }
        });
        getPopupImplView().setTranslationX(popupInfo.offsetX);
        getPopupImplView().setTranslationY(popupInfo.offsetY);
        drawerLayout.setDrawerPosition(popupInfo.popupPosition == null ? PopupPosition.Left : popupInfo.popupPosition);
        drawerLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.close();
            }
        });
    }

    @Override
    protected void doAfterShow() {
        //do nothing self.
    }

    @Override
    public void doShowAnimation() {
        drawerLayout.open();
    }

    @Override
    public void doDismissAnimation() {
        drawerLayout.close();
    }

    /**
     * 鍔ㄧ敾鏄窡闅忔墜鍔垮彂鐢熺殑锛屾墍浠ヤ笉闇€瑕侀澶栫殑鍔ㄧ敾鍣紝鍥犳鍔ㄧ敾鏃堕棿涔熸竻闆?     *
     * @return
     */
    @Override
    public int getAnimationDuration() {
        return 0;
    }

    @Override
    public void dismiss() {
        // 鍏抽棴Drawer锛岀敱浜嶥rawer娉ㄥ唽浜嗗叧闂洃鍚紝浼氳嚜鍔ㄨ皟鐢╠ismiss
        drawerLayout.close();
    }

    @Override
    protected View getTargetSizeView() {
        return getPopupImplView();
    }
}

