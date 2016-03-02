package com.umr.nick.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nick on 2016/3/1.
 */
public class ViewHolder
{
    private final SparseArray<View> mViews;
    private View mConvertView;
    private int mPosition;

    public ViewHolder(Context context,ViewGroup parent, int layout_id, int position)
    {
        this.mPosition=position;
        this.mViews = new SparseArray<View>();
        mConvertView= LayoutInflater.from(context).inflate(layout_id,parent,false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context,View convertView,ViewGroup parent,
                                 int layout_id,int position)
    {
         if(convertView == null)
             return new ViewHolder(context,parent,layout_id,position);
        return (ViewHolder) convertView.getTag();
    }

    public <T extends View> T getView(int viewId)
    {
        View view=mViews.get(viewId);
        if(view == null)
        {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public int getmPosition() {
        return mPosition;
    }

    public View getConvertView()
    {
        return mConvertView;
    }

    public ViewHolder setText(int viewId, String text)
    {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setIamgeResource(int viewId, int drawableId)
    {
        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bm)
    {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bm);
        return this;
    }


    public ViewHolder setImageDrawable(int viewId, Drawable drawable)
    {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public ViewHolder setVisible(int viewId, boolean visible)
    {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public ViewHolder setTag(int viewId, Object tag)
    {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public ViewHolder setChecked(int viewId, boolean checked)
    {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }


    public ViewHolder setOnClickListener(int viewId,
                                         View.OnClickListener listener)
    {
        View view=getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public ViewHolder setOnLongClickListener(int viewId,
                                         View.OnLongClickListener listener)
    {
        View view=getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }



}
