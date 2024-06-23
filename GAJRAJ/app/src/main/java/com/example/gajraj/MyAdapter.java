package com.example.gajraj;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<CartItem> itemList;
    String key;
    FirebaseAuth mAuth;
    FirebaseUser user;

    int position;
    public MyAdapter(Context context, List<CartItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = itemList.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.priceTextView.setText(item.getPrice());

        holder.setPosition(position);
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView serviceNameTextView = (TextView) holder.itemView.findViewById(R.id.snm);
                String serviceName = serviceNameTextView.getText().toString();

                TextView servicePriceTextView = (TextView) holder.itemView.findViewById(R.id.sp);
                String servicePrice = servicePriceTextView.getText().toString();

                mAuth = FirebaseAuth.getInstance();
                user = mAuth.getCurrentUser();

                // Get a reference to the "services" node in the database
                key = user.getUid().toString();
                Toast.makeText(context, "" + serviceName, Toast.LENGTH_SHORT).show();


                DatabaseReference servicesRef = FirebaseDatabase.getInstance().getReference("users")
                        .child(key).child("Services");

                String t1= String.valueOf(FirebaseDatabase.getInstance().getReference("users").child(key).child("Services").child("Title").equalTo(serviceName));
                // Query the database to find the service record with the given name
                Query serviceQuery = servicesRef.orderByChild("Title").equalTo(serviceName);

                servicesRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            DataSnapshot gentshairSnapshot = snapshot.child("Gentshair");
                            DataSnapshot gentsbeardSnapshot = snapshot.child("GentsBeard");
                            DataSnapshot gentsfacialSnapshot = snapshot.child("GentsFacial");
                            DataSnapshot gentsmassageSnapshot = snapshot.child("GentsMassage");
                            DataSnapshot ladiesfacialSnapshot = snapshot.child("LadiesFacial");
                            DataSnapshot ladieshairSnapshot = snapshot.child("Ladieshair");
                            DataSnapshot ladiemakeupSnapshot = snapshot.child("LadiesMakeup");
                            DataSnapshot ladiesmanicureSnapshot = snapshot.child("LadiesManicure");
                            DataSnapshot ladiespedicureSnapshot = snapshot.child("LadiesPedicure");
                            DataSnapshot ladieswaxingSnapshot = snapshot.child("LadiesWaxing");
                            for (DataSnapshot serviceSnapshot : gentshairSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : gentsbeardSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : gentsfacialSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : gentsmassageSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : ladiesfacialSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : ladieshairSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }
                            for (DataSnapshot serviceSnapshot : ladiemakeupSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }  for (DataSnapshot serviceSnapshot : ladiesmanicureSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }  for (DataSnapshot serviceSnapshot : ladiespedicureSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }  for (DataSnapshot serviceSnapshot : ladieswaxingSnapshot.getChildren()) {
                                // Remove the "Title" and "Price" fields from the service record
                                ;
                                String title=serviceSnapshot.child("Title").getValue(String.class);
                                Toast.makeText(context, ""+title, Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, ""+serviceName, Toast.LENGTH_SHORT).show();
                                if (title!=null && title.equals(serviceName)) {

                                    // Remove the "Title" and "Price" fields from the service record
                                    serviceSnapshot.child("Title").getRef().removeValue();
                                    serviceSnapshot.child("Price").getRef().removeValue();
                                    return;
                                }
                            }




                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(context, "heelo", Toast.LENGTH_SHORT).show();
                    }
                });

                // Remove the item from the list of CartItems
                itemList.remove(position);
                for (int i = position; i < itemList.size(); i++) {
                    itemList.get(i).setPosition(i);
                }

                // Notify the adapter that the data set has changed
                notifyItemRemoved(position);
                notifyDataSetChanged();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Service Removed")
                        .setMessage("The selected service has been removed from your cart.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                Intent intent = new Intent(context, cart.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                context.startActivity(intent);

                            }
                        })
                        .show();


            }

        });


    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView priceTextView;
        ImageButton deleteButton;
        private int position;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.snm);
            priceTextView = itemView.findViewById(R.id.sp);
            deleteButton = itemView.findViewById(R.id.b1);


        }
        public void setPosition(int position) {
            this.position = position;
        }
    }
}