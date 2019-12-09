package com.pdd.trafficlaws.sdakr.adapter;

 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.recyclerview.widget.RecyclerView;
 import com.pdd.trafficlaws.OnItemClickListener;
 import com.pdd.trafficlaws.sdakr.model.ModelSdaKR;

 import java.util.List;
 import static com.pdd.trafficlaws.R.*;

public class MySdaKrAdapterTwo extends RecyclerView.Adapter<MySdaKrAdapterTwo.ViewHolder> {
    private Context context;
    private List<ModelSdaKR> modelSdaKrTwos;
    private OnItemClickListener onItemClickListener;

    public MySdaKrAdapterTwo(Context context,List<ModelSdaKR>list){
        this.context = context;
        this.modelSdaKrTwos = list;
    }




    @NonNull
    @Override
    public MySdaKrAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout.row_traffic_lawstwo, parent, false);
        return new MySdaKrAdapterTwo.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MySdaKrAdapterTwo.ViewHolder holder, int position) {
        holder.bind(modelSdaKrTwos.get(position));
    }

    @Override
    public int getItemCount() {
        return modelSdaKrTwos.size();
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

            itemView.setOnClickListener(view -> onItemClickListener.onItemClickListener(getAdapterPosition()));
        }

        void bind(ModelSdaKR modelSdaKR) {
            general_provisions.setText(modelSdaKR.getGeneral_provisions());

        }
    }
}

