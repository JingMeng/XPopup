package com.lxj.xpopupdemo.fragment;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.interfaces.OnSrcViewUpdateListener;
import com.lxj.xpopup.interfaces.XPopupImageLoader;
import com.lxj.xpopupdemo.R;
import com.lxj.xpopupdemo.custom.CustomImageViewerPopup;

import java.io.File;
import java.util.ArrayList;

/**
 * Description:
 * Create by lxj, at 2019/1/22
 */
public class ImageViewerDemo extends BaseFragment {

    String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548777981087&di=0618a101655e57c675c7c21b4ef55f00&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1504%2F06%2Fc70%2F5014635_1428321310010_mthumb.jpg";
    String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549382334&di=332b0aa1ec4ccd293f176164d998e5ab&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D121ef3421a38534398c28f62fb7ada0b%2Ffaf2b2119313b07eedb4502606d7912397dd8c96.jpg";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_preview;
    }

    public static ArrayList<Object> list = new ArrayList<>();

    static {
        list.clear();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548756837006&di=551df0dcf59d1d71673c3d46b33f0d93&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201308%2F04%2F20130804155912_wCRnE.thumb.700_0.jpeg");
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2279952540,2544282724&fm=26&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=851052518,4050485518&fm=26&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=174904559,2874238085&fm=26&gp=0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548764579122&di=e3a46d9075ee49ecefb552a447974ddc&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201112%2F03%2F20111203233836_3wu5E.thumb.700_0.jpg");
        list.add("https://user-gold-cdn.xitu.io/2019/1/25/168839e977414cc1?imageView2/2/w/800/q/100");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551692956639&di=8ee41e070c6a42addfc07522fda3b6c8&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160413%2F75659e9b05b04eb8adf5b52669394897.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548756837006&di=551df0dcf59d1d71673c3d46b33f0d93&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201308%2F04%2F20130804155912_wCRnE.thumb.700_0.jpeg");
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2279952540,2544282724&fm=26&gp=0.jpg");
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=851052518,4050485518&fm=26&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=174904559,2874238085&fm=26&gp=0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548764579122&di=e3a46d9075ee49ecefb552a447974ddc&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201112%2F03%2F20111203233836_3wu5E.thumb.700_0.jpg");
        list.add("https://user-gold-cdn.xitu.io/2019/1/25/168839e977414cc1?imageView2/2/w/800/q/100");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551692956639&di=8ee41e070c6a42addfc07522fda3b6c8&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160413%2F75659e9b05b04eb8adf5b52669394897.jpg");
    }

    RecyclerView recyclerView;
    ImageView image1, image2;
    ViewPager pager;
    Button btn_custom;
    @Override
    public void init(final View view) {
        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        pager = view.findViewById(R.id.pager);
        btn_custom = view.findViewById(R.id.btn_custom);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        recyclerView.setAdapter(new ImageAdapter());


        Glide.with(this).load(url1).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round).override(Target.SIZE_ORIGINAL).transform(new RoundedCorners(50))).into(image1);
        Glide.with(this).load(url2).into(image2);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(getContext())
                        .asImageViewer(image1, url1, true, -1, -1, 50, false,new ImageLoader())
                        .show();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new XPopup.Builder(getContext())
                        .asImageViewer(image2, url2, new ImageLoader())
                        .show();
            }
        });

        //ViewPager bind data
        pager.setOffscreenPageLimit(list.size());
        pager.setAdapter(new ImagePagerAdapter());

        btn_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //鑷畾涔夌殑寮圭獥闇€瑕佺敤asCustom鏉ユ樉绀猴紝涔嬪墠鐨刟sImageViewer杩欎簺鏂规硶褰撶劧涓嶈兘鐢ㄤ簡銆?                CustomImageViewerPopup viewerPopup = new CustomImageViewerPopup(getContext());
                //鑷畾涔夌殑ImageViewer寮圭獥闇€瑕佽嚜宸辨墜鍔ㄨ缃浉搴旂殑灞炴€э紝蹇呴』璁剧疆鐨勬湁srcView锛寀rl鍜宨mageLoader銆?                viewerPopup.setSingleSrcView(image2, url2);
//                viewerPopup.isInfinite(true);
                viewerPopup.setXPopupImageLoader(new ImageLoader());
//                viewerPopup.isShowIndicator(false);//鏄惁鏄剧ず椤电爜鎸囩ず鍣?//                viewerPopup.isShowPlaceholder(false);//鏄惁鏄剧ず鐧借壊鍗犱綅鍧?//                viewerPopup.isShowSaveButton(false);//鏄惁鏄剧ず淇濆瓨鎸夐挳
                new XPopup.Builder(getContext())
                        .asCustom(viewerPopup)
                        .show();
            }
        });
    }

    public static class ImageAdapter extends EasyAdapter<Object> {
        public ImageAdapter() {
            super(list, R.layout.adapter_image);
        }

        @Override
        protected void bind(@NonNull final ViewHolder holder, @NonNull final Object s, final int position) {
            final ImageView imageView = holder.<ImageView>getView(R.id.image);
            //1. 鍔犺浇鍥剧墖, 鐢变簬ImageView鏄痗enterCrop锛屽繀椤绘寚瀹歍arget.SIZE_ORIGINAL锛岀姝lide瑁佸壀鍥剧墖锛?            // 杩欐牱鎴戝氨鑳芥嬁鍒板師濮嬪浘鐗囩殑Matrix锛屾墠鑳芥湁瀹岀編鐨勮繃娓℃晥鏋?            Glide.with(imageView).load(s).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round)
                    .override(Target.SIZE_ORIGINAL))
                    .into(imageView);

            //2. 璁剧疆鐐瑰嚮
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new XPopup.Builder(holder.itemView.getContext()).asImageViewer(imageView, position, list, new OnSrcViewUpdateListener() {
                        @Override
                        public void onSrcViewUpdate(ImageViewerPopupView popupView, int position) {
                            RecyclerView rv = (RecyclerView) holder.itemView.getParent();
                            popupView.updateSrcView((ImageView)rv.getChildAt(position));
                        }
                    }, new ImageLoader())
                            .show();
                }
            });
        }
    }

    class ImagePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            final ImageView imageView = new ImageView(container.getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(imageView);

            //1. 鍔犺浇鍥剧墖
            Glide.with(imageView).load(list.get(position)).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round).override(Target.SIZE_ORIGINAL))
                    .into(imageView);
            //2. 璁剧疆鐐瑰嚮
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new XPopup.Builder(getContext())
                            .asImageViewer(imageView, position, list, true,false, -1, -1, -1, true, new OnSrcViewUpdateListener() {
                        @Override
                        public void onSrcViewUpdate(final ImageViewerPopupView popupView, final int position) {
                            //1.pager鏇存柊褰撳墠鏄剧ず鐨勫浘鐗?                            //褰撳惎鐢╥sInfinite鏃讹紝position浼氭棤闄愬澶э紝闇€瑕佹槧灏勪负褰撳墠ViewPager涓殑椤?                            int realPosi = position%list.size();
//                            Log.e("tag", "position: "+realPosi + " list size: "+list.size());
                            pager.setCurrentItem(realPosi, false);
                            //2.鏇存柊寮圭獥鐨剆rcView锛屾敞鎰忚繖閲岀殑position鏄痩ist涓殑position锛屼笂闈iewPager璁剧疆浜唒ageLimit鏁伴噺锛?                            //淇濊瘉鑳芥嬁鍒癱hild锛屽鏋滀笉璁剧疆pageLimit锛孷iewPager榛樿鏈€澶氱淮鎶?涓猵age锛屼細瀵艰嚧鎷夸笉鍒癱hild
                            popupView.updateSrcView((ImageView) pager.getChildAt(realPosi));
                        }
                    }, new ImageLoader())
                            .show();
                }
            });

            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

    public static class ImageLoader implements XPopupImageLoader {
        @Override
        public void loadImage(int position, @NonNull Object url, @NonNull ImageView imageView) {
            //蹇呴』鎸囧畾Target.SIZE_ORIGINAL锛屽惁鍒欐棤娉曟嬁鍒板師鍥撅紝灏辨棤娉曚韩鐢ㄥぉ琛ｆ棤缂濈殑鍔ㄧ敾
            Glide.with(imageView).load(url).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher_round).override(Target.SIZE_ORIGINAL)).into(imageView);
        }

        @Override
        public File getImageFile(@NonNull Context context, @NonNull Object uri) {
            try {
                return Glide.with(context).downloadOnly().load(uri).submit().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}


