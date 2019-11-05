package com.pdd.trafficlaws.callcentre;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pdd.trafficlaws.OnItemClickListener;
import com.pdd.trafficlaws.R;

import java.util.ArrayList;
import java.util.Comparator;

public class CallCentreActivity extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private String TAG = "tag";
    private ExpandableCardView expandableCardView;
    private CallCentreAdapter callCentreAdapter;
    private String number;
    private ArrayList<CallCenterModel> callCenterModel = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_centre);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_navigate);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recyclerView = findViewById(R.id.row_callcentre);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        callCentreAdapter = new CallCentreAdapter(this, callCenterModel);
        recyclerView.setAdapter(callCentreAdapter);

        callCentreAdapter.setOnItemClickListener(position -> {
            String uri = "tel:" + callCenterModel.get(position).getNumber();
            Log.e("----------------", uri);
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });

        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection("CallCentre");
        collectionReference.get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCenterModel.clear();
            callCenterModel.addAll(queryDocumentSnapshots.toObjects(CallCenterModel.class));
            callCenterModel.sort(Comparator.comparing(CallCenterModel::getId));
            callCentreAdapter.notifyDataSetChanged();
        });


    }
}
