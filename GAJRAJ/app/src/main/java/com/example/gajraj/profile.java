package com.example.gajraj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends AppCompatActivity {
    FirebaseUser user;
    FirebaseAuth mAuth;
    TextView t1, mail1, t2,un1;
    String usermail, userm,usernm,usern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.cp);
        mail1 = findViewById(R.id.mail);
        un1=findViewById(R.id.un1);


        user = FirebaseAuth.getInstance().getCurrentUser();
        userm = user.getEmail();
        usermail = userm.toString();


        un1.setText("Aishwarya Suryawanshi");
        mail1.setText(usermail);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResetPasswordDialog();
            }
        });
    }

    public void signout(View view) {  AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
        builder.setTitle("Sign Out");
        builder.setMessage("Are you sure you want to sign out?");

        builder.setPositiveButton(Html.fromHtml("<font color='#FFD700'>YES</font>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
                finish();
            }
        });

        builder.setNegativeButton(Html.fromHtml("<font color='#FFD700'>No</font>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void showResetPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset Password");
        builder.setMessage("Enter your email to receive reset instructions.");

        View view = getLayoutInflater().inflate(R.layout.dialog_reset_password, null);
        builder.setView(view);

        EditText emailEt = view.findViewById(R.id.et_email);

        builder.setPositiveButton(Html.fromHtml("<font color='#FFD700'>Reset</font>"), (dialog, which) -> {
            String email = emailEt.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(profile.this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(profile.this, "Invalid email format", Toast.LENGTH_SHORT).show();
            } else {
                resetPassword(email);
            }
        });

        builder.setNegativeButton(Html.fromHtml("<font color='#FFD700'>Cancel</font>"), (dialog, which) -> {
            dialog.dismiss();
        });

        builder.create().show();
    }

    private void resetPassword(String email) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(profile.this, "Reset instructions sent to your email", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(profile.this, "Failed to send reset instructions", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
