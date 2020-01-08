package com.pdd.trafficlaws.osago;

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

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.ViewHolder> {

    private Context context;
    private List<AdditionModel> modelAdditionListner;

    public AdditionAdapter(Context context, List<AdditionModel> list) {
        this.context = context;
        this.modelAdditionListner = list;
    }

    @NonNull
    @Override
    public AdditionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_osago,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdditionAdapter.ViewHolder holder, int position) {
        holder.bind(modelAdditionListner.get(position));
    }

    @Override
    public int getItemCount() {
        return modelAdditionListner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private  TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_osago);
            description = itemView.findViewById(R.id.description_osago);
        }
        void  bind (AdditionModel additionModel){
            name.setText(additionModel.getName());
            description.setText(additionModel.getDescription().replaceAll("xx", System.getProperty("line.separator")));

        }
    }

}
