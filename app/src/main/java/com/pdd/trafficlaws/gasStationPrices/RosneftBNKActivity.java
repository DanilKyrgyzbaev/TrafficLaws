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

public class RosneftBNKActivity extends AppCompatActivity {
    private static final String TAG = "tag" ;
    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerViewrosneft;
    private AdapterRosNeft adapterRosNeft;
    private TextView textView;
    private List<ModelRosneftBNK> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosneft_bnk);

        recyclerViewrosneft = findViewById(R.id.rosneft_recyclerView);
        recyclerViewrosneft.setLayoutManager(new LinearLayoutManager(this));
        adapterRosNeft = new AdapterRosNeft(this,modelList);
        recyclerViewrosneft.setAdapter(adapterRosNeft);

        db = FirebaseFirestore.getInstance();
        ref = db.collection("RosneftBNK");
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(ModelRosneftBNK.class));
            adapterRosNeft.notifyDataSetChanged();
        });

    }

    public void onClick(View view) {
        onBackPressed();
    }
}
