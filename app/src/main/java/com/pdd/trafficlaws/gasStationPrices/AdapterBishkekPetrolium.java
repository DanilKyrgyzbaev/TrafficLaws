package com.pdd.trafficlaws.gasStationPrices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;

import java.util.List;

public class AdapterBishkekPetrolium extends RecyclerView.Adapter<AdapterBishkekPetrolium.ViewHolder> {
    private Context context;
    private List<ModelBishkekPetrolium> bishkekPetroliumList;
    private OnItemClickListener onItemClickListener;

    public AdapterBishkekPetrolium(Context context, List<ModelBishkekPetrolium> list) {
        this.context = context;
        this.bishkekPetroliumList = list;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_bishkekpetrilium,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(bishkekPetroliumList.get(position));

    }

    @Override
    public int getItemCount() {
        return bishkekPetroliumList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cos;
        private TextView dieselfuel;
        private TextView premiumeuro;
        private TextView regular;
        private TextView supereuro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cos = itemView.findViewById(R.id.cos_price);
            dieselfuel = itemView.findViewById(R.id.diesel_fuel);
            premiumeuro = itemView.findViewById(R.id.premiumEuro_95);
            regular = itemView.findViewById(R.id.regular_92);
            supereuro = itemView.findViewById(R.id.supereuro98);

        }

        void bind (ModelBishkekPetrolium modelBishkekPetrolium){
            cos.setText(modelBishkekPetrolium.getCos());
            dieselfuel.setText(modelBishkekPetrolium.getDieselfuel());
            premiumeuro.setText(modelBishkekPetrolium.getPremiumeuro());
            regular.setText(modelBishkekPetrolium.getRegular());
            supereuro.setText(modelBishkekPetrolium.getSupereuro());
        }
    }
}
