package com.lxj.xpopup.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.R;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lxj.xpopup.widget.VerticalRecyclerView;

import java.util.Arrays;

/**
 * Description: Attach绫诲瀷鐨勫垪琛ㄥ脊绐? * Create by dance, at 2018/12/12
 */
public class AttachListPopupView extends AttachPopupView {
    VerticalRecyclerView recyclerView;
    protected int bindLayoutId;
    protected int bindItemLayoutId;

    public AttachListPopupView(@NonNull Context context) {
        super(context);
    }

    /**
     * 浼犲叆鑷畾涔夌殑甯冨眬锛屽甯冨眬涓殑id鏈夎姹?     *
     * @param layoutId 瑕佹眰layoutId涓繀椤绘湁涓€涓猧d涓簉ecyclerView鐨凴ecyclerView锛屽鏋滀綘闇€瑕佹樉绀烘爣棰橈紝鍒欏繀椤绘湁涓€涓猧d涓簍v_title鐨凾extView
     * @return
     */
    public AttachListPopupView bindLayout(int layoutId) {
        this.bindLayoutId = layoutId;
        return this;
    }

    /**
     * 浼犲叆鑷畾涔夌殑 item甯冨眬
     *
     * @param itemLayoutId 鏉＄洰鐨勫竷灞€id锛岃姹傚竷灞€涓繀椤绘湁id涓篿v_image鐨処mageView锛屽拰id涓簍v_text鐨凾extView
     * @return
     */
    public AttachListPopupView bindItemLayout(int itemLayoutId) {
        this.bindItemLayoutId = itemLayoutId;
        return this;
    }

    @Override
    protected int getImplLayoutId() {
        return bindLayoutId == 0 ? R.layout._xpopup_attach_impl_list : bindLayoutId;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setupDivider();
        final EasyAdapter<String> adapter = new EasyAdapter<String>(Arrays.asList(data), bindItemLayoutId == 0 ? R.layout._xpopup_adapter_text : bindItemLayoutId) {
            @Override
            protected void bind(@NonNull ViewHolder holder, @NonNull String s, int position) {
                holder.setText(R.id.tv_text, s);
                if (iconIds != null && iconIds.length > position) {
                    holder.getView(R.id.iv_image).setVisibility(VISIBLE);
                    holder.getView(R.id.iv_image).setBackgroundResource(iconIds[position]);
                } else {
                    holder.getView(R.id.iv_image).setVisibility(GONE);
                }
                holder.getView(R.id.xpopup_divider).setVisibility(GONE);
            }
        };
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.SimpleOnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (selectListener != null) {
                    selectListener.onSelect(position, adapter.getData().get(position));
                }
                if (popupInfo.autoDismiss) dismiss();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    String[] data;
    int[] iconIds;

    public AttachListPopupView setStringData(String[] data, int[] iconIds) {
        this.data = data;
        this.iconIds = iconIds;
        return this;
    }

    public AttachListPopupView setOffsetXAndY(int offsetX, int offsetY) {
        this.defaultOffsetX += offsetX;
        this.defaultOffsetY += offsetY;
        return this;
    }

    private OnSelectListener selectListener;

    public AttachListPopupView setOnSelectListener(OnSelectListener selectListener) {
        this.selectListener = selectListener;
        return this;
    }
}

