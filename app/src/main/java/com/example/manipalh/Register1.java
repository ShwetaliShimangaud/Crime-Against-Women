package com.example.manipalh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register1 extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private EditText fname,emailid,phno,address;
    Button Submit;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        fname=findViewById(R.id.fname);
        emailid=findViewById(R.id.emailid);
        phno=findViewById(R.id.phno);
        address=findViewById(R.id.address);
        Submit=findViewById(R.id.Submit);
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("user");
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                String name1 = fname.getText().toString();
                String emailid1 = emailid.getText().toString();
                String phno1 = phno.getText().toString();
                String address1 = address.getText().toString();
               // User1 user = new User1(name1,emailid1,phno1,address1);
                mDatabase.child(Id).child("username").setValue(name1);
                mDatabase.child(Id).child("emailid").setValue(emailid1);
                mDatabase.child(Id).child("phno").setValue(phno1);
                mDatabase.child(Id).child("address").setValue(address1);
                mDatabase.child(Id).child("id").setValue(Id);
                Intent i=new Intent(Register1.this,Register2.class);
                i.putExtra("name",name1);
                startActivity(i);
            }
        });


    }
}
