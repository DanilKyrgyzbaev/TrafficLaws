package com.pdd.trafficlaws.gasStationPrices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pdd.trafficlaws.R;
import java.util.ArrayList;
import java.util.List;

public class BishkekPetroliumActivity extends AppCompatActivity {

    private static final String TAG = "tag" ;
    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerView;
    private AdapterBishkekPetrolium adapterBishkekPetrolium;
    private TextView textView;
    private List<ModelBishkekPetrolium> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bishkek_petrolium);

        recyclerView = findViewById(R.id.bishkek_petrolium_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterBishkekPetrolium = new AdapterBishkekPetrolium(this,modelList);
        recyclerView.setAdapter(adapterBishkekPetrolium);

        db = FirebaseFirestore.getInstance();
        ref = db.collection("GasStationPrices");
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(ModelBishkekPetrolium.class));
            adapterBishkekPetrolium.notifyDataSetChanged();
        });

    }

    public void onClick(View view) {
        onBackPressed();
    }
}
