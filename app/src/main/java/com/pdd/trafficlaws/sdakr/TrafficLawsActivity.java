package com.pdd.trafficlaws.sdakr;

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

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.pdd.trafficlaws.R;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapter;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterFif;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterFo;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterSeven;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterSix;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterThree;
import com.pdd.trafficlaws.sdakr.adapter.MySdaKrAdapterTwo;
import com.pdd.trafficlaws.sdakr.model.ModelSdaKR;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrFifActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrFoActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrSevenActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrSixActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrThreeActivity;
import com.pdd.trafficlaws.sdakr.onresultActivity.OnResultSdaKrTwoActivity;

import java.util.ArrayList;
import java.util.Comparator;

public class TrafficLawsActivity extends AppCompatActivity {
    private String TAG = "tag";
    private String SDAKR = "SdaKr";
    private FirebaseFirestore firebaseFirestore;
    private CollectionReference collectionReference;
    private ArrayList<ModelSdaKR> modelSdaKrListlist = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrTwoListlist = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrThrees = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrFoArrayList = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrFifArrayList = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrSixArrayList = new ArrayList<>();
    private ArrayList<ModelSdaKR> modelSdaKrSevenArrayList = new ArrayList<>();
    private TextView shtraf;
    private ExpandableCardView pdd_kr,pdd_krone,pdd_krtwo,pdd_krthree,pdd_krfo,pdd_krfif,pdd_krsix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_laws);

        shtraf = findViewById(R.id.sda_kr_on_result);
        pdd_kr = findViewById(R.id.pdd_kr);
        pdd_krone = findViewById(R.id.pdd_krone);
        pdd_krtwo = findViewById(R.id.pdd_krtwo);
        pdd_krthree = findViewById(R.id.pdd_krthree);
        pdd_krfo = findViewById(R.id.pdd_krfo);
        pdd_krfif = findViewById(R.id.pdd_krfif);
        pdd_krsix = findViewById(R.id.pdd_krsix);



        if (getSharedPreferences("settings", MODE_PRIVATE).getBoolean("ky", false)){
            SDAKR = "SdaKrKg";
            shtraf.setText(getResources().getText(R.string.shtrafyKg));
            pdd_kr.setTitle(getResources().getText(R.string.pdd_krKg).toString());
            pdd_krone.setTitle(getResources().getText(R.string.pdd_kroneKg).toString());
            pdd_krtwo.setTitle(getResources().getText(R.string.pdd_krtwoKg).toString());
            pdd_krthree.setTitle(getResources().getText(R.string.pdd_krthreeKg).toString());
            pdd_krfo.setTitle(getResources().getText(R.string.pdd_krfoKg).toString());
            pdd_krfif.setTitle(getResources().getText(R.string.pdd_krfifKg).toString());
            pdd_krsix.setTitle(getResources().getText(R.string.pdd_krsixKg).toString());
        } else {
            SDAKR = "SdaKr";
        }

        firebaseFirestore = FirebaseFirestore.getInstance();
        collectionReference = firebaseFirestore.collection(SDAKR);

        one();
        two();
        three();
        four();
        five();
        six();
        seven();


    }
    
    private void one() {
        RecyclerView recyclerView = findViewById(R.id.sda_kr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapter mySdaKrAdapter = new MySdaKrAdapter(this, modelSdaKrListlist);
        recyclerView.setAdapter(mySdaKrAdapter);

        mySdaKrAdapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrActivity.class);
            intent.putExtra("SdaKr", modelSdaKrListlist.get(position));
            startActivity(intent);
        });
        collectionReference.whereLessThan("order", 5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
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
    }
//collectionReference.whereLessThan("order", 5).get().addOnSuccessListener
    private void two() {
        RecyclerView recyclerViewtwo = findViewById(R.id.sda_kr2);
        recyclerViewtwo.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterTwo mySdaKrAdapterTwo = new MySdaKrAdapterTwo(this, modelSdaKrTwoListlist);
        recyclerViewtwo.setAdapter(mySdaKrAdapterTwo);
        mySdaKrAdapterTwo.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrTwoActivity.class);
            intent.putExtra("SdaKr",modelSdaKrTwoListlist.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",4).whereLessThan("order", 9).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrTwoListlist.clear();
                modelSdaKrTwoListlist.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrTwoListlist.sort(Comparator.comparing(ModelSdaKR::getOrder));
            }
        });

    }
    private void three(){
        RecyclerView recyclerViewthree = findViewById(R.id.sda_kr3);
        recyclerViewthree.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterThree mySdaKrAdapterThree = new MySdaKrAdapterThree(this, modelSdaKrThrees);
        recyclerViewthree.setAdapter(mySdaKrAdapterThree);
        mySdaKrAdapterThree.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrThreeActivity.class);
            intent.putExtra("SdaKr",modelSdaKrThrees.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",8).whereLessThan("order",13).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrThrees.clear();
                modelSdaKrThrees.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrThrees.sort(Comparator.comparing(ModelSdaKR::getOrder));
                Log.e(TAG, modelSdaKrThrees.toString() );
            }
        });

    }
    private void four (){
        RecyclerView recyclerViewFo = findViewById(R.id.sda_kr4);
        recyclerViewFo.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterFo mySdaKrAdapterFo = new MySdaKrAdapterFo(this,modelSdaKrFoArrayList);
        recyclerViewFo.setAdapter(mySdaKrAdapterFo);
        mySdaKrAdapterFo.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrFoActivity.class);
            intent.putExtra("SdaKr",modelSdaKrFoArrayList.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",12).whereLessThan("order",17).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrFoArrayList.clear();
                modelSdaKrFoArrayList.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrFoArrayList.sort(Comparator.comparing(ModelSdaKR::getOrder));
            }
        });
    }
    private void five (){
        RecyclerView recyclerViewFif = findViewById(R.id.sda_kr5);
        recyclerViewFif.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterFif mySdaKrAdapterFif = new MySdaKrAdapterFif(this,modelSdaKrFifArrayList);
        recyclerViewFif.setAdapter(mySdaKrAdapterFif);
        mySdaKrAdapterFif.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrFifActivity.class);
            intent.putExtra("SdaKr",modelSdaKrFifArrayList.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",16).whereLessThan("order",21).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrFifArrayList.clear();
                modelSdaKrFifArrayList.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrFifArrayList.sort(Comparator.comparing(ModelSdaKR::getOrder));
            }
        });

    }
    private void six () {
        RecyclerView recyclerViewSix = findViewById(R.id.sda_kr6);
        recyclerViewSix.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterSix mySdaKrAdapterSix = new MySdaKrAdapterSix(this,modelSdaKrSixArrayList);
        recyclerViewSix.setAdapter(mySdaKrAdapterSix);
        mySdaKrAdapterSix.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrSixActivity.class);
            intent.putExtra("SdaKr",modelSdaKrSixArrayList.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",20).whereLessThan("order",25).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrSixArrayList.clear();
                modelSdaKrSixArrayList.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrSixArrayList.sort(Comparator.comparing(ModelSdaKR::getOrder));
            }
        });

    }
    private void seven (){
        RecyclerView recyclerViewSeven = findViewById(R.id.sda_kr7);
        recyclerViewSeven.setLayoutManager(new LinearLayoutManager(this));
        MySdaKrAdapterSeven mySdaKrAdapterSeven = new MySdaKrAdapterSeven(this,modelSdaKrSevenArrayList);
        recyclerViewSeven.setAdapter(mySdaKrAdapterSeven);
        mySdaKrAdapterSeven.setOnItemClickListener(position -> {
            Intent intent = new Intent(TrafficLawsActivity.this, OnResultSdaKrSevenActivity.class);
            intent.putExtra("SdaKr",modelSdaKrSevenArrayList.get(position));
            startActivity(intent);
        });
        collectionReference.whereGreaterThan("order",24).whereLessThan("order",28).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                modelSdaKrSevenArrayList.clear();
                modelSdaKrSevenArrayList.addAll(queryDocumentSnapshots.toObjects(ModelSdaKR.class));
                modelSdaKrSevenArrayList.sort(Comparator.comparing(ModelSdaKR::getOrder));
            }
        });
    }

    public void onClick(View view) {
        onBackPressed();
    }
}
