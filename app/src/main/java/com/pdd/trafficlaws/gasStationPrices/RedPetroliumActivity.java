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

public class RedPetroliumActivity extends AppCompatActivity {
    private static final String TAG = "tag" ;
    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerViewred;
    private AdapterRedPetrolium adapterRedPetrolium;
    private TextView textView;
    private List<ModelRedPetrolium> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_petrolium);

        recyclerViewred = findViewById(R.id.red_petrolium_recyclerView);
        recyclerViewred.setLayoutManager(new LinearLayoutManager(this));
        adapterRedPetrolium = new AdapterRedPetrolium(this,modelList);
        recyclerViewred.setAdapter(adapterRedPetrolium);

        db = FirebaseFirestore.getInstance();
        ref = db.collection("RedPetroleum");
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(ModelRedPetrolium.class));
            adapterRedPetrolium.notifyDataSetChanged();
        });

    }

    public void onClick(View view) {
        onBackPressed();
    }
}
