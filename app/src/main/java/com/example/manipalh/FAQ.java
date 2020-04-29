package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FAQ extends AppCompatActivity
{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList1=new ArrayList<>();

        arrayList1.add("What is the necessary document for registration?-->Aadhar Card");
        arrayList1.add("Can I register a complaint to police station?-->YES");
        arrayList1.add("How many emergency contacts do I have to add?-->Minimum 1");
        arrayList1.add("Can I generate the report anonymously?-->YES");
        arrayList1.add("Can a user be registered without Aadhar Card verification?-->NO");
        arrayList1.add("Can I update my profile?-->YES,in the navigation bar.");
        arrayList1.add("In how many languages is the app available?-->3(English,Hindi,Marathi");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList1);
        listView.setAdapter(arrayAdapter);



    }
}
