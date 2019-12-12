package com.pdd.trafficlaws.gasStationPrices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.R;

import java.util.List;

public class AdapterRedPetrolium extends RecyclerView.Adapter<AdapterRedPetrolium.ViewHolder> {
    private Context context;
    private List<ModelRedPetrolium> modelRedPetroliumList;

    public AdapterRedPetrolium(Context context, List<ModelRedPetrolium> list) {
        this.context = context;
        this.modelRedPetroliumList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_redpetrolium,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelRedPetroliumList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelRedPetroliumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ai80;
        private TextView ai92;
        private TextView ai95;
        private TextView dt;
        private TextView gas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ai95 = itemView.findViewById(R.id.aired_95);
            ai92 = itemView.findViewById(R.id.aired_92);
            ai80 = itemView.findViewById(R.id.aired_80);
            dt = itemView.findViewById(R.id.diesel_fuelred);
            gas = itemView.findViewById(R.id.cos_pricered);
        }

        public void bind(ModelRedPetrolium modelRedPetrolium){
            ai95.setText(modelRedPetrolium.getAi95());
            ai92.setText(modelRedPetrolium.getAi92());
            ai80.setText(modelRedPetrolium.getAi80());
            dt.setText(modelRedPetrolium.getDt());
            gas.setText(modelRedPetrolium.getGas());
        }
    }

}
