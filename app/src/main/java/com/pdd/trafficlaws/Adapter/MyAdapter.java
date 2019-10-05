package com.pdd.trafficlaws.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdd.trafficlaws.Model.Modelstatya;
import com.pdd.trafficlaws.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Modelstatya> list;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(Context context, List<Modelstatya> list){
        this.context = context;
        this.list = list;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shtraf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView statya, chast, fabula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statya = itemView.findViewById(R.id.statya);
            chast = itemView.findViewById(R.id.chastei);
            fabula = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        public void bind(Modelstatya modelstatya){
            statya.setText(modelstatya.getStatiya());
            chast.setText(modelstatya.getChast());
            fabula.setText(modelstatya.getFabula());
        }
    }
}
