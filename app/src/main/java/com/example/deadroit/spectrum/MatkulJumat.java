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

public class MatkulJumat extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Jumat = {"Teknik Tele. Satelit"};
    String [] kelas_jumat = {"B"};
    String [] dosen_jumat ={"Pak Sukiswo"};
    String [] ruang_jumat = {"E201"};
    String [] waktu_jumat = {"08.40 - 10.20"};
    LayoutInflater inflater;

    public MatkulJumat(Context context){
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
        if (day==6){
            holder.Matkul.setText(Jumat[position]);
            holder.Kelas.setText("Kelas : "+kelas_jumat[position]);
            holder.Dosen.setText(dosen_jumat[position]);
            holder.Ruang.setText(ruang_jumat[position]);
            holder.Jam.setText(waktu_jumat[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
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
        return Jumat.length;
    }
}