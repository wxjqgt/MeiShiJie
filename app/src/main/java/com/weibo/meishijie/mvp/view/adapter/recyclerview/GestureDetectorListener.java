package com.weibo.meishijie.mvp.view.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/7/15.
 */
public class GestureDetectorListener extends GestureDetector.SimpleOnGestureListener{

    private OnRecyclerViewItemClickListener listener;
    private RecyclerView recyclerView;

    public GestureDetectorListener(OnRecyclerViewItemClickListener listener){
        this.listener = listener;
        this.recyclerView = listener.getRecyclerView();
    }

    @Override
    public void onLongPress(MotionEvent e) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(e);
        listener.OnItemLongClickLitener(viewHolder);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        RecyclerView.ViewHolder viewHolder = getViewHolder(e);
        listener.OnItemClickLitener(viewHolder);
        return true;
    }

    private RecyclerView.ViewHolder getViewHolder(MotionEvent e){
        View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
        if (child != null){
            RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(child);
            return viewHolder;
        }
        return null;
    }

}
