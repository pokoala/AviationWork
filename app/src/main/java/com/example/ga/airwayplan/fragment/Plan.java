package com.example.ga.airwayplan.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.Routing;
import com.example.ga.airwayplan.activity.Fragment_Main;
import com.example.ga.airwayplan.adapter.PlanAdapter;

import java.util.ArrayList;
import java.util.List;

public class Plan extends Fragment {
    private View view;
    private Fragment_Main mActivity;
    private ArrayList<Routing> routingList = new ArrayList<>();
    private PlanAdapter planAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // mActivity = (Fragment_Main) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_plan, container, false);
        initView();
        initData();
        return view;
    }

    protected void initView(){
        //获取recyclerview
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        //创建adapter
        planAdapter = new PlanAdapter(getActivity(),routingList);
        //给recyclerview设置adapter
        recyclerView.setAdapter(planAdapter);
        //设置LayoutManager，可以设置显示效果或者瀑布流
        //参数是；上下文 列表方向 是否倒叙
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        //设置item的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //RecyclerView中没有item监听事件，自己在设配器中写接口


    }

    private void initData(){
        for (int i = 0;i<10;i++){
            Routing routing1 = new Routing();
            routing1.setPlace("ddddd"+i);
            routing1.setTime("15315"+i);
            routingList.add(routing1);
        }

    }

}
