package com.pdd.trafficlaws.sdakr;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapter;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterThree;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterTwo;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKR;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKrThree;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKrTwo;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrThreeActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrTwoActivity;

import java.util.ArrayList;
import java.util.Comparator;

public class TrafficLawsActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;
    private MySdaKrAdapter mySdaKrAdapter;
    private MySdaKrAdapterTwo mySdaKrAdapterTwo;
    private MySdaKrAdapterThree mySdaKrAdapterThree;
    private RecyclerView recyclerView, recyclerViewtwo , recyclerViewthree;
    private Toolbar toolbar;
    private String TAG = "tag";
    private String SDAKR = "SdaKr";
    private ArrayList<ModelSdaKR> modelSdaKrListlist = new ArrayList<>();
    private ArrayList<ModelSdaKrTwo> modelSdaKrTwoListlist = new ArrayList<>();
    private ArrayList<ModelSdaKrThree> modelSdaKrThrees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_laws);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(view -> TrafficLawsActivity.this.onBackPressed());
        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            SDAKR = "SdaKrKg";
        } else {
            SDAKR = "SdaKr";
        }

        recyclerView = findViewById(R.id.sda_kr2);
        recyclerViewtwo = findViewById(R.id.sda_kr);
        recyclerViewthree = findViewById(R.id.sda_kr3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewtwo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewthree.setLayoutManager(new LinearLayoutManager(this));
        mySdaKrAdapter = new MySdaKrAdapter(this, modelSdaKrListlist);
        mySdaKrAdapterTwo = new MySdaKrAdapterTwo(this,modelSdaKrTwoListlist);
        mySdaKrAdapterThree = new MySdaKrAdapterThree(this,modelSdaKrThrees);
        recyclerView.setAdapter(mySdaKrAdapter);
        recyclerViewtwo.setAdapter(mySdaKrAdapterTwo);
        recyclerViewthree.setAdapter(mySdaKrAdapterThree);
        mySdaKrAdapterThree.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrThreeActivity.class);
            intent.putExtra("SdaKr",modelSdaKrThrees.get(position));
            startActivity(intent);
        });
        mySdaKrAdapterTwo.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrTwoActivity.class);
            intent.putExtra("SdaKr",modelSdaKrTwoListlist.get(position));
            startActivity(intent);
        });
        mySdaKrAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrActivity.class);
            intent.putExtra("SdaKr", modelSdaKrListlist.get(position));
            startActivity(intent);
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection(SDAKR);

        collectionReference.whereLessThan("order", 9).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrTwoListlist.clear();
                modelSdaKrTwoListlist.addAll(queryDocumentSnapshots.toObjects(ModelSdaKrTwo.class));
                modelSdaKrTwoListlist.sort(Comparator.comparing(ModelSdaKrTwo::getOrder));
            }
        });
        collectionReference.whereGreaterThan("order",8).whereLessThan("order", 17).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrListlist.clear();
                modelSdaKrListlist.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrListlist.sort(Comparator.comparing(ModelSdaKR::getOrder));
                Log.e(TAG, modelSdaKrListlist.toString());
                mySdaKrAdapter.notifyDataSetChanged();
            }
        });
        collectionReference.whereGreaterThan("order",16).whereLessThan("order",28).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrThrees.clear();
                modelSdaKrThrees.addAll(queryDocumentSnapshots.toObjects(ModelSdaKrThree.class));
                modelSdaKrThrees.sort(Comparator.comparing(ModelSdaKrThree::getOrder));
                Log.e(TAG, modelSdaKrThrees.toString() );
            }
        });
    }
}
