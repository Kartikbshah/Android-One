package com.fibonacciseries.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fibonacciseries.R;

import java.util.ArrayList;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {

    private ArrayList<String> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNumber;
        public ViewHolder(View v) {
            super(v);
            txtNumber = (TextView) v.findViewById(R.id.info_text);
        }
    }

    public RecyclerListAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.list_item_fibonacci, parent, false);
        ViewHolder view = new ViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNumber.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}