package com.example.deadroit.spectrum;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

/**
 * Created by Deadroit on 2/15/2017.
 */

public class MatkulSabtu extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Sabtu = {"Libur"};
    LayoutInflater inflater;

    public MatkulSabtu(Context context){
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.container_koala, parent, false);

        RecycleViewHolder viewHolder = new RecycleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position){
        if (day==1){
            holder.Matkul.setText("LIBUR CUY");
        }  else {
            holder.Matkul.setText("JANGAN LUPA PRAKTIKUM");
        }

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final RecycleViewHolder viewHolder = (RecycleViewHolder) v.getTag();
        }
    };

    @Override
    public int getItemCount(){
        return Sabtu.length;
    }
}