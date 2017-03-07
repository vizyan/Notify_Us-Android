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

public class MatkulKamis extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Kamis = {"Struktur Data", "RTOS", "Kriptografi", "Teknik Tele. Satelit", "Jaringan Komputer"};
    String [] ruang_kamis = {"D304", "D205", "D205", "D205", "D205"};
    String [] kelas_kamis = {"B", "B", "B", "A", "B"};
    String [] dosen_kamis = {"Pak Yudi", "Pak Teguh", "Pak Rizal", "Pak Sukiswo", "Pak Adnan"};
    String [] waktu_kamis = {"07.00 - 08.40", "07.00 - 08.40", "08.40 - 11.10", "11.20 - 12.50", "13.40 - 15.20"};
    LayoutInflater inflater;

    public MatkulKamis(Context context){
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
        if (day==5){
            holder.Matkul.setText(Kamis[position]);
            holder.Dosen.setText(dosen_kamis[position]);
            holder.Kelas.setText("Kelas : "+kelas_kamis[position]);
            holder.Ruang.setText(ruang_kamis[position]);
            holder.Jam.setText(waktu_kamis[position]);
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
        return Kamis.length;
    }
}