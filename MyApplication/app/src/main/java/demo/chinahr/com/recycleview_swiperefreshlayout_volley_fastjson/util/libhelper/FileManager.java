package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.RootApplication;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureDataSource;

/**
 * Created by 龙 on 2016/7/13.
 */
public class FileManager {
    private static FileManager ourInstance = new FileManager();

    public static FileManager getInstance() {
        return ourInstance;
    }

    private FileManager() {
    }

    public Reader getFromAssets(String fileName) {
        try {
            return new InputStreamReader(RootApplication.getContext().getResources().getAssets().open(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getPictureUrls(PictureDataSource.ResponseCallback callback) {
        ArrayList<String> picturesList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(getFromAssets("pictureUrls.txt"));
        String url = "";
        try {
            while ((url = bufferedReader.readLine()) != null) {
                picturesList.add(url);
            }
            callback.onResponseOK(picturesList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
