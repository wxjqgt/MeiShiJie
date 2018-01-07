package com.weibo.meishijie.mvp.view.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder>{

    private List<T> datas;
    private Context context;
    private int layoutId;

    public CommonAdapter(Context context,int layoutId,List<T> datas) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
    }

    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public void setDatas(List<T> datas){
        this.datas.clear();
        addDatas(datas);
    }

    public void clear(){
        this.datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolder.createViewHolder(context, LayoutInflater.from(context).inflate(layoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        convert(holder,datas.get(position),position);
    }

    public abstract void convert(ViewHolder holder,T t,int position);

    @Override
    public int getItemCount() {
        return datas.size();
    }

}
