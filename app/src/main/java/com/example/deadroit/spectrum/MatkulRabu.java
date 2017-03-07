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

public class MatkulRabu extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Rabu = {"Metodologi Penelitian", "Transduser dan Sensor", "Transduser dan Sensor", "Sistem Basis Data"};
    String [] ruang_rabu = {"E201", "D205", "D205", "E201"};
    String [] kelas_rabu = {"B", "A", "B", "B"};
    String [] dosen_rabu = {"Ganti ganti", "Pak Teguh", "Pak Teguh", "Pak Yudi"};
    String [] waktu_rabu = {"08.40 - 09.30", "10.30 - 12.00", "12.00 - 13.40", "13.40 - 15.20"};
    LayoutInflater inflater;

    public MatkulRabu(Context context){
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
       if (day==4){
            holder.Matkul.setText(Rabu[position]);
            holder.Dosen.setText(dosen_rabu[position]);
            holder.Kelas.setText("Kelas : "+kelas_rabu[position]);
            holder.Ruang.setText(ruang_rabu[position]);
            holder.Jam.setText(waktu_rabu[position]);
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
        return Rabu.length;
    }
}