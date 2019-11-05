package com.pdd.trafficlaws.sda_kr;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.ArraySet;
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
import java.util.ArrayList;
import java.util.Comparator;

public class TrafficLawsActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;
    private MySdaKrAdapter mySdaKrAdapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private String TAG = "tag";
    private String SDAKR = "SdaKr";
    private ArrayList<ModelSdaKR> modelSdaKrListlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_laws);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(view -> TrafficLawsActivity.this.onBackPressed());

        recyclerView = findViewById(R.id.sda_kr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mySdaKrAdapter = new MySdaKrAdapter(this, modelSdaKrListlist);
        recyclerView.setAdapter(mySdaKrAdapter);
        mySdaKrAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrActivity.class);
            intent.putExtra(SDAKR, modelSdaKrListlist.get(position));
            startActivity(intent);
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection(SDAKR);
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
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
//

    }
}
