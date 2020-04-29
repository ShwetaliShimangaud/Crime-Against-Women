package com.example.manipalh;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LAWS extends AppCompatActivity
{
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        listView=(ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("Commission of Sati (Prevention) Act, 1987");
        arrayList.add("Criminal Law (Amendment) Act, 1983");
        arrayList.add("Dowry Prohibition Act, 1961");
        arrayList.add("Immoral Traffic (Prevention) Act, 1956");
        arrayList.add("Indecent Representation of Women (Prohibition) Act, 1986");
        arrayList.add("National Commission for Women Act, 1990");
        arrayList.add("Prohibition of Sexual Harassment of Women at the Workplace Bill, 2010");
        arrayList.add(" Protection of Women from Domestic Violence Act,2005");
        arrayList.add("Married Womens Property Act, 1874");
        arrayList.add("Married Womens Property (Extension) Act, 1959");
        arrayList.add("Indian Succession (Amendment) Act, 2002");
        arrayList.add("Indian Succession Act, 1925");
        arrayList.add("Hindu Succession (Amendment) Act, 2005");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
    }
}