package com.example.manipalh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class REPORTGENERATION extends AppCompatActivity
{
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    static int count=0;
    private RadioGroup radioSexGroup;
     RadioButton anonymous1,name1;
    private Button btnDisplay;
    int selectedValueId;
    EditText text1;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportgeneration);
        anonymous1= (RadioButton) findViewById(R.id.anonymous);
        name1=(RadioButton)findViewById(R.id.name);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioname);
        btnDisplay = (Button) findViewById(R.id.sumbit);
        text1=(EditText)findViewById(R.id.text);
        show=(Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(REPORTGENERATION.this,VIEWREPORT.class);
                startActivity(i);
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                final String str;
                selectedValueId = radioSexGroup.getCheckedRadioButtonId();
                //checking the id of the selected radio
                if(selectedValueId == anonymous1.getId())
                {
                    str="anonymous:-";
                }
                else if(selectedValueId==name1.getId())
                {
                     str="name:-";
                }
                else
                {
                    str=" ";
                }
                String text2=text1.getText().toString();
                VREPORT vreport=new VREPORT(text2);
                //String s=str+text2;
                final DocumentReference noteRef=db.collection("REPORT").document();
                        noteRef.set(vreport).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(REPORTGENERATION.this, "SUccessful", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(REPORTGENERATION.this, "Unsuccesful", Toast.LENGTH_SHORT).show();
                    }
                });
                Intent i=new Intent(REPORTGENERATION.this,VIEWREPORT.class);
                startActivity(i);
            }
        });
    }
}
