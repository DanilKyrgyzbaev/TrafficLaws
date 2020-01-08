package com.pdd.trafficlaws.callcentre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelFaif;
import java.util.List;

public class CallCenterAdapterFaif extends RecyclerView.Adapter<CallCenterAdapterFaif.ViewHolder> {
    private Context context;
    private List<CallCenterModelFaif> modelCallCentreFaifListlist;
    private OnItemClickListener onItemClickListener;

    public CallCenterAdapterFaif(Context context, List<CallCenterModelFaif>list){
        this.context = context;
        this.modelCallCentreFaifListlist = list;
    }

    @NonNull
    @Override
    public CallCenterAdapterFaif.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewfaif,parent,false);
        return new CallCenterAdapterFaif.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelCallCentreFaifListlist.get(position));
    }

    @Override
    public int getItemCount() {
        return modelCallCentreFaifListlist.size();
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, number ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });
        }
        void bind(CallCenterModelFaif callCenterModelFaif){
            name.setText(callCenterModelFaif.getName());
          //  number.setText(callCenterModelFaif.getNumber());
            number.setText(callCenterModelFaif.getNumber().replaceAll("xx",System.getProperty("line.separator")));


        }
    }
}
