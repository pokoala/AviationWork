package com.example.ga.airwayplan.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.activity.Fragment_Main;

import java.sql.BatchUpdateException;

public class User extends Fragment {

    private View view;
    private Button button;
    private ImageButton imageButton , imageButton2;
    private Fragment_Main mActivity;
    private ImageView image;


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
        view =  inflater.inflate(R.layout.fragment_user, container, false);
        initView();
        return view;
    }

    protected void initView(){
        image = (ImageView) view.findViewById(R.id.touxiang);
        button = (Button) view.findViewById(R.id.button3);
        imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) view.findViewById(R.id.imageButton2);
    }
}
