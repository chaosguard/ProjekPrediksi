package com.example.steven.projekprediksi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Pilih_satu extends AppCompatActivity {


    String  yey1,yey2,yey3,yey4,dummy,send1,send2;
    String jawab1,alamatEmail,msg1,msg9;
     Integer getUmur;
     TextView njir1,njir2,njir3,njir4,gg;
     Button lanjut;
     EditText umur;
RelativeLayout relativeLayout;
AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_satu);

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        animationDrawable = (AnimationDrawable)relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();


        njir1 = (TextView)findViewById(R.id.hasil1);
        njir2 = (TextView)findViewById(R.id.hasil2);
        njir3 = (TextView)findViewById(R.id.hasil3);
        njir4 = (TextView)findViewById(R.id.hasil4);

        lanjut = (Button)findViewById(R.id.goLanjut);
        umur = (EditText)findViewById(R.id.boxUmur);

        njir1.setVisibility(View.GONE);
        njir2.setVisibility(View.GONE);
        njir3.setVisibility(View.GONE);
        njir4.setVisibility(View.GONE);

        ambilDataUmurSatuNormal();
        ambilDataUmurSatuAltered();
        ambilDataUmurDuaNormal();
        ambilDataUmurDuaAltered();

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            alamatEmail =extras.getString("eemail");
        }

        lanjut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                dummy = umur.getText().toString();
                getUmur = Integer.parseInt(dummy);
                if(getUmur>=27){
                    jawab1="2";
                    send1 = yey3;
                    send2 = yey4;
                    Intent intent = new Intent(Pilih_satu.this,Pilih_dua.class);
                     msg1= send1;
                     msg9 =send2;
                    intent.putExtra("key1",msg1);
                    intent.putExtra("key9",msg9);
                    intent.putExtra("jb1",jawab1);
                    intent.putExtra("eemail",alamatEmail);
                    startActivity(intent);
                }
                if(getUmur<27){
                    jawab1="1";
                    send1=yey1;
                   send2=yey2;
                    Intent intent = new Intent(Pilih_satu.this,Pilih_dua.class);
                     msg1= send1;
                     msg9 =send2;
                    intent.putExtra("key1",msg1);
                    intent.putExtra("key9",msg9);
                    intent.putExtra("jb1",jawab1);
                    intent.putExtra("eemail",alamatEmail);
                    startActivity(intent);
                }
                /*Intent intent = new Intent(Pilih_satu.this,Pilih_dua.class);
                String msg1= send1;
                String msg9 =send2;
                intent.putExtra("key1",msg1);
                intent.putExtra("key9",msg9);
                strtActivity(intent);*/
            }
        });
    }


    public void ambilDataUmurSatuNormal(){
    String data="1";
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

    public void ambilDataUmurSatuAltered(){
        String data="1";
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


                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void ambilDataUmurDuaNormal(){
        String data="2";
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

    public void ambilDataUmurDuaAltered(){
        String data="2";
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
}
