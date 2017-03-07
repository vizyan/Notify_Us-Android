package com.example.deadroit.spectrum;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

/**
 * Created by Deadroit on 1/27/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String [] Senin = {"Struktur Data","Sistem Basis Data","Kriptografi", "Jaringan Komputer 1"};
    String [] ruang_senin = {"D304", "D304", "E201", "D205"};
    String [] kelas_senin = {"A", "A", "A", "A"};
    String [] waktu_senin = {"07.00 - 08.40", "08.40 - 09.30", "10.20 - 12.00", "13.40 - 15.20"};
    String [] dosen_senin = {"Pak Yudi", "Bu Risma", "Pak Rizal", "Pak Adnan"};

    LayoutInflater inflater;
    public RecycleAdapter(Context context){
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
        } else if (day==2){
            holder.Matkul.setText(Senin[position]);
            holder.Ruang.setText(ruang_senin[position]);
            holder.Jam.setText(waktu_senin[position]);
            holder.Dosen.setText(dosen_senin[position]);
            holder.Kelas.setText("Kelas : "+kelas_senin[position]);
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
        return Senin.length;
    }
}
