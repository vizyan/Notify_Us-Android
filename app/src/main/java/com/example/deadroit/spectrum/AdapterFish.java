package com.example.deadroit.spectrum;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import static com.example.deadroit.spectrum.R.id.textSize;

public class AdapterFish extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private Context context;
    private LayoutInflater inflater;
    List<DataFish> data= Collections.emptyList();
    DataFish current;
    int currentPos=0;

    public AdapterFish(Context context, List<DataFish> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_fish, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder= (MyHolder) holder;
        DataFish current=data.get(position);
        myHolder.textFishName.setText(current.fishName);
        myHolder.textSize.setText("" + current.sizeName);
        myHolder.textType.setText("" + current.catName);
        myHolder.textPrice.setText("" + current.price + " WIB");

    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        public TextView textSize;
        TextView textType;
        TextView textPrice;

        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            textType = (TextView) itemView.findViewById(R.id.textType);
            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

    @Override
    public void onClick(View view){

    }

}
