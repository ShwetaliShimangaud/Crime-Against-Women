package com.example.manipalh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PROFILE extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        setContentView(R.layout.activity_profile);
        final TextView name=findViewById(R.id.name);
        final TextView email=findViewById(R.id.email);
        final TextView ph_no=findViewById(R.id.ph_no);
        final TextView phno1=findViewById(R.id.phno1);
        final TextView phno2=findViewById(R.id.phno2);
        final Button yes=findViewById(R.id.yes);
        final Button no=findViewById(R.id.no);

        final DatabaseReference ref= FirebaseDatabase.getInstance().getReference("user");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String dname=dataSnapshot.child(Id).child("username").getValue().toString();
                name.setText(dname);
                String demail=dataSnapshot.child(Id).child("emailid").getValue().toString();
                email.setText(demail);
                String dph_no=dataSnapshot.child(Id).child("phno").getValue().toString();
                ph_no.setText(dph_no);

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(PROFILE.this,Register1.class);
                        startActivity(i);
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i1=new Intent(PROFILE.this,buttonpage.class);
                        startActivity(i1);
                    }
                });






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
