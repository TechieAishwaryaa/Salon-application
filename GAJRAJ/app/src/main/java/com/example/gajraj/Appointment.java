package com.example.gajraj;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Appointment extends AppCompatActivity {
    int finalPrice;
    TextView t1;
    DatePicker dp;
    RadioGroup r1;
    RadioButton rb1;
    String date;
    private static final int PAY_REQUEST =1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        t1 = findViewById(R.id.t1);

        Intent intent = getIntent();
        finalPrice = intent.getIntExtra("final_price", 0);
        t1.setText(finalPrice + "Rs.");
        dp=findViewById(R.id.d1);
        r1=findViewById(R.id.r1);
        // Check if finalPrice is zero
        if (finalPrice == 0) {
            showZeroPriceDialog();
        }
        String d=""+dp.getDayOfMonth();
        String m=""+(dp.getMonth()+1);
        String y=""+dp.getYear();
        date=d+m+y;

    }

    private void showZeroPriceDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Please book a service")
                .setMessage("The final price is zero. Please book a service.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Return to the MainPage activity
                        Intent intent = new Intent(Appointment.this, mainpage.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
    String time="";
    public void confirm(View view) {

        int selid=r1.getCheckedRadioButtonId();
        if(selid==R.id.rb1)
        {
            time="10:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }
        if(selid==R.id.rb2)
        {
           time="11:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }
        if(selid==R.id.rb3)
        {
            time="12:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }
        if(selid==R.id.rb4)
        {
           time="1:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }
        if(selid==R.id.rb5)
        {
            time="2:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        } if(selid==R.id.rb6)
        {
            time="4:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        } if(selid==R.id.rb7)
        {
             time="5:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        } if(selid==R.id.rb8)
        {
           time="6:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        } if(selid==R.id.rb9)
        {
            time="7:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }
        if(selid==R.id.rb10)
        {
             time="8:00";
            Toast.makeText(this, "Selected date"+date+"Selected time: "+time, Toast.LENGTH_SHORT).show();
        }




        payUsingUpi("9075064072@fam","Ronak Dabade","Advance","1");
    }

    private void payUsingUpi(String upiId, String name, String note, String amount) {
        Uri uri=Uri.parse("upi://pay").buildUpon()
                .appendQueryParameter("pa",upiId)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();
        Intent upiPayIntent=new Intent(Intent.ACTION_VIEW);
        upiPayIntent.setData(uri);
        Intent chooser=Intent.createChooser(upiPayIntent,"Pay with");
        if(null!=chooser.resolveActivity(getPackageManager()))
        {
            startActivityForResult(chooser,PAY_REQUEST);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"No UPI app found",Toast.LENGTH_SHORT).show();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PAY_REQUEST) {
            if (resultCode == RESULT_OK || resultCode == 11) {
                // Transaction successful
                String transactionId = data.getStringExtra("response");
                Toast.makeText(getApplicationContext(), "Transaction successful.", Toast.LENGTH_SHORT).show();
                SmsManager sm=SmsManager.getDefault();
                String phonenumber="";
                String msg="Your appointment is booked at "+time+"on"+date;
                sm.sendTextMessage(phonenumber,null,msg,null,null);

            } else {
                // Transaction failed or canceled
                Toast.makeText(getApplicationContext(), "Transaction canceled or failed.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    }

