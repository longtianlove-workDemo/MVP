package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;


/**
 * 封装第三方库，方便替换
 * Created by 龙 on 2016/7/8.
 */

public class ImageLoaderHelper {
    private static ImageLoaderHelper ourInstance = new ImageLoaderHelper();
    public static ImageLoaderHelper getInstance() {
        return ourInstance;
    }

    private ImageLoaderHelper() {
    }
  public  void init(Context context){
        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
    }
    public void loadImage(String url, final ImageView imageView) {
        ImageLoader.getInstance().loadImage(url, new ImageLoadingListener() {

            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view,
                                        FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setImageBitmap(loadedImage);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }
}
