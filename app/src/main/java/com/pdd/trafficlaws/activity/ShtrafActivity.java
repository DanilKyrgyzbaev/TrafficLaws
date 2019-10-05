package com.pdd.trafficlaws.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pdd.trafficlaws.Adapter.MyAdapter;
import com.pdd.trafficlaws.Model.Modelstatya;
import com.pdd.trafficlaws.R;

import java.util.ArrayList;
import java.util.List;

public class ShtrafActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private CollectionReference ref;
    Toolbar toolbar;
    private List<Modelstatya> modelList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shtraf);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setTitle("activity");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view_shtraf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MyAdapter adapter = new MyAdapter(this, modelList);
        recyclerView.setAdapter(adapter);




      //  final TextView text = findViewById(R.id.shtrafText);
        db = FirebaseFirestore.getInstance();
        ref = db.collection("Shtraf");
        modelList.clear();
        ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot q : queryDocumentSnapshots){
                  //  text.setText(q.getString("name"));
                    Modelstatya modelstatya = q.toObject(Modelstatya.class);
                    modelList.add(modelstatya);
                }
                adapter.notifyDataSetChanged();

            }
        });

    }
}
