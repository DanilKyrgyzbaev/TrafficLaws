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

public class MySdaKrAdapterSeven extends RecyclerView.Adapter<MySdaKrAdapterSeven.ViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<ModelSdaKR> modelSdaKrSevens;

    public MySdaKrAdapterSeven(Context context, List<ModelSdaKR> list) {
        this.context = context;
        this.modelSdaKrSevens = list;
    }

    @NonNull
    @Override
    public MySdaKrAdapterSeven.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_traffic_lawstwo,parent,false);
        return new MySdaKrAdapterSeven.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MySdaKrAdapterSeven.ViewHolder holder, int position) {
        holder.bind(modelSdaKrSevens.get(position));

    }

    @Override
    public int getItemCount() {
        return modelSdaKrSevens.size();
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
        void bind(ModelSdaKR modelSdaKrSeven) {
            general_provisions.setText(modelSdaKrSeven.getGeneral_provisions());

        }
    }
}
