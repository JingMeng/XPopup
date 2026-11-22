package com.lxj.xpopup.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.lxj.xpopup.widget.CheckView;

import java.util.Arrays;

/**
 * Description: 搴曢儴鐨勫垪琛ㄥ璇濇
 * Create by dance, at 2018/12/16
 */
public class BottomListPopupView extends BottomPopupView {
    RecyclerView recyclerView;
    TextView tv_title;
    protected int bindLayoutId;
    protected int bindItemLayoutId;

    public BottomListPopupView(@NonNull Context context) {
        super(context);
    }

    /**
     * 浼犲叆鑷畾涔夌殑甯冨眬锛屽甯冨眬涓殑id鏈夎姹?     *
     * @param layoutId 瑕佹眰layoutId涓繀椤绘湁涓€涓猧d涓簉ecyclerView鐨凴ecyclerView锛屽鏋滀綘闇€瑕佹樉绀烘爣棰橈紝鍒欏繀椤绘湁涓€涓猧d涓簍v_title鐨凾extView
     * @return
     */
    public BottomListPopupView bindLayout(int layoutId) {
        this.bindLayoutId = layoutId;
        return this;
    }

    /**
     * 浼犲叆鑷畾涔夌殑 item甯冨眬
     *
     * @param itemLayoutId 鏉＄洰鐨勫竷灞€id锛岃姹傚竷灞€涓繀椤绘湁id涓篿v_image鐨処mageView锛屽拰id涓簍v_text鐨凾extView
     * @return
     */
    public BottomListPopupView bindItemLayout(int itemLayoutId) {
        this.bindItemLayoutId = itemLayoutId;
        return this;
    }

    @Override
    protected int getImplLayoutId() {
        return bindLayoutId == 0 ? R.layout._xpopup_center_impl_list : bindLayoutId;
    }

    @Override
    protected void initPopupContent() {
        super.initPopupContent();
        recyclerView = findViewById(R.id.recyclerView);
        tv_title = findViewById(R.id.tv_title);

        if(tv_title!=null){
            if (TextUtils.isEmpty(title)) {
                tv_title.setVisibility(GONE);
                findViewById(R.id.xpopup_divider).setVisibility(GONE);
            } else {
                tv_title.setText(title);
            }
        }

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

                // 瀵瑰嬀View
                if (checkedPosition != -1) {
                    if(holder.getView(R.id.check_view)!=null){
                        holder.getView(R.id.check_view).setVisibility(position == checkedPosition ? VISIBLE : GONE);
                        holder.<CheckView>getView(R.id.check_view).setColor(XPopup.getPrimaryColor());
                    }
                    holder.<TextView>getView(R.id.tv_text).setTextColor(position == checkedPosition ?
                            XPopup.getPrimaryColor() : getResources().getColor(R.color._xpopup_title_color));
                }
                if(position==(data.length-1)){
                    holder.getView(R.id.xpopup_divider).setVisibility(GONE);
                }
            }
        };
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.SimpleOnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                if (selectListener != null) {
                    selectListener.onSelect(position, adapter.getData().get(position));
                }
                if (checkedPosition != -1) {
                    checkedPosition = position;
                    adapter.notifyDataSetChanged();
                }
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (popupInfo.autoDismiss) dismiss();
                    }
                }, 100);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    String title;
    String[] data;
    int[] iconIds;

    public BottomListPopupView setStringData(String title, String[] data, int[] iconIds) {
        this.title = title;
        this.data = data;
        this.iconIds = iconIds;
        return this;
    }

    private OnSelectListener selectListener;

    public BottomListPopupView setOnSelectListener(OnSelectListener selectListener) {
        this.selectListener = selectListener;
        return this;
    }

    int checkedPosition = -1;

    /**
     * 璁剧疆榛樿閫変腑鐨勪綅缃?     *
     * @param position
     * @return
     */
    public BottomListPopupView setCheckedPosition(int position) {
        this.checkedPosition = position;
        return this;
    }


}

