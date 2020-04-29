package com.example.manipalh;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//import com.firebase.geofire.GeoQueryDataEventListener;
//import android.support.v7.app.AppCompatActivity;

public class buttonpage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<String> latitude = new ArrayList<>();
    ArrayList<String> longitude = new ArrayList<>();
    ArrayList<String> phoneno = new ArrayList<>();
    public static ArrayList<String> passlat = new ArrayList<>();
    public static ArrayList<String> passlon = new ArrayList<>();
    ArrayList<String> aid = new ArrayList<>();
    ArrayList<String> savegirl = new ArrayList<>();
    public static ArrayList<String> username = new ArrayList<>();
    public static ArrayList<String> fusername = new ArrayList<>();
    static int var = 0;
    static int var1 = 0;
    public static ArrayList<String> latitudep = new ArrayList<>();
    public static ArrayList<String> longitudep = new ArrayList<>();
    public static ArrayList<String> phoneno_pass = new ArrayList<>();
    public static ArrayList<String> phonenop = new ArrayList<>();
    public static ArrayList<String> aidp = new ArrayList<>();
    static ArrayList<String> fusename = new ArrayList<>();
    static ArrayList<String> usename = new ArrayList<>();
    //static ArrayList<String>fusename=new ArrayList<>();
    ArrayList<String> zipcodelist = new ArrayList<>();
    FirebaseFirestore db;
    String passid = "";
    Button b1, b2, b3;
    ProgressDialog p;
    private SensorManager sm;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("police");
    private float acelVal;
    private float acelLast;
    private float shake;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    static int flag = 0;
    double mylatitude, mylongitude;
    double mylatitudep, mylongitudep;
    LocationManager locationManager;
    LocationListener locationListener;
    ArrayList<String> call=new ArrayList<>();
    PolygonOptions polygonOptions;
    Polygon polygon;

    public void StartChat(View view) {
        startActivity(new Intent(buttonpage.this, Users.class));
    }


    //   private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;







    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(buttonpage.this,"Permission granted",Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 100, locationListener);
                    }

                }
            }

                } else {
                   // Toast.makeText(getApplicationContext(),"SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }

            }





  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && requestCode == RESULT_OK) {
            Uri file = data.getData();
        }
    }*/
       /* public void Trackme() {
            final ArrayList<Double> lat = new ArrayList<>();
            final ArrayList<Double> lon = new ArrayList<>();

            final String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            LatLng one=new LatLng(18.9575,77.1508);
            LatLng two=new LatLng(18.0760,77.8777);
            LatLng three=new LatLng(17.2046,77.3463);

            polygonOptions.add(one);
            polygonOptions.add(three);
            polygonOptions.add(two);


            final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   Double current_lat = Double.parseDouble(dataSnapshot.child(Id).child("lat").getValue().toString());
                   Double current_lon=Double.parseDouble(dataSnapshot.child(Id).child("lon").getValue().toString());

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }*/



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        //final DatabaseReference mdatabase1=FirebaseDatabase.getInstance().getReference("req");
        final DatabaseReference ref3 = FirebaseDatabase.getInstance().getReference("req");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttonpage);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        polygonOptions=new PolygonOptions();
        b3=findViewById(R.id.button6);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(buttonpage.this,TrackMe.class));
            }
        });

      /*  sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal=SensorManager.GRAVITY_EARTH;
        acelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;*/


        DrawerLayout mDrawerLayout;
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getHeaderView(R.layout.header);
        final ImageView imgvw = (ImageView) navigationView.findViewById(R.id.imageView2);

        navigationView.setNavigationItemSelectedListener(this);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);

                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");


                ref.child(Id).child("lon").setValue(location.getLongitude());
                ref.child(Id).child("lat").setValue(location.getLatitude());


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }

        };

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // ask for permission

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


        } else {

            // we have permission!

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 100, locationListener);

        }


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.SEND_SMS, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                       // sendSMSMessage(phoneno);
                    }
                }
            }
        }







        // If device is running SDK < 23





        p = new ProgressDialog(buttonpage.this);
        p.setTitle("Loading");
        p.setMessage("Please_Wait");
        p.setCanceledOnTouchOutside(true);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {


            int flag1 = 0;

            @Override
            public void onClick(View view) {


                p.show();
                DatabaseReference ref4 = FirebaseDatabase.getInstance().getReference("req");

                ref4.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                                Settings.Secure.ANDROID_ID);
                        //  Log.d("Id",Id);
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            savegirl.add(ds.child("help").getValue().toString());


                        }
                        String[] str = new String[savegirl.size()];
                        for (int i = 0; i < savegirl.size(); i++) {
                            str[i] = savegirl.get(i);
                        }
                        //  Log.d("Size11",""+str.length);
                        for (int i = 0; i < str.length; i++) {
                            String[] str1 = str[i].split(" ");
                            for (int j = 0; j < str1.length; j++) {
                                System.out.println(str1[j]);
                                if (str1[j].equals(Id)) {
                                    passid = str1[0];
                                    flag1 = 1;
                                    //Log.d("Idpass",passid);
                                    Intent i2 = new Intent(buttonpage.this, MapsActivity2.class);
                                    i2.putExtra("Id", passid);
                                    startActivity(i2);


                                }
                            }

                        }
                        //  Log.d("flag1",""+flag1);


                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
        //  Log.d("id outside",passid);
        //b3=findViewById(R.id.button3);
        b1 = findViewById(R.id.button);
        db = FirebaseFirestore.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference ref0=FirebaseDatabase.getInstance().getReference("total_count");


                ref0.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(var==0) {
                            // var++;
                            String str = dataSnapshot.child("total_c").getValue().toString();
                            int x = Integer.parseInt(str);
                            x++;
                            DatabaseReference ref0 = FirebaseDatabase.getInstance().getReference("total_count");
                            ref0.child("total_c").setValue(x);
                            var = var + 1;
                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                //for arreawise
                final DatabaseReference refu=FirebaseDatabase.getInstance().getReference("user");
                refu.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(var1==0){
                            var1 = var1 + 1;
                            String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                                    Settings.Secure.ANDROID_ID);
                            mylatitudep = Double.parseDouble(dataSnapshot.child(Id).child("lat").getValue().toString());
                            mylongitudep = Double.parseDouble(dataSnapshot.child(Id).child("lon").getValue().toString());
                        }
                        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                        List<Address> addresses = null;
                        try {
                            addresses = geocoder.getFromLocation(mylatitudep, mylongitudep, 1);
                            Log.d("sizeofadd",""+addresses.size());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Log.d("mylatit3434",""+mylatitudep);

                        //      String postalCode = addresses.get(0).getPostalCode();
                        // Log.d("zipcode", addresses.get(0).getPostalCode());

                        DatabaseReference refp=FirebaseDatabase.getInstance().getReference("police");
                        refp.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    zipcodelist.add(ds.child("lat").getValue().toString());



                                }
                                int[] arr = new int[latitude.size()];
                                double min = -99;
                                int index;
                                for (int i = 0; i <= (latitude.size() - 1); i++) {
                                    float dis = calculateD(latitude.get(i), longitude.get(i));
                                    if (dis < min) {



                                    } else {


                                    }
                                }


                            }






                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });






                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });







                //final DatabaseReference ref1=FirebaseDatabase.getInstance().getReference("");

                DatabaseReference ref =FirebaseDatabase.getInstance().getReference("user");


                ref.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                                Settings.Secure.ANDROID_ID);
                        mylatitude=Double.parseDouble(dataSnapshot.child(Id).child("lat").getValue().toString());
                        mylongitude=Double.parseDouble(dataSnapshot.child(Id).child("lon").getValue().toString());


                        for(DataSnapshot ds :dataSnapshot.getChildren()){
                            latitude.add(ds.child("lat").getValue().toString());
                            longitude.add(ds.child("lon").getValue().toString());
                            phoneno.add(ds.child("phno").getValue().toString());
                            aid.add(ds.child("id").getValue().toString());
                            usename.add(ds.child("username").getValue().toString());

                        }

                        ref3.child(Id).child("lat").setValue(mylatitude);
                        ref3.child(Id).child("long").setValue(mylongitude);
                        String str=Id;
                        str+=" ";
                        int[] arr = new int[latitude.size()];


                        for(int i=0;i<=(latitude.size()-1);i++)
                        {
                            float dis= calculateD(latitude.get(i),longitude.get(i));
                            if(dis<=200000 && dis!=0)
                            {
                                Log.d("distance",""+calculateD(latitude.get(i),longitude.get(i)));
                                arr[i]=1;

                                //sdfs343344ds
                            }else
                            {
                                arr[i]=0;


                            }



                        }

                        for(int i=0;i<latitude.size();i++)
                        {
                            if(arr[i]==1)
                            {
                                String s=latitude.get(i);
                                String s1=longitude.get(i);
                                fusename.add(usename.get(i));
                                passlat.add(s);
                                passlon.add(s1);
                                call.add(phoneno.get(i));
                                str+=aid.get(i);
                                ref3.child(Id).child("help").setValue(str);
                                str+=" ";
                                for(int j=0;j<fusename.size();j++)
                                    Log.d("name", fusename.get(j));

                            }


                        }
                        for(int i=0;i<phoneno.size();i++)
                        {
                            Log.d("phno",""+phoneno);
                        }




                        if(flag==0) {

                            //sendSMSMessage(call);
                            //
                            // Log.d("Size ",""+passlat.size());
                            //ref3.child(Id).removeValue();
                            p.dismiss();
                            startI();
                            flag++;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }


        });
    }


        private void count(String req) {

        final DatabaseReference ref9 =FirebaseDatabase.getInstance().getReference("comp");
        int x=Integer.parseInt(req);
        x++;
        String str2=String.valueOf(x);
        ref9.child("requ").setValue(str2);
    }

    public float calculateD(String a, String b) {
        Location locationA=new Location("location a");


        locationA.setLongitude(mylongitude);
        locationA.setLatitude(mylatitude);

        Location locationB=new Location("location b");

        locationB.setLatitude(Double.parseDouble(a));
        locationB.setLongitude(Double.parseDouble(b));

        float d=locationA.distanceTo(locationB);
        return d/1000;
    }
    //@RequiresApi(api = Build.VERSION_CODES.M)

    void startI()
    {

        Intent i=new Intent(buttonpage.this,calling.class);
       // Log.d("passLatitude size",""+passlat.size());
       // i.putExtra("lat",passlat);
        i.putExtra("contact_no",call);
        Log.d("size lat",""+passlat.size());
       // i.putExtra("long",passlon);
        startActivity(i);

    }
    void startI1()
    {
        Intent i=new Intent(buttonpage.this,MapsActivity2.class);
        i.putExtra("ID",passid);
        startActivity(i);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        int id= menuItem.getItemId();
        if(id==R.id.law)
        {
            Intent i=new Intent(this,LAWS.class);
            startActivity(i);
        }
        else if(id==R.id.faq)
        {
            Intent i=new Intent(this,FAQ.class);
            startActivity(i);
        }
        else if(id==R.id.exp)
        {
            Intent i=new Intent(this,REPORTGENERATION.class);
            startActivity(i);
        }
        else if(id==R.id.profile)
        {
            Intent i=new Intent(this,PROFILE.class);
            startActivity(i);
        }
        else if(id==R.id.pc)
        {
            Intent i=new Intent(this,LAUNCHCOMPLAINT.class);
            startActivity(i);
        }
        else if(id==R.id.piechart)
        {
            Intent i=new Intent(buttonpage.this,piechart.class);
            startActivity(i);
        }
        else if(id==R.id.product)
        {
            Intent i=new Intent(buttonpage.this,product.class);
            startActivity(i);
        }else
        {

            Intent i=new Intent(buttonpage.this,buttonpage.class);
            startActivity(i);
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {

    }

    //sensor code
    private final SensorEventListener sensorListener= new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];

            acelLast=acelVal;
            acelVal=(float) Math.sqrt((double)(x*x + y*y + z*z));
            float delta=acelVal-acelLast;
            shake =shake*0.9f +delta;

            if(shake>12)
            {
                final DatabaseReference ref3=FirebaseDatabase.getInstance().getReference("req");
                DatabaseReference ref =FirebaseDatabase.getInstance().getReference("user");
                final DatabaseReference ref1=FirebaseDatabase.getInstance().getReference("user");

                ref.addValueEventListener(new ValueEventListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                                Settings.Secure.ANDROID_ID);
                        mylatitude=Double.parseDouble(dataSnapshot.child(Id).child("lat").getValue().toString());
                        mylongitude=Double.parseDouble(dataSnapshot.child(Id).child("lon").getValue().toString());


                        for(DataSnapshot ds :dataSnapshot.getChildren()){
                            latitude.add(ds.child("lat").getValue().toString());
                            longitude.add(ds.child("lon").getValue().toString());
                            phoneno.add(ds.child("phno").getValue().toString());
                            aid.add(ds.child("id").getValue().toString());
                        }
                        ref3.child(Id).child("lat").setValue(mylatitude);
                        ref3.child(Id).child("long").setValue(mylongitude);
                        String str=Id;
                        str+=" ";
                        int[] arr = new int[latitude.size()];


                        for(int i=0;i<=(latitude.size()-1);i++)
                        {
                            float dis= calculateD(latitude.get(i),longitude.get(i));
                            if(dis<=2000000000 && dis!=0)
                            {
                               // Log.d("distance",""+calculateD(latitude.get(i),longitude.get(i)));
                                arr[i]=1;


                            }else
                            {
                                arr[i]=0;


                            }



                        }
                        ArrayList<String> call=new ArrayList<>();
                        for(int i=0;i<latitude.size();i++)
                        {
                            if(arr[i]==1)
                            {
                                String s=latitude.get(i);
                                String s1=longitude.get(i);

                                passlat.add(s);
                                passlon.add(s1);
                                call.add(phoneno.get(i));
                                str+=aid.get(i);
                                ref3.child(Id).child("help").setValue(str);
                                str+=" ";

                            }


                        }




                        if(flag==0) {

                            //sendSMSMessage(call);
                          //  Log.d("Size ",""+passlat.size());
                            ref3.child(Id).removeValue();
                            startI();
                            flag++;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    public void getSpeechInput(View view) {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //intent.putExtra()
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,10);
        }else{
            Toast.makeText(this,"your device dont support input",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case  10:
                if (resultCode==RESULT_OK&&data!=null){
                    ArrayList<String>result =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //txvResult.setText(result.get(0));
                    String a=result.get(0);
                    Toast.makeText(this,a,Toast.LENGTH_SHORT).show();

                    //txvResult.setText(a);
                    if(a.equals("danger")){
                       Intent d=new Intent(buttonpage.this,MapsActivity.class);
                       startActivity(d);
                    }
                    if(a.equals("products"))
                    {
                        Intent d=new Intent(buttonpage.this,product.class);
                        startActivity(d);
                    }
                    if(a.equals("register"))
                    {
                        Intent r=new Intent(buttonpage.this,Register1.class);
                    startActivity(r);
                    }

                }
        }
    }

}
