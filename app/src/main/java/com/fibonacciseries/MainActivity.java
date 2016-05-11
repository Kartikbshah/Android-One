package com.fibonacciseries;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fibonacciseries.adapter.RecyclerListAdapter;

import java.math.BigInteger;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    static final int NUMBER_OF_FIBONACCI_SEQUENCE = 100;
    private Context mContext;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        setRecycleAdapter();
    }

    private void setRecycleAdapter() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        new Thread(new Runnable() {
            @Override
            public void run() {
                mAdapter = new RecyclerListAdapter(getFibonacci());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setAdapter(mAdapter);
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }

    private ArrayList<String> getFibonacci() {
        ArrayList<String> listFib = new ArrayList<>();
        for (int i = 1; i < NUMBER_OF_FIBONACCI_SEQUENCE; i++) {
                listFib.add("F "+i+" - "+fibo(i));
        }
        return listFib;
    }

    public String fibo(int x){
        BigInteger[] arr = new BigInteger[x+1];
        arr[0]=BigInteger.ZERO;
        arr[1]= BigInteger.ONE;
        for (int i=2; i<=x; i++){
            arr[i]=arr[i-2].add(arr[i-1]);
        }
        return arr[x].toString();
    }

}
