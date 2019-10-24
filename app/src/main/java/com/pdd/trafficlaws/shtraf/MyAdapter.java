package com.pdd.trafficlaws.shtraf;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.utils.ResourceManager;
import com.pdd.trafficlaws.utils.StringUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ModelStatiya> modelStatiyaListlist;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, List<ModelStatiya> list) {
        this.context = context;
        this.modelStatiyaListlist = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_shtraf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelStatiyaListlist.get(position));
    }

    @Override
    public int getItemCount() {
        return modelStatiyaListlist.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView statya, chast, fabula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statya = itemView.findViewById(R.id.statya);
            chast = itemView.findViewById(R.id.chastei);
            fabula = itemView.findViewById(R.id.fabula);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });
        }

        void bind(ModelStatiya modelstatya) {
            statya.setText(String.format(ResourceManager.getStringById(itemView.getContext(), R.string.statiya), StringUtils.replaceDotToDahs(modelstatya.getStatiya())));
            chast.setText(String.format((ResourceManager.getStringById(itemView.getContext(), R.string.chast)),StringUtils.replaceDotToDahs(modelstatya.getChast())));
            fabula.setText(modelstatya.getFabula());
        }
    }
}
