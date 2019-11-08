package com.pdd.trafficlaws.sdakr;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pdd.trafficlaws.OnItemClickListener;
import java.util.List;
import static com.pdd.trafficlaws.R.*;

public class MySdaKrAdapterThree extends RecyclerView.Adapter<MySdaKrAdapterThree.ViewHolder> {
    private Context context;
    private List<ModelSdaKrThree> modelSdaKrThree;
    private OnItemClickListener onItemClickListener;

    public MySdaKrAdapterThree(Context context,List<ModelSdaKrThree>list){
        this.context = context;
        this.modelSdaKrThree = list;
    }




    @NonNull
    @Override
    public MySdaKrAdapterThree.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout.row_traffic_lawstwo, parent, false);
        return new MySdaKrAdapterThree.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MySdaKrAdapterThree.ViewHolder holder, int position) {
        holder.bind(modelSdaKrThree.get(position));
    }

    @Override
    public int getItemCount() {
        return modelSdaKrThree.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView general_provisions;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            general_provisions = itemView.findViewById(id.general_provisions);
//            description = find

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(getAdapterPosition());
                }
            });
        }

        void bind(ModelSdaKrThree modelSdaKrThree) {
            general_provisions.setText(modelSdaKrThree.getGeneral_provisions());
            //general_provisions.setText(modelSdaKrThree.getGeneral_provisions());

        }
    }
}

// MySdaKrAdapterThree

