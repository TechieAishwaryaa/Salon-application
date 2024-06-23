package com.example.gajraj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    String str[] = {};
    List<CartItem> itemList;
    String key;
    int finalprice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.cart);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemList = new ArrayList<>();

        SharedPreferences sharedPreferences = getSharedPreferences("Mypref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.apply();
        key = sharedPreferences.getString("uniquekey", "user");
        Toast.makeText(this, "Please wait for a while..!", Toast.LENGTH_SHORT).show();

        database = FirebaseDatabase.getInstance().getReference("users");

        database.child(key).child("Services").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    DataSnapshot gentshairSnapshot = snapshot.child("Gentshair");
                    DataSnapshot gentsbeardSnapshot = snapshot.child("GentsBeard");
                    DataSnapshot gentsfacialSnapshot = snapshot.child("GentsFacial");
                    DataSnapshot gentsmassageSnapshot = snapshot.child("GentsMassage");
                    DataSnapshot ladiesfacialSnapshot = snapshot.child("LadiesFacial");
                    DataSnapshot ladieshairSnapshot = snapshot.child("LadiesHair");
                    DataSnapshot ladiesmakeupSnapshot = snapshot.child("LadiesMakeup");
                    DataSnapshot ladiesmanicureSnapshot = snapshot.child("LadiesManicure");
                    DataSnapshot ladiespedicureSnapshot = snapshot.child("LadiesPedicure");
                    DataSnapshot ladieswaxingSnapshot = snapshot.child("LadiesWaxing");

                   finalprice=0;
                    for (DataSnapshot serviceSnapshot : gentshairSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);
                        finalprice=finalprice+Integer.parseInt(price);
                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : gentsbeardSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);
                        finalprice= finalprice+Integer.parseInt(price);
                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : gentsfacialSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : gentsmassageSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot :ladiesfacialSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : ladiesmakeupSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot :ladieswaxingSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : ladieshairSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : ladiesmanicureSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    for (DataSnapshot serviceSnapshot : ladiespedicureSnapshot.getChildren()) {
                        String price = serviceSnapshot.child("Price").getValue(String.class);
                        String title = serviceSnapshot.child("Title").getValue(String.class);

                        // Create a new CartItem object with the fetched data
                        CartItem item = new CartItem(title, price);

                        // Add the item to a list of CartItems
                        itemList.add(item);
                    }
                    Toast.makeText(cart.this, "Total:"+finalprice, Toast.LENGTH_SHORT).show();
                    // Create a new adapter with the list of CartItems
                    MyAdapter adapter = new MyAdapter(cart.this, itemList);

                    // Set the adapter on the RecyclerView
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void bookappoint(View view) {
        Intent i1=new Intent(getApplicationContext(),Appointment.class);
        i1.putExtra("final_price",finalprice);
        startActivity(i1);

    }
}
