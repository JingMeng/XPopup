package com.lxj.xpopupdemo.fragment;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.enums.PopupAnimation;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.lxj.xpopupdemo.R;
import java.util.ArrayList;

/**
 * Description:
 * Create by dance, at 2018/12/9
 */
public class CustomPopupDemo extends BaseFragment {
    Spinner spinner;
    TextView temp;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all_animator_demo;
    }

    PopupAnimation[] data;

    @Override
    public void init(View view) {
        spinner = view.findViewById(R.id.spinner);
        temp = view.findViewById(R.id.temp);
        temp.setText("婕旂ず濡備綍鑷畾涔夊脊绐楋紝骞剁粰鑷畾涔夌殑寮圭獥搴旂敤涓嶅悓鐨勫唴缃姩鐢绘柟妗堬紱浣犱篃鍙互涓鸿嚜宸辩殑寮圭獥缂栧啓鑷畾涔夌殑鍔ㄧ敾銆?);

        data = PopupAnimation.values();
        spinner.setAdapter(new ArrayAdapter<PopupAnimation>(getContext(), android.R.layout.simple_list_item_1, data));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
                spinner.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        CustomPopup customPopup = new CustomPopup(getContext());
                        new XPopup.Builder(getContext())
                                .popupAnimation(data[position])
                                .autoOpenSoftInput(true)
                                .asCustom(customPopup)
                                .show();
                    }
                }, 200); //纭繚spinner鐨勬秷澶卞姩鐢讳笉褰卞搷XPopup鍔ㄧ敾锛屽彲浠ョ湅寰楁洿娓呮櫚

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    public static class CustomPopup extends CenterPopupView {
        public CustomPopup(@NonNull Context context) {
            super(context);
        }

        @Override
        protected int getImplLayoutId() {
            return R.layout.custom_popup;
        }
        @Override
        protected void onCreate() {
            super.onCreate();
            findViewById(R.id.tv_close).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
        protected void onShow() {
            super.onShow();
        }

//        @Override
//        protected int getMaxHeight() {
//            return 200;
//        }
//
        //杩斿洖0琛ㄧず璁╁搴︽拺婊indow锛屾垨鑰呬綘鍙互杩斿洖涓€涓换鎰忓搴?//        @Override
//        protected int getMaxWidth() {
//            return 1200;
//        }
    }

    static class CustomPopup2 extends BottomPopupView {
        RecyclerView recyclerView;

        public CustomPopup2(@NonNull Context context) {
            super(context);
        }

        @Override
        protected int getImplLayoutId() {
            return R.layout.custom_popup2;
        }

        @Override
        protected void onCreate() {
            super.onCreate();
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            ArrayList<String> data = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                data.add("" + i);
            }

            recyclerView.setAdapter(new EasyAdapter<String>(data, android.R.layout.simple_list_item_1) {
                @Override
                protected void bind(@NonNull ViewHolder holder, @NonNull String s, int position) {
                    holder.setText(android.R.id.text1, s);
                }
            });
        }

//        @Override
//        protected int getMaxHeight() {
//            return 1200;
//        }
//
        //杩斿洖0琛ㄧず璁╁搴︽拺婊indow锛屾垨鑰呬綘鍙互杩斿洖涓€涓换鎰忓搴?//        @Override
//        protected int getMaxWidth() {
//            return 1200;
//        }
    }
}

