package com.pdd.trafficlaws.callcentre.adapter;

// CallCentreAdapterFo
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelThree;
import com.pdd.trafficlaws.callcentre.model.CallCentreModelFo;

import java.util.List;

public class CallCentreAdapterFo extends RecyclerView.Adapter<CallCentreAdapterFo.ViewHolder> {
    private Context context;
    private List<CallCentreModelFo> CallCentreModelFo;
    private OnItemClickListener onItemClickListener;

    public CallCentreAdapterFo(Context context, List<CallCentreModelFo>list){
        this.context = context;
        this.CallCentreModelFo = list;
    }

    @NonNull
    @Override
    public CallCentreAdapterFo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewfo,parent,false);
        return new CallCentreAdapterFo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(CallCentreModelFo.get(position));
    }

    @Override
    public int getItemCount() {
        return CallCentreModelFo.size();
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
        void bind(CallCentreModelFo callCenterModelFo){
            name.setText(callCenterModelFo.getName());
            number.setText(callCenterModelFo.getNumber());
        }
    }
}
