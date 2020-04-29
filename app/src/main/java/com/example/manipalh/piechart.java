package com.example.manipalh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class piechart extends AppCompatActivity {

   // int  rainfall[]={60,40};
  //  String month[]={"Total Compaint","Rescued"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference("total_count");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String str1=dataSnapshot.child("total_c").getValue().toString();
                String str2=dataSnapshot.child("total_r").getValue().toString();
                int  rainfall[]={Integer.parseInt(str1),Integer.parseInt(str2)};
                String month[]={"Total Compaint","Rescued"};
                List<PieEntry> pieEntries=new ArrayList<>();
                //List< > pieData = new ArrayList<>();


                for (int i=0;i<rainfall.length;i++){
                    pieEntries.add(new PieEntry(rainfall[i],month[i]));

                }
                PieDataSet pieDataSet=new PieDataSet(pieEntries,"Ra");
                // pieDataSet.setColor(ColorTemplate.);
                PieData data=new PieData(pieDataSet);
                PieChart chart=(PieChart) findViewById(R.id.chart);
                chart.setData(data);
                chart.invalidate();
                pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);
      //  setupPiechart();
    }
    /*private  void setupPiechart(){
        List<PieEntry> pieEntries=new ArrayList<>();
        //List< > pieData = new ArrayList<>();


        for (int i=0;i<rainfall.length;i++){
            pieEntries.add(new PieEntry(rainfall[i],month[i]));

        }
        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Ra");
        // pieDataSet.setColor(ColorTemplate.);
        PieData data=new PieData(pieDataSet);
        PieChart chart=(PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.invalidate();
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

    }*/
}
