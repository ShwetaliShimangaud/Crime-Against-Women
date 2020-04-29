package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register2 extends AppCompatActivity {

    Button verify,register;
    EditText link,phno1,phno2,acard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        register=findViewById(R.id.register);

        phno1=findViewById(R.id.phno1);
        phno2=findViewById(R.id.phno2);
        acard=findViewById(R.id.acard);

        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("user");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);

                String phno11 = phno1.getText().toString();
                String phno21 = phno2.getText().toString();
                String acard1 = acard.getText().toString();
                Double lat=12.9599361;
                Double lon=77.643658;

                mDatabase.child(Id).child("phno11").setValue(phno11);
                mDatabase.child(Id).child("phno12").setValue(phno21);
                mDatabase.child(Id).child("adhar").setValue(acard1);
                mDatabase.child(Id).child("lat").setValue(lat);
                mDatabase.child(Id).child("lon").setValue(lon);
                Bundle b=getIntent().getExtras();
                String username=b.getString("name");
                Intent i =new Intent(Register2.this,buttonpage.class);
                if (true) {
                    //Toast.makeText(Register2.this,"Adhar card verification successful",Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
                else
                {
                    //Toast.makeText(Register2.this,"Aadhar card verification failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
