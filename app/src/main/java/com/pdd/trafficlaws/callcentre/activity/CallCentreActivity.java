package com.pdd.trafficlaws.callcentre.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.callcentre.adapter.CallCenterAdapterFaif;
import com.pdd.trafficlaws.callcentre.adapter.CallCenterAdapterTwo;
import com.pdd.trafficlaws.callcentre.adapter.CallCentreAdapter;
import com.pdd.trafficlaws.callcentre.adapter.CallCentreAdapterFo;
import com.pdd.trafficlaws.callcentre.adapter.CallCentreAdapterThree;
import com.pdd.trafficlaws.callcentre.model.CallCenterModel;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelFaif;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelThree;
import com.pdd.trafficlaws.callcentre.model.CallCenterModelTwo;
import com.pdd.trafficlaws.callcentre.model.CallCentreModelFo;

import java.util.ArrayList;
import java.util.Comparator;

public class CallCentreActivity extends AppCompatActivity {
    private final String ID = "id";
    private final String CALLCENRE = "CallCentre";
    private CallCentreAdapter callCentreAdapter;
    private CallCenterAdapterTwo callCenterAdapterTwo;
    private CallCentreAdapterThree callCentreAdapterThree;
    private CallCentreAdapterFo callCentreAdapterFo;
    private CallCenterAdapterFaif callCenterAdapterFaif;
    private ArrayList<CallCenterModel> callCenterModel = new ArrayList<>();
    private ArrayList<CallCenterModelTwo> callCenterModelTwos = new ArrayList<>();
    private ArrayList<CallCenterModelThree> callCenterModelThrees = new ArrayList<>();
    private ArrayList<CallCentreModelFo> callCentreModelFos = new ArrayList<>();
    private ArrayList<CallCenterModelFaif> callCenterModelFaifs = new ArrayList<>();

    private TextView sda_kr_on_result;
    private ExpandableCardView profil,profiltwo,profilthree,profilfo,profilfaif;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_centre);

        sda_kr_on_result = findViewById(R.id.sda_kr_on_result);
        profil = findViewById(R.id.profil);
        profiltwo = findViewById(R.id.profiltwo);
        profilthree = findViewById(R.id.profilthree);
        profilfo = findViewById(R.id.profilfo);
        profilfaif = findViewById(R.id.profilfaif);

        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            sda_kr_on_result.setText(getResources().getText(R.string.callcentreKg));
            profil.setTitle(getResources().getText(R.string.extronyecallKg).toString());
            profiltwo.setTitle(getResources().getText(R.string.mvdkrKg).toString());
            profilthree.setTitle(getResources().getText(R.string.sppravichnyiKg).toString());
            profilfo.setTitle(getResources().getText(R.string.gujbddbishkekKg).toString());
            profilfaif.setTitle(getResources().getText(R.string.bashkatelefondorKg).toString());


        }

        RecyclerView recyclerView = findViewById(R.id.row_callcentre);
        RecyclerView recyclerViewtwo = findViewById(R.id.row_callcentretwo);
        RecyclerView recyclerViewthree = findViewById(R.id.row_callcentrethree);
        RecyclerView recyclerViewfo = findViewById(R.id.row_callcentrefo);
        RecyclerView recyclerViewfaif = findViewById(R.id.row_callcentrefaif);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewtwo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewthree.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewfo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewfaif.setLayoutManager(new LinearLayoutManager(this));
        callCentreAdapter = new CallCentreAdapter(this, callCenterModel);
        callCenterAdapterTwo = new CallCenterAdapterTwo(this, callCenterModelTwos);
        callCentreAdapterThree = new CallCentreAdapterThree(this, callCenterModelThrees);
        callCentreAdapterFo = new CallCentreAdapterFo(this, callCentreModelFos);
        callCenterAdapterFaif = new CallCenterAdapterFaif(this, callCenterModelFaifs);
        recyclerView.setAdapter(callCentreAdapter);
        recyclerViewtwo.setAdapter(callCenterAdapterTwo);
        recyclerViewthree.setAdapter(callCentreAdapterThree);
        recyclerViewfo.setAdapter(callCentreAdapterFo);
        recyclerViewfaif.setAdapter(callCenterAdapterFaif);

        callCentreAdapter.setOnItemClickListener(position -> {
            String uri = "tel:" + callCenterModel.get(position).getNumber();
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });
        callCenterAdapterTwo.setOnItemClickListener(position -> {
            String uri = "tel:" + callCenterModelTwos.get(position).getNumber();
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });

        callCentreAdapterThree.setOnItemClickListener(position -> {
            String uri = "tel:" + callCenterModelThrees.get(position).getNumber();
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });
        callCentreAdapterFo.setOnItemClickListener(position -> {
            String uri = "tel:" + callCentreModelFos.get(position).getNumber();
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });
        callCenterAdapterFaif.setOnItemClickListener(position -> {
            String uri = "tel:" + callCenterModelFaifs.get(position).getNumber();
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
                return;
            }
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(uri)));
        });

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firebaseFirestore.collection(CALLCENRE);

        collectionReference.whereLessThan(ID, 11).get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCenterModel.clear();
            callCenterModel.addAll(queryDocumentSnapshots.toObjects(CallCenterModel.class));
            callCenterModel.sort(Comparator.comparing(CallCenterModel::getId));
            callCentreAdapter.notifyDataSetChanged();
        });
        collectionReference.whereGreaterThan(ID, 10).whereLessThan(ID, 21).get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCenterModelTwos.clear();
            callCenterModelTwos.addAll(queryDocumentSnapshots.toObjects(CallCenterModelTwo.class));
            callCenterModelTwos.sort(Comparator.comparing(CallCenterModelTwo::getId));
            callCenterAdapterTwo.notifyDataSetChanged();
        });
        collectionReference.whereGreaterThan(ID, 20).whereLessThan(ID, 40).get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCenterModelThrees.clear();
            callCenterModelThrees.addAll(queryDocumentSnapshots.toObjects(CallCenterModelThree.class));
            callCenterModelThrees.sort(Comparator.comparing(CallCenterModelThree::getId));
            callCentreAdapterThree.notifyDataSetChanged();
        });
        collectionReference.whereGreaterThan(ID,39).whereLessThan(ID,48).get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCentreModelFos.clear();
            callCentreModelFos.addAll(queryDocumentSnapshots.toObjects(CallCentreModelFo.class));
            callCentreModelFos.sort(Comparator.comparing(CallCentreModelFo::getId));
            callCentreAdapterFo.notifyDataSetChanged();
        });
        collectionReference.whereGreaterThan(ID,47).whereLessThan(ID,55).get().addOnSuccessListener(queryDocumentSnapshots -> {
            callCenterModelFaifs.clear();
            callCenterModelFaifs.addAll(queryDocumentSnapshots.toObjects(CallCenterModelFaif.class));
            callCenterModelFaifs.sort(Comparator.comparing(CallCenterModelFaif::getId));
            callCenterAdapterFaif.notifyDataSetChanged();
        });
    }

    public void onClick(View view) {
        finish();
    }
}