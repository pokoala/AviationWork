package com.example.ga.airwayplan.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.activity.Fragment_Main;

public class Add_plan extends Fragment {

    private View view;
    private Fragment_Main mActivity;
    private Button button;
    private ImageView imageView;
    private EditText startSite;
    private EditText endSite;
    private EditText data;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Fragment_Main) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_addplan, container, false);
        initView();
        return view;
    }

    protected void initView(){
       button = (Button) view.findViewById(R.id.select);
       startSite = (EditText) view.findViewById(R.id.startSite);
       endSite = (EditText) view.findViewById(R.id.endSite);
       data = (EditText) view.findViewById(R.id.data);
    }

}
