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

public class MatkulSelasa extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Selasa = {"RTOS", "KSI", "Arsitektur Komputer", "Arsitektur Komputer", "PPB"};
    String [] ruang_selasa = {"D205", "D205", "D205", "D205", "E201"};
    String [] dosen_selasa = {"Bu Dania", "Pak Adnan", "Pak Teguh", "Pak Teguh", "Pak Kodrat"};
    String [] kelas_selasa = {"A", "B", "A", "B", "-"};
    String [] waktu_selasa = {"07.00 - 08.40", "08.40 - 09.30", "10.20 - 12.00", "12.00 - 13.40", "13.00 - 15.20"};
    LayoutInflater inflater;

    public MatkulSelasa(Context context){
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

        if (day==3){
            holder.Matkul.setText(Selasa[position]);
            holder.Kelas.setText("Kelas : "+kelas_selasa[position]);
            holder.Dosen.setText(dosen_selasa[position]);
            holder.Ruang.setText(ruang_selasa[position]);
            holder.Jam.setText(waktu_selasa[position]);
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
        return Selasa.length;
    }
}