package com.pdd.trafficlaws.fine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.utils.ResourceManager;
import com.pdd.trafficlaws.utils.StringUtils;
import java.util.List;

public class FineAdapter extends RecyclerView.Adapter<FineAdapter.ViewHolder> {
    private Context context;
    private List<ModelFine> modelFineListlist;
    private OnItemClickListener onItemClickListener;

    public FineAdapter(Context context, List<ModelFine> list) {
        this.context = context;
        this.modelFineListlist = list;
    }

    @NonNull
    @Override
    public FineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_shtraf, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(modelFineListlist.get(position));
    }

    @Override
    public int getItemCount() {
        return modelFineListlist.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView statya, chast, fabula;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statya = itemView.findViewById(R.id.statya);
            chast = itemView.findViewById(R.id.chastei);
            fabula = itemView.findViewById(R.id.fabula);
            itemView.setOnClickListener(view -> onItemClickListener.onItemClickListener(getAdapterPosition()));
        }

        void bind(ModelFine modelstatya) {
            statya.setText(String.format(ResourceManager.getStringById(itemView.getContext(), R.string.statiya), StringUtils.replaceDotToDahs(modelstatya.getStatiya())));
            chast.setText(String.format((ResourceManager.getStringById(itemView.getContext(), R.string.chast)), StringUtils.replaceDotToDahs(modelstatya.getChast())));
            fabula.setText(modelstatya.getFabula());
        }
    }
}
