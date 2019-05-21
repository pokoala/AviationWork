package com.example.ga.airwayplan.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.activity.BuyTicketActivity;
import com.example.ga.airwayplan.activity.CityPickerActivity;
import com.example.ga.airwayplan.activity.Fragment_Main;

import java.util.Calendar;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static android.app.Activity.RESULT_OK;

public class Add_plan extends Fragment {

    private View view;
    private Fragment_Main mActivity;
    private Button button;
    private ImageView imageView;
    private TextView startSite;
    private TextView endSite;
    private TextView data;
    //日期的dialog对象
    private DatePickerDialog dialog;
    //日期
    private Calendar calendar;
    //线程池
    final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,6,1, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());


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
       startSite = (TextView) view.findViewById(R.id.sSite);
       endSite = (TextView) view.findViewById(R.id.eSite);
       data = (TextView) view.findViewById(R.id.data);

       startSite.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mActivity,CityPickerActivity.class);
               startActivityForResult(intent,1);
           }
       });

       endSite.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mActivity,CityPickerActivity.class);
               startActivityForResult(intent,2);
           }
       });

       data.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               calendar = Calendar.getInstance();
               dialog = new DatePickerDialog(mActivity,
                       new DatePickerDialog.OnDateSetListener() {
                           @Override
                           public void onDateSet(DatePicker view, int year,
                                                 int monthOfYear, int dayOfMonth) {
                               System.out.println("年-->" + year + "月-->"
                                       + monthOfYear + "日-->" + dayOfMonth);
                               data.setText(year + "/" + monthOfYear + "/"
                                       + dayOfMonth);
                           }
                       }, calendar.get(Calendar.YEAR), calendar
                       .get(Calendar.MONTH), calendar
                       .get(Calendar.DAY_OF_MONTH));
               dialog.show();


           }
       });

       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mActivity, BuyTicketActivity.class);
               startActivity(intent);
           }
       });

    }


    //重写方法获得返回数据
    @Override
    public void onActivityResult(final int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                final String returnedData = data.getStringExtra("data_return");
                Log.d("wwwww","13"+returnedData);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startSite.setText(returnedData);
                            }
                        });

                    }
                };
                threadPoolExecutor.execute(runnable);
                break;
            case 2:
                final String returnedData1 = data.getStringExtra("data_return");
                Log.d("wwwww","13"+returnedData1);
                Runnable runnable1 = new Runnable() {
                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                endSite.setText(returnedData1);
                            }
                        });

                    }
                };
                threadPoolExecutor.execute(runnable1);
                break;
        }


    }




}
