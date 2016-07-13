package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.apapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.DataList;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.Check;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.ImageLoaderHelper;

/**
 * Created by 58 on 2016/7/12.
 */
public class PictureFlowRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public java.util.List<String> list;
    public Context mcontext;

    public PictureFlowRecyclerViewAdapter(List<String> list, Context context) {
        this.list = list;
        mcontext = context;
    }

    /**
     * 刷新列表
     */
    public void refresh(List<String> pictureList) {
        if (pictureList != null) {
            list = pictureList;
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.pictureflowfragment_item, parent, false);
        return new ItemViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            if (Check.indexOfList(list, position)) {
                String pictureUrl = list.get(position);
                ImageLoaderHelper.getInstance().loadImage(pictureUrl, itemViewHolder.recycler_item_picture);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list == null || list.isEmpty() ? 0 : list.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView recycler_item_picture;

        public ItemViewHolder(View itemView) {
            super(itemView);
            recycler_item_picture = (ImageView) itemView.findViewById(R.id.picturefragment_picture);
        }
    }
}
