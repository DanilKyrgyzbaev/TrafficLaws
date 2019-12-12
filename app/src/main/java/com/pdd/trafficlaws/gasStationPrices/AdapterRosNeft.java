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

public class AdapterRosNeft extends RecyclerView.Adapter<AdapterRosNeft.ViewHolder> {
    private Context context;
    private List<ModelRosneftBNK> modelRosneftBNKList;

    public AdapterRosNeft(Context context, List<ModelRosneftBNK> list) {
        this.context = context;
        this.modelRosneftBNKList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_rosneftbnk,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelRosneftBNKList.get(position));

    }

    @Override
    public int getItemCount() {
        return modelRosneftBNKList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ai80;
        private TextView ai92;
        private TextView ai95;
        private TextView dt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ai95 = itemView.findViewById(R.id.airosneft_95);
            ai92 = itemView.findViewById(R.id.airosneft_92);
            ai80 = itemView.findViewById(R.id.airosneft_80);
            dt = itemView.findViewById(R.id.diesel_fuel_rosneft);
        }
        public void bind(ModelRosneftBNK modelRosneftBNK){
            ai95.setText(modelRosneftBNK.getAi95());
            ai92.setText(modelRosneftBNK.getAi92());
            ai80.setText(modelRosneftBNK.getAi80());
            dt.setText(modelRosneftBNK.getDt());


        }
    }
}
