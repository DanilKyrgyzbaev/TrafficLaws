package com.pdd.trafficlaws.osago;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.fine.FineAdapter;
import com.pdd.trafficlaws.fine.ModelFine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarInsuranceActivity extends AppCompatActivity {

    private static final String TAG = "tag" ;
    private FirebaseFirestore db;
    private CollectionReference ref;
    private RecyclerView recyclerView;
    private AdditionAdapter additionAdapter;
    private TextView textView;
    private List<AdditionModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_insurance);

        recyclerView = findViewById(R.id.recycler_view_Osago);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        additionAdapter = new AdditionAdapter(this,modelList);
        recyclerView.setAdapter(additionAdapter);
        textView = findViewById(R.id.description_osago);


        db = FirebaseFirestore.getInstance();
        ref = db.collection("Osago");
        ref.get().addOnSuccessListener(queryDocumentSnapshots -> {
            Log.e("ololo",  "");
            modelList.clear();
            modelList.addAll(queryDocumentSnapshots.toObjects(AdditionModel.class));
            additionAdapter.notifyDataSetChanged();
        });

    }

    public void onClick(View view) {
        onBackPressed();
    }
}
