package com.pdd.trafficlaws.sdakr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKR;

import java.util.List;

public class MySdaKrAdapterFif extends RecyclerView.Adapter<MySdaKrAdapterFif.ViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<ModelSdaKR> modelSdaKrFifList;

    public MySdaKrAdapterFif(Context context, List<ModelSdaKR>list){
        this.context = context;
        this.modelSdaKrFifList = list;
    }

    @NonNull
    @Override
    public MySdaKrAdapterFif.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_traffic_lawstwo,parent,false);
        return new MySdaKrAdapterFif.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MySdaKrAdapterFif.ViewHolder holder, int position) {
        holder.bind(modelSdaKrFifList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelSdaKrFifList.size();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView general_provisions;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            general_provisions = itemView.findViewById(R.id.general_provisions);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClickListener(getAdapterPosition()));
        }

        void bind (ModelSdaKR modelSdaKrFif){
            general_provisions.setText(modelSdaKrFif.getGeneral_provisions());

        }

    }
}
