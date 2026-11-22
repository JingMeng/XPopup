package com.lxj.xpopupdemo.custom;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.lxj.xpopup.util.XPopupUtils;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import com.lxj.xpopupdemo.DemoActivity;
import com.lxj.xpopupdemo.R;

import java.util.ArrayList;

/**
 * Description: 浠跨煡涔庡簳閮ㄨ瘎璁哄脊绐? * Create by dance, at 2018/12/25
 */
public class ZhihuCommentPopup extends BottomPopupView {
    VerticalRecyclerView recyclerView;
    private ArrayList<String> data;
    private EasyAdapter<String> commonAdapter;

    public ZhihuCommentPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_bottom_popup;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        recyclerView = findViewById(R.id.recyclerView);
        findViewById(R.id.tv_temp).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //寮瑰嚭鏂扮殑寮圭獥鐢ㄦ潵杈撳叆
                final CustomEditTextBottomPopup textBottomPopup = new CustomEditTextBottomPopup(getContext());
                new XPopup.Builder(getContext())
                        .autoOpenSoftInput(true)
//                        .hasShadowBg(false)
                        .setPopupCallback(new SimpleCallback() {
                            @Override
                            public void onShow() {
                            }

                            @Override
                            public void onDismiss() {
                                String comment = textBottomPopup.getComment();
                                if (!comment.isEmpty()) {
                                    data.add(0, comment);
                                    commonAdapter.notifyDataSetChanged();
                                }
                            }
                        })
                        .asCustom(textBottomPopup)
                        .show();
            }
        });

        data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("杩欐槸涓€涓嚜瀹氫箟Bottom绫诲瀷鐨勫脊绐楋紒浣犲彲浠ュ湪閲岄潰娣诲姞浠讳綍婊氬姩鐨刅iew锛屾垜宸茬粡鏅鸿兘澶勭悊濂藉祵濂楁粴鍔紝浣犲彧闇€缂栧啓UI鍜岄€昏緫鍗冲彲锛?);
        }
        commonAdapter = new EasyAdapter<String>(data, R.layout.adapter_zhihu_comment) {
            @Override
            protected void bind(@NonNull ViewHolder holder, @NonNull String s, final int position) {
                holder.setText(R.id.name, "鐭ヤ箮澶х - " + position)
                        .setText(R.id.comment, s);
                holder.getView(R.id.btnDel).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.remove(position);
                        commonAdapter.notifyItemRemoved(position);
                        commonAdapter.notifyItemRangeChanged(position, data.size());
                    }
                });
            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.SimpleOnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                //涓嶈鐩存帴杩欐牱鍋氾紝浼氬鑷存秷澶卞姩鐢绘湭鎵ц瀹屽氨璺宠浆鐣岄潰锛屼笉娴佺晠銆?//                dismiss();
//                getContext().startActivity(new Intent(getContext(), DemoActivity.class))
                //鍙互绛夋秷澶卞姩鐢绘墽琛屽畬姣曞啀寮€鍚柊鐣岄潰
                dismissWith(new Runnable() {
                    @Override
                    public void run() {
                        getContext().startActivity(new Intent(getContext(), DemoActivity.class));
                    }
                });

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(commonAdapter);
    }

    //瀹屽叏鍙鎵ц
    @Override
    protected void onShow() {
        super.onShow();
    }

    //瀹屽叏娑堝け鎵ц
    @Override
    protected void onDismiss() {

    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .85f);
    }
}
