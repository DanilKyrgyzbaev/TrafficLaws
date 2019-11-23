package com.pdd.trafficlaws.fine;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pdd.trafficlaws.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FineActivity extends AppCompatActivity {


    private final String STATIYA = "statiya";
    private final String CHAST = "chast";
    private String SHTRAF = "ShtrafKg";
    private final String ORDER = "order";
    private String TAG = "tag";
    private TextView langRu;
    private TextView langKg;

    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private List<ModelFine> modelList = new ArrayList<>();
    private FineAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        langKg = findViewById(R.id.lang_kg);
        langRu = findViewById(R.id.lang_ru);

        langRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SHTRAF.equals("Shtraf")) {
                    SHTRAF = "Shtraf";
                    getData();
                }
                Log.d("ololo", SHTRAF);
            }
        });
        langKg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SHTRAF.equals("ShtrafKg")) {
                    SHTRAF = "ShtrafKg";
                    getData();
                }
                Log.d("ololo", SHTRAF);
            }
        });

        recyclerView = findViewById(R.id.recycler_view_shtraf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FineAdapter(this, modelList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> {
            Log.e("--------------", position + "");
            Intent intent = new Intent(FineActivity.this, OnResultFineActivity.class);
            intent.putExtra("fine", modelList.get(position));
            startActivity(intent);
        });

        db = FirebaseFirestore.getInstance();
        getData();
        // orderBy это для сортировки от слова statiya


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void getData() {
        ref = db.collection(SHTRAF);
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(ModelFine.class));
            modelList.sort(Comparator.comparing(ModelFine::getOrder));
            Log.e(TAG, "onSuccess: ");
            for (ModelFine m : modelList) {

            }
            adapter.notifyDataSetChanged();
        });
    }
}
