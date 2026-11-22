package com.lxj.xpopup.interfaces;

import android.content.Context;
import androidx.annotation.NonNull;
import android.widget.ImageView;

import java.io.File;

public interface XPopupImageLoader{
    void loadImage(int position, @NonNull Object uri, @NonNull ImageView imageView);

    /**
     * 鑾峰彇鍥剧墖瀵瑰簲鐨勬枃浠?     * @param context
     * @param uri
     * @return
     */
    File getImageFile(@NonNull Context context, @NonNull Object uri);
}

