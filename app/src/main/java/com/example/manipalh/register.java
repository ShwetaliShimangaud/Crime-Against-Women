package com.example.manipalh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class register extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private EditText mail,name,phno,phno1,phno2;
    Button submit,simage,upload;
    String Storage_Path = "All_Image_Uploads/";

    // Root Database Name for Firebase Database.
    String Database_Path = "All_Image_Uploads_Database";
    //ImageView SelectImage;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mail=findViewById(R.id.email);
        name=findViewById(R.id.name);
        phno=findViewById(R.id.ph_no);
        phno1=findViewById(R.id.phno1);
        phno2=findViewById(R.id.phno2);
        submit=findViewById(R.id.yes);
        simage=findViewById(R.id.simage);
        upload=findViewById(R.id.upload);
        //signin=findViewById(R.id.signin);
        storageReference = FirebaseStorage.getInstance().getReference();

        // Assign FirebaseDatabase instance with root database name.


        // Assigning Id to ProgressDialog.
        progressDialog = new ProgressDialog(register.this);


        simage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                // Setting intent type as image to select image from phone storage.
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Please Select Image"), Image_Request_Code);
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadImageFileToFirebaseStorage();
            }
        });
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("user");
        final DatabaseReference ref=FirebaseDatabase.getInstance().getReference("req");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                String name1 = name.getText().toString();
                String emailid = mail.getText().toString();
                String phno1 = phno.getText().toString();
                String phno11 = phno2.getText().toString();
                String phno12 = phno2.getText().toString();
                User user = new User(name1, emailid, phno1, phno11);
               // mDatabase.child(Id).setValue(user);
                mDatabase.child(Id).child("username").setValue(name1);
                mDatabase.child(Id).child("emailid").setValue(emailid);
                mDatabase.child(Id).child("phno").setValue(phno1);
                mDatabase.child(Id).child("phno11").setValue(phno11);
                mDatabase.child(Id).child("phno12").setValue(phno12);
                mDatabase.child(Id).child("lat").setValue(23);
                mDatabase.child(Id).child("lon").setValue(100);
               // mDatabase.child(Id).child("help").setValue("");
                mDatabase.child(Id).child("id").setValue(Id);
               // ref.child(Id).child("help").setValue(Id);
                //final FirebaseDatabase database = FirebaseDatabase.getInstance();
                //DatabaseReference ref = database.getReference("server/saving-data/fireblog");

               // ref.child("location");
                //String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        //Settings.Secure.ANDROID_ID);


                Intent i1=new Intent(register.this,buttonpage.class);
                startActivity(i1);

            }
        });
        /*String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        DatabaseReference ref =FirebaseDatabase.getInstance().getReference(Id);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                //dataSnapshot.child(Id).getValue();
                String email=dataSnapshot.child("name").getValue().toString();
               // Toast toast=Toast.makeText()
                Toast toast = Toast.makeText(getApplicationContext(), email, Toast.LENGTH_SHORT); toast.show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {

                // Getting selected image into Bitmap.
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);

                // Setting up bitmap selected image into ImageView.
                //SelectImage.setImageBitmap(bitmap);

            }
            catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

    // Creating Method to get the selected image file Extension from File Path URI.
    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();

        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        // Returning the file Extension.
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }

    // Creating UploadImageFileToFirebaseStorage method to upload image on storage.
    public void UploadImageFileToFirebaseStorage() {

        // Checking whether FilePathUri Is empty or not.
        if (FilePathUri != null) {

            // Setting progressDialog Title.
            progressDialog.setTitle("Image is Uploading...");

            // Showing progressDialog.
            progressDialog.show();

            // Creating second StorageReference.
            StorageReference storageReference2nd = storageReference.child(Storage_Path + System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));

            // Adding addOnSuccessListener to second StorageReference.
            storageReference2nd.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            String Id = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                                    Settings.Secure.ANDROID_ID);
                            // Getting image name from EditText and store into string variable.
                            // Hiding the progressDialog after done uploading.
                            progressDialog.dismiss();

                            // Showing toast message after done uploading.
                            Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();

                            @SuppressWarnings("VisibleForTests")
                            ImageUploadInfo imageUploadInfo;
                            imageUploadInfo = new ImageUploadInfo(taskSnapshot.getMetadata().getReference().getDownloadUrl().toString(),Id);

                            // Getting image upload ID.
                           // String ImageUploadId = databaseReference.push().getKey();
                        DatabaseReference    databaseReference1= FirebaseDatabase.getInstance().getReference("user");
                            // Adding image upload id s child element into databaseReference.
                            databaseReference1.child(Id).child("ImageUploadId").setValue(imageUploadInfo.imageURL);
                        }
                    })
                    // If something goes wrong .
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {

                            // Hiding the progressDialog.
                            progressDialog.dismiss();

                            // Showing exception erro message.
                            Toast.makeText(register.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    })

                    // On progress change upload time.
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            // Setting progressDialog Title.
                            progressDialog.setTitle("Image is Uploading...");

                        }
                    });
        }
        else {

            Toast.makeText(register.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }
}

