package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class product extends AppCompatActivity {
    private ListView lv;
    private CustomAdapter customeAdapter;
    private ArrayList<ImageModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.pepper_spray, R.drawable.chilly_spray,
            R.drawable.defense_alarm,R.drawable.mask};
    private String[] myImageNameList = new String[]{"Pepper spray", "Chilly Spray",
            "Defense Alarm","Anti-pollution mask"};
    // private String[] product_url={"https://www.amazon.in/Knockout-Punch-Strong-Pepper-Safety/dp/B00YMY3PX4/ref=sr_1_1?crid=37YOAJZYAVC98&keywords=women+safety+products&qid=1570514269&sprefix=women+safety%2Caps%2C506&sr=8-1","https://www.amazon.in/Impower-Defence-Chilli-Spray-Safety/dp/B075KMTP2D/ref=sr_1_2?crid=37YOAJZYAVC98&keywords=women+safety+products&qid=1570514269&sprefix=women+safety%2Caps%2C506&sr=8-2","https://www.amazon.in/3M-Anti-Pollution-Dust-Mask/dp/B017D0LGYS/ref=sr_1_6?crid=37YOAJZYAVC98&keywords=women+safety+products&qid=1570514269&sprefix=women+safety%2Caps%2C506&sr=8-6","https://www.amazon.in/Mobaccs-Emergency-Keychain-Equipment-Valentine/dp/B07GNTGDWH/ref=sr_1_8?crid=37YOAJZYAVC98&keywords=women+safety+products&qid=1570514269&sprefix=women+safety%2Caps%2C506&sr=8-8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        lv = (ListView) findViewById(R.id.list);

        imageModelArrayList = populateList();
        Log.d("hjhjh",imageModelArrayList.size()+"");
        customeAdapter = new CustomAdapter(this,imageModelArrayList);
        lv.setAdapter(customeAdapter);

    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;

    }

}
