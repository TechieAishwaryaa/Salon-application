package com.example.gajraj;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class mainpage extends AppCompatActivity {

    ViewFlipper f1;
    DatabaseReference data;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        f1=findViewById(R.id.v1);
        auth = FirebaseAuth.getInstance();

        int imgArray[]={R.drawable.salon1,R.drawable.salon2,R.drawable.salon4,R.drawable.salon5};
        for(int i=0;i<imgArray.length;i++)
        {
            showImage(imgArray[i]);
        }
        OnBackPressedCallback callback=new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(mainpage.this);
                builder.setMessage("Do you really want to exit?");
                builder.setCancelable(true);

                builder.setPositiveButton(Html.fromHtml("<font color='#FFD700'>YES</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                    }
                });

                builder.setNegativeButton(Html.fromHtml("<font color='#FFD700'>Cancel</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
            };
                getOnBackPressedDispatcher().addCallback(this,callback);

    }
    private void showImage(int img) {
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(img);

        f1.addView(imageView);
        f1.setFlipInterval(2000);
        f1.setAutoStart(true);

        f1.setInAnimation(this,android.R.anim.slide_in_left);
        f1.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void products(View view) {
        Intent i1=new Intent(getApplicationContext(),products.class);
        startActivity(i1);
    }

    public void services(View view) {
        Intent i1=new Intent(getApplicationContext(),services.class);
        startActivity(i1);
    }

    public void account(View view) {
        Intent i1=new Intent(getApplicationContext(),profile.class);
        startActivity(i1);
    }

    public void appoint(View view) {
        Intent i1=new Intent(getApplicationContext(),Appointment.class);
        startActivity(i1);
        Toast.makeText(getApplicationContext(),"Please choose service to proceed further",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() == null)
        {
            startActivity(new Intent(mainpage.this,MainActivity.class));
            finish();
        }

    }

    public void booked(View view) {
        Intent i1=new Intent(getApplicationContext(),cart.class);
        startActivity(i1);
    }
}