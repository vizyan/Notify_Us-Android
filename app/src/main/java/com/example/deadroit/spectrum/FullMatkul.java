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
 * Created by Deadroit on 3/8/2017.
 */

public class FullMatkul extends RecyclerView.Adapter<RecycleViewHolder> {
    private final Context context;

    Calendar c = java.util.Calendar.getInstance();
    int day = c.get(java.util.Calendar.DAY_OF_WEEK);
    String[] Senin = {"Struktur Data", "Sistem Basis Data", "Kriptografi", "Jaringan Komputer 1"};
    String[] ruang_senin = {"D304", "D304", "D202", "D202"};
    String[] kelas_senin = {"A", "A", "A", "A"};
    String[] waktu_senin = {"07.00 - 08.40", "08.40 - 09.30", "10.20 - 12.00", "13.40 - 15.20"};
    String[] dosen_senin = {"Pak Yudi", "Pak Yudi", "Pak Rizal", "Pak Adnan"};
    String[] Selasa = {"RTOS", "KSI", "Arsitektur Komputer", "Arsitektur Komputer", "PPB"};
    String[] ruang_selasa = {"D205", "D205", "D205", "D205", "E201"};
    String[] dosen_selasa = {"Pak Teguh", "Pak Teguh", "Pak Teguh", "Pak Teguh", "Papah Kodrat"};
    String[] kelas_selasa = {"A", "B", "A", "B", "-"};
    String[] waktu_selasa = {"07.00 - 08.40", "08.40 - 09.30", "10.20 - 12.00", "12.00 - 13.40", "13.00 - 15.20"};
    String[] Rabu = {"Metodologi Penelitian", "Transduser dan Sensor", "Transduser dan Sensor", "Sistem Basis Data"};
    String[] ruang_rabu = {"E201", "D205", "D205", "E201"};
    String[] kelas_rabu = {"B", "A", "B", "B"};
    String[] dosen_rabu = {"Pak Agung", "Pak Teguh", "Pak Teguh", "Pak Yudi"};
    String[] waktu_rabu = {"08.40 - 09.30", "10.30 - 12.00", "12.00 - 13.40", "13.40 - 15.20"};
    String[] Kamis = {"Struktur Data", "RTOS", "Kriptografi", "Teknik Tele. Satelit", "Jaringan Komputer"};
    String[] ruang_kamis = {"D304", "D205", "D205", "D205", "D205"};
    String[] kelas_kamis = {"B", "B", "B", "A", "B"};
    String[] dosen_kamis = {"Pak Yudi", "Pak Teguh", "Pak Rizal", "Pak Sukiswo", "Pak Adnan"};
    String[] waktu_kamis = {"07.00 - 08.40", "07.00 - 08.40", "08.40 - 11.10", "11.20 - 12.50", "13.40 - 15.20"};
    String[] Jumat = {"Teknik Tele. Satelit"};
    String[] kelas_jumat = {"B"};
    String[] dosen_jumat = {"Pak Sukiswo"};
    String[] ruang_jumat = {"E201"};
    String[] waktu_jumat = {"08.40 - 10.20", "12.00 - 12.30"};
    LayoutInflater inflater;

    public FullMatkul(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_koala, parent, false);

        RecycleViewHolder viewHolder = new RecycleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        if (day == 1) {
            holder.Matkul.setText("LIBUR CUY");
        } else if (day == 2) {
            holder.Matkul.setText(Senin[position]);
            holder.Ruang.setText(ruang_senin[position]);
            holder.Jam.setText(waktu_senin[position]);
            holder.Dosen.setText(dosen_senin[position]);
            holder.Kelas.setText("Kelas : " + kelas_senin[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
        } else if (day == 3) {
            holder.Matkul.setText(Selasa[position]);
            holder.Kelas.setText("Kelas : " + kelas_selasa[position]);
            holder.Dosen.setText(dosen_selasa[position]);
            holder.Ruang.setText(ruang_selasa[position]);
            holder.Jam.setText(waktu_selasa[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
        } else if (day == 4) {
            holder.Matkul.setText(Rabu[position]);
            holder.Dosen.setText(dosen_rabu[position]);
            holder.Kelas.setText("Kelas : " + kelas_rabu[position]);
            holder.Ruang.setText(ruang_rabu[position]);
            holder.Jam.setText(waktu_rabu[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
        } else if (day == 5) {
            holder.Matkul.setText(Kamis[position]);
            holder.Dosen.setText(dosen_kamis[position]);
            holder.Kelas.setText("Kelas : " + kelas_kamis[position]);
            holder.Ruang.setText(ruang_kamis[position]);
            holder.Jam.setText(waktu_kamis[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
        } else if (day == 6) {
            holder.Matkul.setText(Jumat[position]);
            holder.Kelas.setText("Kelas : " + kelas_jumat[position]);
            holder.Dosen.setText(dosen_jumat[position]);
            holder.Ruang.setText(ruang_jumat[position]);
            holder.Jam.setText(waktu_jumat[position]);
            holder.relativeLayout.setTag(holder);
            holder.relativeLayout.setOnClickListener(clickListener);
            holder.Matkul.setTag(holder);
        } else {
            holder.Matkul.setText("JANGAN LUPA PRAKTIKUM");
        }

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final RecycleViewHolder viewHolder = (RecycleViewHolder) v.getTag();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Pilih Matkul?");
            builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    viewHolder.Matkul.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            });
            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
    };

    @Override
    public int getItemCount() {
        return Senin.length;
    }
}