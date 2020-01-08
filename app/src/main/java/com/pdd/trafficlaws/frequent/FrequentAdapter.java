package com.pdd.trafficlaws.frequent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.R;

import java.util.List;

public class FrequentAdapter extends RecyclerView.Adapter<FrequentAdapter.ViewHolder> {
    private Context context;
    private List<FrequentModel> frequentModelList;

    public FrequentAdapter(Context context, List<FrequentModel> list) {
        this.context = context;
        this.frequentModelList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_frequent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binds(frequentModelList.get(position));

    }

    @Override
    public int getItemCount() {
        return frequentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fabula;
        private TextView fines;
        private TextView prices;
        private TextView violation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             fabula = itemView.findViewById(R.id.fabula);
             fines = itemView.findViewById(R.id.fines);
             prices = itemView.findViewById(R.id.price);
             violation = itemView.findViewById(R.id.violation);
        }

        public void binds (FrequentModel frequentModel){
            fabula.setText(frequentModel.getFabula());
            fines.setText(frequentModel.getFines());
            prices.setText(frequentModel.getPrices());
            violation.setText(frequentModel.getViolation());

        }
    }
}
