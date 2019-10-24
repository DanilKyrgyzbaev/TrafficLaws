package com.pdd.trafficlaws.shtraf;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;
import java.util.ArrayList;
import java.util.List;

public class ShtrafActivity extends AppCompatActivity {


    private final String STATIYA = "statiya";
    private final String CHAST = "chast";
    private final String SHTRAF = "Shtraf";
    private final String  ORDER = "order";

    private FirebaseFirestore db;
    private CollectionReference ref;
    private Toolbar toolbar;
    private List<ModelStatiya> modelList = new ArrayList<>();
    private  MyAdapter adapter;

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
        adapter = new MyAdapter(this, modelList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Log.e("--------------", position+"");
                Intent intent = new Intent(ShtrafActivity.this, OnResultActivity.class);
                intent.putExtra("shtraf", modelList.get(position));
                startActivity(intent);
            }
        });

        db = FirebaseFirestore.getInstance();
        ref = db.collection(SHTRAF);
        // orderBy это для сортировки от слова statiya
        ref.orderBy(ORDER).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelList.clear();
                modelList.addAll(queryDocumentSnapshots.toObjects(ModelStatiya.class));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
