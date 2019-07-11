package com.example.steven.projekprediksi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pilih_delapan extends AppCompatActivity {





    String yey1,yey2,yey3,yey4,yey5,yey6;
    String msg1,msg2,msg3,msg4,msg5,msg6,msg7,msg8,msg9,msg10,msg11,msg12,msg13,msg14,msg15,msg16,resNormal,resAltered;
    String jawab1,jawab2,jawab3,jawab4,jawab5,jawab6,jawab7,jawab8,jawab9,alamatEmail;
    TextView njir1,njir2,njir3,njir4,njir5,njir6;
    Button btnSatu,btnDua,btnLanjut;
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_delapan);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        animationDrawable = (AnimationDrawable)relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();


        btnLanjut = (Button) findViewById(R.id.btnGo);
        btnSatu = (Button)findViewById(R.id.btnSatu);
        btnDua  = (Button)findViewById(R.id.btnDua);
        njir1 = (TextView) findViewById(R.id.txt1);
        njir2 = (TextView) findViewById(R.id.txt2);
        njir3 = (TextView) findViewById(R.id.txt3);
        njir4 = (TextView) findViewById(R.id.txt4);
        njir5 = (TextView) findViewById(R.id.txt5);
        njir6 = (TextView) findViewById(R.id.txt6);

        btnSatu.setBackgroundColor(Color.parseColor("#ffffff"));
        btnDua.setBackgroundColor(Color.parseColor("#ffffff"));


        njir1.setVisibility(View.GONE);
        njir2.setVisibility(View.GONE);
        njir3.setVisibility(View.GONE);
        njir4.setVisibility(View.GONE);
        njir5.setVisibility(View.GONE);
        njir6.setVisibility(View.GONE);

        btnLanjut.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            msg1 = extras.getString("key1");
            msg2 = extras.getString("key2");
            msg3 = extras.getString("key3");
            msg4 = extras.getString("key4");
            msg5 = extras.getString("key5");
            msg6 = extras.getString("key6");
            msg7 = extras.getString("key7");
            msg9 = extras.getString("key9");
            msg10 = extras.getString("key10");
            msg11 = extras.getString("key11");
            msg12 = extras.getString("key12");
            msg13 = extras.getString("key13");
            msg14 = extras.getString("key14");
            msg15 = extras.getString("key15");
            jawab1= extras.getString("jb1");
            jawab2= extras.getString("jb2");
            jawab3= extras.getString("jb3");
            jawab4= extras.getString("jb4");
            jawab5= extras.getString("jb5");
            jawab6= extras.getString("jb6");
            jawab7= extras.getString("jb7");
            alamatEmail =extras.getString("eemail");
        }

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pilih_delapan.this,Pilih_final.class);
                intent.putExtra("key1",msg1);
                intent.putExtra("key2",msg2);
                intent.putExtra("key3",msg3);
                intent.putExtra("key4",msg4);
                intent.putExtra("key5",msg5);
                intent.putExtra("key6",msg6);
                intent.putExtra("key7",msg7);
                intent.putExtra("key8",msg8);
                intent.putExtra("key9",msg9);
                intent.putExtra("key10",msg10);
                intent.putExtra("key11",msg11);
                intent.putExtra("key12",msg12);
                intent.putExtra("key13",msg13);
                intent.putExtra("key14",msg14);
                intent.putExtra("key15",msg15);
                intent.putExtra("key16",msg16);
                intent.putExtra("keyN",resNormal);
                intent.putExtra("keyO",resAltered);
                intent.putExtra("jb1",jawab1);
                intent.putExtra("jb2",jawab2);
                intent.putExtra("jb3",jawab3);
                intent.putExtra("jb4",jawab4);
                intent.putExtra("jb5",jawab5);
                intent.putExtra("jb6",jawab6);
                intent.putExtra("jb7",jawab7);
                intent.putExtra("jb8",jawab8);
                intent.putExtra("eemail",alamatEmail);
                startActivity(intent);
            }
        });

        btnSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg8= yey1;
                msg16=yey2;
                resNormal = yey5;
                resAltered=yey6;
                jawab8="0";
                btnSatu.setBackgroundColor(Color.parseColor("#95e5e2"));
                btnDua.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        btnDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg8= yey3;
                msg16=yey4;
                resNormal = yey5;
                resAltered=yey6;
                jawab8="1";
                btnSatu.setBackgroundColor(Color.parseColor("#ffffff"));
                btnDua.setBackgroundColor(Color.parseColor("#95e5e2"));
            }
        });


        ambilDataDudukSatuNormal();
        ambilDataDudukSatuAltered();
        ambilDataDudukDuaNormal();
        ambilDataDudukDuaAltered();
        getNormal();
        getAltered();

    }

    public void ambilDataDudukSatuNormal(){
        String data="18";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("1");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    String aww = asd.toString();
                    njir1.setText(aww);
                    yey1 = aww;
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ambilDataDudukSatuAltered(){
        String data="18";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("2");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    String aww = asd.toString();
                    njir2.setText(aww);
                    yey2 = aww;
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ambilDataDudukDuaNormal(){
        String data="19";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("1");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    String aww = asd.toString();
                    njir3.setText(aww);
                    yey3 = aww;
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ambilDataDudukDuaAltered(){
        String data="19";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("2");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    String aww = asd.toString();
                    njir4.setText(aww);
                    yey4 = aww;
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void getNormal(){
        String data="20";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("1");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    /*String aww = asd.toString();
                    njir3.setText(aww);*/
                    yey5 = asd.toString();
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getAltered(){
        String data="20";
        DatabaseReference mRefUmur = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://prediksisel.firebaseio.com/masterSheet");
        DatabaseReference mRef = mRefUmur.child(data).child("2");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object obj = dataSnapshot.getValue();
                if (obj instanceof String){
                    String intVal=(String)dataSnapshot.getValue();
                    //mValueView.setText(intVal);

                }
                Object astaga = dataSnapshot.getValue();
                if(astaga instanceof Long){
                    Long hasil=(Long) dataSnapshot.getValue();
                    Integer asd = hasil.intValue();
                    //int asd = Integer.parseInt(String.valueOf(dataSnapshot.getValue()));
                    //String aww = asd.toString();
                    //njir4.setText(aww);
                    yey6 = asd.toString();
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
