package com.pdd.trafficlaws.sda_kr;

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

public class MySdaKrAdapter extends RecyclerView.Adapter<MySdaKrAdapter.ViewHolder> {
    private Context context;
    private List<ModelSdaKR> modelSdaKR;
    private OnItemClickListener onItemClickListener;

    public MySdaKrAdapter(Context context,List<ModelSdaKR>list){
        this.context = context;
        this.modelSdaKR = list;
    }




    @NonNull
    @Override
    public MySdaKrAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout.row_traffic_laws, parent, false);
        return new MySdaKrAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MySdaKrAdapter.ViewHolder holder, int position) {
        holder.bind(modelSdaKR.get(position));
    }

    @Override
    public int getItemCount() {
        return modelSdaKR.size();
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

        void bind(ModelSdaKR modelSdaKR) {
            general_provisions.setText(modelSdaKR.getGeneral_provisions());

        }
    }
}
