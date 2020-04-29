package com.example.manipalh;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class calling extends AppCompatActivity {
    EditText phne;
    Button call;
    Intent intent;
    int p=0;
    TelephonyManager telephonyManager;
    call_listener call_listener;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    ArrayList<String> contact_no=new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    protected String sendSMSMessage(ArrayList<String> phoneno) {
        //String phoneNo[]={"7020666746","9021611283","9637410362","8237124926"};

        String message = "I am in danger I need help";


        /*try {
            SmsManager smsManager = SmsManager.getDefault();
            for (int i = 0; i < phoneno.size(); i++) {
                smsManager.getSmsManagerForSubscriptionId(6).sendTextMessage(phoneno.get(i), null, message, null, null);
            }
            Toast.makeText(getApplicationContext(),
                    "Your sms has successfully sent!",
                    Toast.LENGTH_LONG).show();

            Log.i("Dual_sim_app", "Your sms has successfully sent!");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS failed, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
            Log.i("Dual_sim_app", "SMS faild, please try again later!");
        }*/






        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP_MR1)
            return"Not supported";
        StringBuilder sb = new StringBuilder();
        SubscriptionManager sm = (SubscriptionManager) getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE);
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            sb.append("\r\nSlots ")
                    .append("   TelephonyManager getPhoneCount: "+tm.getPhoneCount());
        }

        if(

                ActivityCompat.checkSelfPermission(calling.this,Manifest.permission.READ_PHONE_STATE) !=PackageManager.PERMISSION_GRANTED)

        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
        }
        sb.append("\r\nSlots ")
                .

                        append("   SubscriptionManager getActiveSubscriptionInfoCount: "+sm.getActiveSubscriptionInfoCount())
                .

                        append("   max: "+sm.getActiveSubscriptionInfoCountMax())
                .

                        append("\r\n");

        List<SubscriptionInfo> subscriptions = sm.getActiveSubscriptionInfoList();
        if(subscriptions !=null)

        {
            for (SubscriptionInfo si : subscriptions) {
                sb.append("SIM ")
                        .append("   slot: " + si.getSimSlotIndex())
                        .append("   id: " + si.getSubscriptionId())
                        .append("   iso: " + si.getCountryIso())
                        .append("   Mcc: " + si.getMcc())
                        .append("   Mnc: " + si.getMnc())
                        .append("   CarrierName: " + si.getCarrierName()).append(si.getDataRoaming() == SubscriptionManager.DATA_ROAMING_ENABLE ? " R" : "")
                        .append("\r\n");
            }
        }


// outputs
        // Slots    TelephonyManager getPhoneCount: 2
        // Slots    SubscriptionManager getActiveSubscriptionInfoCount: 2   max: 2
        // SIM    slot: 0   id: 6   iso: ua   Mcc: 255   Mnc: 1   CarrierName: Vodafone UA | MTS UKR
        // SIM    slot: 1   id: 1   iso: ua   Mcc: 255   Mnc: 6   CarrierName: life:)

        // send sms in dual sim mode


        // send sms
        try

        {
            SmsManager smsManager = SmsManager.getDefault();
            for (int i = 0; i < phoneno.size(); i++) {
                smsManager.getSmsManagerForSubscriptionId(6).sendTextMessage(phoneno.get(i), null, message, null, null);
            }
            Toast.makeText(getApplicationContext(),
                    "Your sms has successfully sent!",
                    Toast.LENGTH_LONG).show();
            Log.i("Dual_sim_app", "Your sms has successfully sent!");
        } catch(
                Exception e)

        {
            Toast.makeText(getApplicationContext(),
                    "SMS failed, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
            Log.i("Dual_sim_app", "SMS faild, please try again later!");
        }
        Call(contact_no);
        return null;
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (permissions[0].equalsIgnoreCase(Manifest.permission.CALL_PHONE) && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED) {
            Log.i("Permission granted", permissions[0]);
            sendSMSMessage(contact_no);


        } else {
           // Log.i("Permission denied", phne.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        Bundle b=getIntent().getExtras();
         contact_no=b.getStringArrayList("contact_no");
         //contact_no.add("7721882376");
        //contact_no.add("9834992254");
        //contact_no.add("9422359588");
        call_listener = new call_listener();
        telephonyManager.listen(call_listener, PhoneStateListener.LISTEN_CALL_STATE);
        check_for_call_permission();


    }

    public boolean validate(EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return true;
        }
        text.setError("Enter valid phone no");
        return false;

    }


    public void check_for_call_permission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
            sendSMSMessage(contact_no);



        }
    }

    public void Call(ArrayList<String> contact_no){
        //String phone_no = phne.getText().toString().trim();
        int i=0;
        intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + contact_no.get(p)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(intent);
                p++;
            }
        } else {
            Toast.makeText(this, "Call cannot be completed", Toast.LENGTH_LONG).show();
        }


    }


    class call_listener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    Toast.makeText(calling.this, "Ringing", Toast.LENGTH_SHORT).show();

                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Log.i("off hook", incomingNumber);

                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    Log.i("idle", incomingNumber);
                    if (p!=contact_no.size())
                    {
                        Call(contact_no);
                    }
                    else
                    {
                        Toast.makeText(calling.this,"Calling completed",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(calling.this,MapsActivity.class));
                    }
                    break;
                default:
// Must be an error.
                    break;
            }
        }


    }
}
