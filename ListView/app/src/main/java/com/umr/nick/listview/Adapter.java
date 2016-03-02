package com.umr.nick.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Nick on 2016/2/29.
 */
public abstract class Adapter<T> extends MyBaseAdapter {
/*    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mList;*/

    public Adapter(Context mContext, List mList, int mLayoutId) {
        super(mContext, mList, mLayoutId);
    }
/* private final class ViewHolder {
        TextView mTextView;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 /*       ViewHolder mViewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, parent, false);
            mViewHolder = new ViewHolder();
            mViewHolder.mTextView = (TextView) convertView
                    .findViewById(R.id.id_item);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.mTextView.setText(mList.get(position));
        return convertView;*/

        ViewHolder viewHolder=ViewHolder.get(mContext, convertView, parent,
                              R.layout.item, position);
        setViewbyId(viewHolder, (T)getItem(position));
        return viewHolder.getConvertView();
    }


}
