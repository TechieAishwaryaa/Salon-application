package com.example.gajraj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class register extends AppCompatActivity {
    EditText email1,password1,username,mobile;
    FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference reference,dbref;
    Button register;
    String username1,email,password,mobile1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
            mAuth=FirebaseAuth.getInstance();
            email1=findViewById(R.id.email);
            password1=findViewById(R.id.password);
            username = findViewById(R.id.username);
            mobile = findViewById(R.id.mobile);
            register = findViewById(R.id.register);
            reference = FirebaseDatabase.getInstance().getReference();
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validateData();
                }
            });



        }

        public void login(View view) {
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    private void validateData() {
        username1 = username.getText().toString();
         email = email1.getText().toString();
         password = password1.getText().toString();
         mobile1 = mobile.getText().toString();

        if (username1.isEmpty()) {
            username.setError("Required");
            username.requestFocus();
        } else if (email.isEmpty()) {
            email1.setError("Required");
            email1.requestFocus();
        } else if (password.isEmpty()) {
            password1.setError("Required");
            password1.requestFocus();
        } else if (mobile1.isEmpty()) {
            mobile.setError("Required");
            mobile.requestFocus();
        } else {
            createUser();
        }

    }
    public void createUser()
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                           uploadData();
                            Toast.makeText(register.this, "Account Created",
                                    Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(),mainpage.class);
                            startActivity(i);
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    private void uploadData() {

        mAuth = FirebaseAuth.getInstance();
        mAuth.getCurrentUser();



        dbref = reference.child("users");
        String uid = mAuth.getCurrentUser().getUid();
       String key = dbref.push().getKey();
        SharedPreferences sP = getSharedPreferences("Mypref",MODE_PRIVATE);
        SharedPreferences.Editor ed = sP.edit();
        ed.putString("uniquekey",uid);
        ed.apply();

        HashMap<String, String> user = new HashMap<>();
        user.put("uid", uid);
        user.put("username", username1);
        user.put("email", email);
        user.put("password", password);
        user.put("mobile",mobile1);

        dbref.child(uid).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(register.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}