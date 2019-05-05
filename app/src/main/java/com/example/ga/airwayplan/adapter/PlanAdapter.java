package com.example.ga.airwayplan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.Routing;

import java.util.ArrayList;
import java.util.List;

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<Routing> mList;


    //创建构造函数
    public PlanAdapter(Context context, ArrayList<Routing> List){
        //将传递过来的数据 赋值给本地变量
        this.mcontext = context;
        this.mList = List;
    }



    //自定义ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView site;
        TextView time;

        public ViewHolder(View view){
            super(view);
            site = (TextView) view.findViewById(R.id.item_site);
            time = (TextView) view.findViewById(R.id.item_time);
        }
    }



    //创建viewholder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        //创建自定义布局
        View itemView = View.inflate(mcontext,R.layout.item,null);
        return new ViewHolder(itemView);
    }


    //绑定数据
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Routing routing = mList.get(position);
        holder.site.setText(routing.getPlace());
        holder.time.setText(routing.getTime());
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }



}
