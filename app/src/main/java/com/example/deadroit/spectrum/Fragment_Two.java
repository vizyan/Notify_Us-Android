package com.example.deadroit.spectrum;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class Fragment_Two extends Fragment  {

    RecyclerView recyclerView;

    public static Fragment_Two newInstance(){
        return new Fragment_Two();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Calendar c = java.util.Calendar.getInstance();
        int day = c.get(java.util.Calendar.DAY_OF_WEEK);

        if (day==1){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulSabtu adapter = new MatkulSabtu(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==2){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            RecycleAdapter adapter = new RecycleAdapter(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==3){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulSelasa adapter = new MatkulSelasa(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==4){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulRabu adapter = new MatkulRabu(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==5){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulKamis adapter = new MatkulKamis(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==6){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulJumat adapter = new MatkulJumat(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        } else if(day==7){
            recyclerView = (RecyclerView) getActivity().findViewById(R.id.fishKoalaList);
            MatkulSabtu adapter = new MatkulSabtu(getContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

    }
}

