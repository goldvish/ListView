package com.umr.nick.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Nick on 2016/3/1.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter
{
    private LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mList;
    protected final int mLayoutId;

    public interface Callback{
        public void click(View v);
    }

    public MyBaseAdapter(Context mContext, List<T> mList,
                         int mLayoutId) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mList = mList;
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = getViewHolder(position, convertView, parent);
        setViewbyId(viewHolder, (T) getItem(position));
        return viewHolder.getConvertView();
    }

    public abstract void setViewbyId(ViewHolder vh,T item);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(mContext, convertView, parent, mLayoutId, position);
    }

}
