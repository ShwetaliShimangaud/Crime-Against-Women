package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class VIEWREPORT extends AppCompatActivity
{
    RecyclerView recyclerView;
    RecyclerViewAdapter3 recyclerViewAdapter;
    List<VREPORT>userlist3;
    DocumentReference documentReference;
    FirebaseFirestore db2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewreport);
        recyclerView=findViewById(R.id.reportitem);
        userlist3=new ArrayList<>();
        recyclerViewAdapter=new RecyclerViewAdapter3(userlist3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        db2=FirebaseFirestore.getInstance();
        documentReference=db2.collection("REPORT").document();
        db2.collection("REPORT").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for(DocumentChange dc:queryDocumentSnapshots.getDocumentChanges())
                {
                    VREPORT record=dc.getDocument().toObject(VREPORT.class);
                    userlist3.add(record);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    }
