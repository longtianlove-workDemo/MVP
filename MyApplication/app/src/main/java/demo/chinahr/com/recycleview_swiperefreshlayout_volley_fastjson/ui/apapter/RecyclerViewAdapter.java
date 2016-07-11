package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.apapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.DataList;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.ImageLoaderHelper;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemClickListener;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemLongClickListener;

/**
 * Created by 龙 on 2016/7/7.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = -1;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;
    public java.util.List<DataList> list;
    public Context mcontext;

    NativeItemClickListener adpaterItemClickListener;
    NativeItemLongClickListener adapterItemLongClickListener;

    public RecyclerViewAdapter(List<DataList> list, Context context) {
        this.list = list;
        this.mcontext = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                View viewHeader = LayoutInflater.from(mcontext).inflate(R.layout.item_header, parent,
                        false);
                return new HeadViewHolder(viewHeader);
            case TYPE_FOOTER:
                View viewFooter = LayoutInflater.from(mcontext).inflate(R.layout.item_foot, parent,
                        false);
                return new FootViewHolder(viewFooter);
            case TYPE_ITEM:
                View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
                return new ItemViewHolder(viewItem, adpaterItemClickListener, adapterItemLongClickListener);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            final DataList dl = list.get(position - 1);
            if (dl != null) {
                ImageLoaderHelper.getInstance().loadImage(dl.getIcon(), itemViewHolder.recycler_item_icon);
                itemViewHolder.recycler_item_name.setText(dl.getName());
                itemViewHolder.recycler_item_ratestar.setText(dl.getRatestar());
                itemViewHolder.recycler_item_download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mcontext, "正在下载" + list.get(position).getName() + "……", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }

    public void setOnItemClickListener(NativeItemClickListener listener) {
        this.adpaterItemClickListener = listener;
    }

    public void setOnItemLongClickListener(NativeItemLongClickListener listener) {
        this.adapterItemLongClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 1 : list.size() + 2;
    }

    static class HeadViewHolder extends RecyclerView.ViewHolder {
        public HeadViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("longtianlove", "点击头部");
                }
            });
        }
    }

    /**
     * 刷新列表
     *
     * @param root
     */
    public void refresh(Root root) {
        if (root != null && root.getData() != null) {
            list = root.getData().getList();
            notifyDataSetChanged();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public ImageView recycler_item_icon;
        public TextView recycler_item_name;
        public TextView recycler_item_ratestar;
        public Button recycler_item_download;


        private NativeItemClickListener itemVHItemClickListener;
        private NativeItemLongClickListener itemVHItemLongClickListener;

        public ItemViewHolder(View view, NativeItemClickListener nativeItemClickListener, NativeItemLongClickListener nativeItemLongClickListener) {
            super(view);
            recycler_item_icon = (ImageView) view.findViewById(R.id.icon);
            recycler_item_name = (TextView) view.findViewById(R.id.name);
            recycler_item_ratestar = (TextView) view.findViewById(R.id.ratestar);
            recycler_item_download = (Button) view.findViewById(R.id.download);
            itemVHItemClickListener = nativeItemClickListener;
            itemVHItemLongClickListener = nativeItemLongClickListener;
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (itemVHItemClickListener != null) {
                itemVHItemClickListener.onItemClick(v, getPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (itemVHItemLongClickListener != null) {
                itemVHItemLongClickListener.onItemLongClick(v, getPosition());
            }
            return true;
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {
        public FootViewHolder(View view) {
            super(view);
        }
    }
}
