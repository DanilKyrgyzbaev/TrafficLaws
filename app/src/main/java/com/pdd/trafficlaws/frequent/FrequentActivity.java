package com.pdd.trafficlaws.frequent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.fine.ModelFine;
import com.pdd.trafficlaws.osago.AdditionAdapter;
import com.pdd.trafficlaws.osago.AdditionModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FrequentActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerView;
    private FrequentAdapter frequentAdapter;
    private TextView textView;
    private List<FrequentModel> modelList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequent);


        recyclerView = findViewById(R.id.recycler_view_frequent);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        frequentAdapter = new FrequentAdapter(this,modelList);
        recyclerView.setAdapter(frequentAdapter);
        textView = findViewById(R.id.description_osago);


        db = FirebaseFirestore.getInstance();
        ref = db.collection("FrequentlyViolatedTrafficRules");
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            Log.e("ololo",  "");
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(FrequentModel.class));
            modelList.sort(Comparator.comparing(FrequentModel::getOrder));

            frequentAdapter.notifyDataSetChanged();
        });
    }

    public void onClickfrequent(View view) {
        onBackPressed();
    }
}
