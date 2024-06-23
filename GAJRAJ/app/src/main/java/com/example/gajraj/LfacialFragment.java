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
 * Use the {@link LfacialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LfacialFragment extends Fragment {
    OnBackPressedCallback callback;
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9;
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

    public LfacialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LfacialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LfacialFragment newInstance(String param1, String param2) {
        LfacialFragment fragment = new LfacialFragment();
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
        View view=inflater.inflate(R.layout.fragment_lfacial, container, false);

        pd = new ProgressDialog( getActivity());
        reference = FirebaseDatabase.getInstance().getReference();

        c1 = (CardView) view.findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView thread = view.findViewById(R.id.text1);
                TextView threaddiscrip = view.findViewById(R.id.text2);
                String title = thread.getText().toString();
                String discrip = threaddiscrip.getText().toString();
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
                TextView bleach = view.findViewById(R.id.text3);
                TextView bleachdiscrip = view.findViewById(R.id.text4);
                String title = bleach.getText().toString();
                String discrip = bleachdiscrip.getText().toString();
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
                TextView bright = view.findViewById(R.id.text5);
                TextView brightdiscrip = view.findViewById(R.id.text6);
                String title = bright.getText().toString();
                String discrip = brightdiscrip.getText().toString();
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
                TextView treatment = view.findViewById(R.id.text7);
                TextView treatmentdiscrip = view.findViewById(R.id.text8);
                String title = treatment.getText().toString();
                String discrip = treatmentdiscrip.getText().toString();
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
                TextView gold = view.findViewById(R.id.text9);
                TextView golddiscrip = view.findViewById(R.id.text10);
                String title = gold.getText().toString();
                String discrip = golddiscrip.getText().toString();
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
                TextView papaya = view.findViewById(R.id.text11);
                TextView papayadiscrip = view.findViewById(R.id.text12);
                String title = papaya.getText().toString();
                String discrip = papayadiscrip.getText().toString();
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
                TextView pearl = view.findViewById(R.id.text13);
                TextView pearldiscrip = view.findViewById(R.id.text14);
                String title = pearl.getText().toString();
                String discrip = pearldiscrip.getText().toString();
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
        c8= (CardView) view.findViewById(R.id.c8);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView oxy = view.findViewById(R.id.text15);
                TextView oxydiscrip = view.findViewById(R.id.text16);
                String title = oxy.getText().toString();
                String discrip = oxydiscrip.getText().toString();
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
        c9 = (CardView) view.findViewById(R.id.c9);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rate=200;
                TextView diamond = view.findViewById(R.id.text17);
                TextView diamonddiscrip = view.findViewById(R.id.text18);
                String title = diamond.getText().toString();
                String discrip = diamonddiscrip.getText().toString();
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
        dbref.child(uniqueKey).child("Services").child("LadiesFacial").child(s).setValue(ob).addOnSuccessListener(new OnSuccessListener() {
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