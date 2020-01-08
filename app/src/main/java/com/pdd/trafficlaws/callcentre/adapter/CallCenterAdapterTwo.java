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
import com.pdd.trafficlaws.callcentre.model.CallCenterModelTwo;

import java.util.List;

public class CallCenterAdapterTwo extends RecyclerView.Adapter<CallCenterAdapterTwo.ViewHolder> {
    private Context context;
    private List<CallCenterModelTwo> modelCallCentreTwoListlist;
    private OnItemClickListener onItemClickListener;

    public CallCenterAdapterTwo(Context context, List<CallCenterModelTwo>list){
        this.context = context;
        this.modelCallCentreTwoListlist = list;
    }

    @NonNull
    @Override
    public CallCenterAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewtwo,parent,false);
        return new CallCenterAdapterTwo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelCallCentreTwoListlist.get(position));
    }

    @Override
    public int getItemCount() {
        return modelCallCentreTwoListlist.size();
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
        void bind(CallCenterModelTwo callCenterModelTwo){
            name.setText(callCenterModelTwo.getName());
            number.setText(callCenterModelTwo.getNumber().replaceAll("xx",System.getProperty("line.separator")));
        }
    }
}


