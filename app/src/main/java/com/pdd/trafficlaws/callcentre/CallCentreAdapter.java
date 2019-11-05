package com.pdd.trafficlaws.callcentre;

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

public class CallCentreAdapter extends RecyclerView.Adapter<CallCentreAdapter.ViewHolder> {

    private Context context;
    private List<CallCenterModel> modelCallCentreListlist;
    private OnItemClickListener onItemClickListener;

    public CallCentreAdapter(Context context, List<CallCenterModel>list){
        this.context = context;
        this.modelCallCentreListlist = list;

    }
//public class MySdaKrAdapter extends RecyclerView.Adapter<MySdaKrAdapter.ViewHolder> {
//    private Context context;
//    private List<ModelSdaKR> modelSdaKR;
//    private OnItemClickListener onItemClickListener;
//
//    public MySdaKrAdapter(Context context,List<ModelSdaKR>list){
//        this.context = context;
//        this.modelSdaKR = list;
//    }

    @NonNull
    @Override
    public CallCentreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewone,parent,false);
        return new CallCentreAdapter.ViewHolder(view);
    }
    //    @NonNull
//    @Override
//    public MySdaKrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(layout.row_traffic_laws, parent, false);
//        return new MySdaKrAdapter.ViewHolder(view);
//
//    }
    @Override
    public void onBindViewHolder(@NonNull CallCentreAdapter.ViewHolder holder, int position) {

        holder.bind(modelCallCentreListlist.get(position));
    }
 //   @Override
//    public void onBindViewHolder(@NonNull MySdaKrAdapter.ViewHolder holder, int position) {
//        holder.bind(modelSdaKR.get(position));
//    }

    @Override
    public int getItemCount() {
        return modelCallCentreListlist.size();
    }
    //    @Override
//    public int getItemCount() {
//        return modelSdaKR.size();
//    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    //    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    //        this.onItemClickListener = onItemClickListener;
//    }
//
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
          number.setText(callCenterModel.getNumber());
        }
    }
}


