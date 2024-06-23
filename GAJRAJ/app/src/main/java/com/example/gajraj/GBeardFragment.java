package com.example.gajraj;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GBeardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GBeardFragment extends Fragment {
    OnBackPressedCallback callback;
    CardView  c1,c2,c3,c4,c5,c6,c7;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FirebaseDatabase database;
    DatabaseReference reference,dbref;

    private ProgressDialog pd;
    Context context;

    public GBeardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GBeardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GBeardFragment newInstance(String param1, String param2) {
        GBeardFragment fragment = new GBeardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        callback=new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent i=new Intent(getActivity().getApplicationContext(),services.class);
                startActivity(i);
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_g_beard, container, false);
        pd = new ProgressDialog( getActivity());
        reference = FirebaseDatabase.getInstance().getReference();

        c1 = (CardView) view.findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView french = view.findViewById(R.id.text1);
                TextView frenchdiscrip = view.findViewById(R.id.text2);
                String title = french.getText().toString();
                String discrip = frenchdiscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c2 = (CardView) view.findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView shortstubbled = view.findViewById(R.id.text3);
                TextView shortstubbleddiscrip = view.findViewById(R.id.text4);
                String title = shortstubbled.getText().toString();
                String discrip = shortstubbleddiscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c3 = (CardView) view.findViewById(R.id.c3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView shortboxed = view.findViewById(R.id.text5);
                TextView shortboxeddiscrip = view.findViewById(R.id.text6);
                String title = shortboxed.getText().toString();
                String discrip = shortboxeddiscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c4 = (CardView) view.findViewById(R.id.c4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView goatee= view.findViewById(R.id.text7);
                TextView goateediscrip = view.findViewById(R.id.text8);
                String title = goatee.getText().toString();
                String discrip = goateediscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c5 = (CardView) view.findViewById(R.id.c5);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView circle = view.findViewById(R.id.text9);
                TextView circlediscrip = view.findViewById(R.id.text10);
                String title = circle.getText().toString();
                String discrip = circlediscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c6 = (CardView) view.findViewById(R.id.c6);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView chop = view.findViewById(R.id.text11);
                TextView chopdiscrip = view.findViewById(R.id.text12);
                String title = chop.getText().toString();
                String discrip = chopdiscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        c7 = (CardView) view.findViewById(R.id.c7);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView anchor = view.findViewById(R.id.text13);
                TextView anchordiscrip = view.findViewById(R.id.text14);
                String title = anchor.getText().toString();
                String discrip = anchordiscrip.getText().toString();
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                uploadData(title,discrip);


                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                ab.setTitle("CONFIRMATION");
                ab.setMessage("Do you really want to book it?");
                ab.show();
            }
        });
        return view;
    }
    private void uploadData(String s,String s1) {
        pd.setMessage("Uploading...");
        pd.show();
        SharedPreferences sP = getActivity().getSharedPreferences("Mypref",MODE_PRIVATE);
        String uniqueKey = sP.getString("uniquekey","no value");
        dbref = reference.child("users");
        HashMap<String,Object> ob = new HashMap<>();
        ob.put("Title",s);
        ob.put("Price",s1);
        dbref.child(uniqueKey).child("Services").child("GentsBeard").child(s).setValue(ob).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                pd.dismiss();
                Toast.makeText(getActivity(), "Your data updated successfully.", Toast.LENGTH_SHORT).show();



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}