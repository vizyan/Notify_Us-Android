package com.example.deadroit.spectrum;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Deadroit on 1/27/2017.
 */

public class RecycleViewHolder extends RecyclerView.ViewHolder {
    TextView Matkul, Ruang, Dosen, Jam, Date, Kelas;
    RelativeLayout relativeLayout;

    public RecycleViewHolder(View itemView){
        super(itemView);

        Matkul = (TextView) itemView.findViewById(R.id.textMatkul);
        Ruang = (TextView) itemView.findViewById(R.id.textTempat);
        Jam = (TextView) itemView.findViewById(R.id.textWaktu);
        Kelas = (TextView) itemView.findViewById(R.id.textKelas);
        Dosen = (TextView) itemView.findViewById(R.id.textDosen);
        relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative1);
    }
}
