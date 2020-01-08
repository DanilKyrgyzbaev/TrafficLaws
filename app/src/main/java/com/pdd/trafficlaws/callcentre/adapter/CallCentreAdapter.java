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
import com.pdd.trafficlaws.callcentre.model.CallCenterModel;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelFaif;

import java.util.List;

public class CallCentreAdapter extends RecyclerView.Adapter<CallCentreAdapter.ViewHolder> {
    private Context context;
    private List<CallCenterModel> modelCallCentreListlist;
    private OnItemClickListener onItemClickListener;

    public CallCentreAdapter(Context context, List<CallCenterModel>list){
        this.context = context;
        this.modelCallCentreListlist = list;
    }

    @NonNull
    @Override
    public CallCentreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewone,parent,false);
        return new CallCentreAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallCentreAdapter.ViewHolder holder, int position) {

        holder.bind(modelCallCentreListlist.get(position));
    }


    @Override
    public int getItemCount() {
        return modelCallCentreListlist.size();
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
               void bind(CallCenterModel callCenterModel){
           name.setText(callCenterModel.getName());
          number.setText(callCenterModel.getNumber().replaceAll("xx",System.getProperty("line.separator")));
        }
    }
}


