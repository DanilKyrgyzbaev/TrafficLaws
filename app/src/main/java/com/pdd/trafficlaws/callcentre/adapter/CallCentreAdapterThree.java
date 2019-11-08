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
import com.pdd.trafficlaws.callcentre.model.CallCenterModelThree;
import java.util.List;

public class CallCentreAdapterThree extends RecyclerView.Adapter<CallCentreAdapterThree.ViewHolder> {
    private Context context;
    private List<CallCenterModelThree> modelCallCentreThreeListlist;
    private OnItemClickListener onItemClickListener;

    public CallCentreAdapterThree(Context context, List<CallCenterModelThree>list){
        this.context = context;
        this.modelCallCentreThreeListlist = list;
    }

    @NonNull
    @Override
    public CallCentreAdapterThree.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_cardviewthree,parent,false);
        return new CallCentreAdapterThree.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelCallCentreThreeListlist.get(position));
    }

    @Override
    public int getItemCount() {
        return modelCallCentreThreeListlist.size();
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
        void bind(CallCenterModelThree callCenterModelThree){
            name.setText(callCenterModelThree.getName());
            number.setText(callCenterModelThree.getNumber());
        }
    }
}
