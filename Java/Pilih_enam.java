package com.example.steven.projekprediksi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Pilih_enam extends AppCompatActivity {





    String yey1,yey2,yey3,yey4,yey5,yey6;
    String msg1,msg2,msg3,msg4,msg5,msg6,msg7,msg8,msg9,msg10,msg11,msg12,msg13,msg14,msg15,msg16;
    String jawab1,jawab2,jawab3,jawab4,jawab5,jawab6,jawab7,jawab8,jawab9,alamatEmail;
    TextView njir1,njir2,njir3,njir4,njir5,njir6;
    Button btnSatu,btnDua,btnTiga,btnLanjut;

    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_enam);

        btnSatu = (Button) findViewById(R.id.btnSatu);
        btnDua = (Button) findViewById(R.id.btnDua);
        btnTiga = (Button) findViewById(R.id.btnTiga);
        btnLanjut = (Button) findViewById(R.id.btnGo);
        njir1 = (TextView) findViewById(R.id.txt1);
        njir2 = (TextView) findViewById(R.id.txt2);
        njir3 = (TextView) findViewById(R.id.txt3);
        njir4 = (TextView) findViewById(R.id.txt4);
        njir5 = (TextView) findViewById(R.id.txt5);
        njir6 = (TextView) findViewById(R.id.txt6);

        btnSatu.setBackgroundColor(Color.parseColor("#ffffff"));
        btnDua.setBackgroundColor(Color.parseColor("#ffffff"));
        btnTiga.setBackgroundColor(Color.parseColor("#ffffff"));

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        animationDrawable = (AnimationDrawable)relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

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
            msg9 = extras.getString("key9");
            msg10 = extras.getString("key10");
            msg11 = extras.getString("key11");
            msg12 = extras.getString("key12");
            msg13 = extras.getString("key13");
            jawab1=extras.getString("jb1");
            jawab2=extras.getString("jb2");
            jawab3=extras.getString("jb3");
            jawab4=extras.getString("jb4");
            jawab5=extras.getString("jb5");
            alamatEmail =extras.getString("eemail");
    }

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pilih_enam.this,Pilih_tujuh.class);
                intent.putExtra("key1",msg1);
                intent.putExtra("key2",msg2);
                intent.putExtra("key3",msg3);
                intent.putExtra("key4",msg4);
                intent.putExtra("key5",msg5);
                intent.putExtra("key6",msg6);
                intent.putExtra("key9",msg9);
                intent.putExtra("key10",msg10);
                intent.putExtra("key11",msg11);
                intent.putExtra("key12",msg12);
                intent.putExtra("key13",msg13);
                intent.putExtra("key14",msg14);
                intent.putExtra("jb1",jawab1);
                intent.putExtra("jb2",jawab2);
                intent.putExtra("jb3",jawab3);
                intent.putExtra("jb4",jawab4);
                intent.putExtra("jb5",jawab5);
                intent.putExtra("jb6",jawab6);
                intent.putExtra("eemail",alamatEmail);
                startActivity(intent);
            }
        });

        btnSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg6=yey1;
                msg14=yey2;
                jawab6="1";
                btnSatu.setBackgroundColor(Color.parseColor("#95e5e2"));
                btnDua.setBackgroundColor(Color.parseColor("#ffffff"));
                btnTiga.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        btnDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg6=yey3;
                msg14=yey4;
                jawab6="2";
                btnSatu.setBackgroundColor(Color.parseColor("#ffffff"));
                btnDua.setBackgroundColor(Color.parseColor("#95e5e2"));
                btnTiga.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });
        btnTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg6=yey5;
                msg14=yey6;
                jawab6="3";
                btnSatu.setBackgroundColor(Color.parseColor("#ffffff"));
                btnDua.setBackgroundColor(Color.parseColor("#ffffff"));
                btnTiga.setBackgroundColor(Color.parseColor("#95e5e2"));
            }
        });



        ambilDataAlkoholSatuNormal();
        ambilDataAlkoholSatuAltered();
        ambilDataAlkoholDuaNormal();
        ambilDataAlkoholDuaAltered();
        ambilDataAlkoholTigaNormal();
        ambilDataAlkoholTigaAltered();

    }

    public void ambilDataAlkoholSatuNormal(){
        String data="12";
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

    public void ambilDataAlkoholSatuAltered(){
        String data="12";
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

    public void ambilDataAlkoholDuaNormal(){
        String data="13";
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

    public void ambilDataAlkoholDuaAltered(){
        String data="13";
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

    public void ambilDataAlkoholTigaNormal(){
       String data="14";
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
                    njir5.setText(aww);
                    yey5 = aww;
                    //mValueView.setText(aww);
                    //nMusim=aww1;

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ambilDataAlkoholTigaAltered(){
        String data="14";
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
                    njir6.setText(aww);
                    yey6 = aww;
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
