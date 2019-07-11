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

public class Pilih_tiga extends AppCompatActivity {


    String yey1,yey2,yey3,yey4;
    String msg1,msg2,msg3,msg4,msg5,msg6,msg7,msg8,msg9,msg10,msg11,msg12,msg13,msg14,msg15,msg16;
    String jawab1,jawab2,jawab3,jawab4,jawab5,jawab6,jawab7,jawab8,jawab9,alamatEmail;
    TextView njir1,njir2,njir3,njir4;
    Button btnYes,btnNo,btnLanjut;
    RelativeLayout relativeLayout;
    AnimationDrawable animationDrawable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_tiga);

        btnYes = (Button)findViewById(R.id.btnSatu);
        btnNo = (Button)findViewById(R.id.btnDua);
        btnLanjut = (Button)findViewById(R.id.btnGo);
        njir1 = (TextView)findViewById(R.id.txt1);
        njir2 = (TextView)findViewById(R.id.txt2);
        njir3 = (TextView)findViewById(R.id.txt3);
        njir4 = (TextView)findViewById(R.id.txt4);

        btnYes.setBackgroundColor(Color.parseColor("#ffffff"));
        btnNo.setBackgroundColor(Color.parseColor("#ffffff"));

        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);
        animationDrawable = (AnimationDrawable)relativeLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        njir1.setVisibility(View.GONE);
        njir2.setVisibility(View.GONE);
        njir3.setVisibility(View.GONE);
        njir4.setVisibility(View.GONE);

        btnLanjut.setVisibility(View.GONE);

        ambilDataTraumaSatuNormal();
        ambilDataTraumaSatuAltered();
        ambilDataTraumaDuaNormal();
        ambilDataTraumaDuaAltered();

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            msg1=extras.getString("key1");
            msg2=extras.getString("key2");
            msg9=extras.getString("key9");
            msg10=extras.getString("key10");
            jawab1=extras.getString("jb1");
            jawab2=extras.getString("jb2");
            alamatEmail =extras.getString("eemail");
        }

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Pilih_tiga.this,Pilih_empat.class);
                intent.putExtra("key1",msg1);
                intent.putExtra("key2",msg2);
                intent.putExtra("key3",msg3);
                intent.putExtra("key9",msg9);
                intent.putExtra("key10",msg10);
                intent.putExtra("key11",msg11);
                intent.putExtra("jb1",jawab1);
                intent.putExtra("jb2",jawab2);
                intent.putExtra("jb3",jawab3);
                intent.putExtra("eemail",alamatEmail);
                startActivity(intent);
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg3=yey1;
                msg11=yey2;
                jawab3="0";
                btnYes.setBackgroundColor(Color.parseColor("#95e5e2"));
                btnNo.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLanjut.setVisibility(View.VISIBLE);
                msg3=yey3;
                msg11=yey4;
                jawab3="1";
                btnYes.setBackgroundColor(Color.parseColor("#ffffff"));
                btnNo.setBackgroundColor(Color.parseColor("#95e5e2"));
            }
        });
    }


    public void ambilDataTraumaSatuNormal(){
        String data="5";
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

    public void ambilDataTraumaSatuAltered(){
        String data="5";
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

    public void ambilDataTraumaDuaNormal(){
        String data="6";
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

    public void ambilDataTraumaDuaAltered(){
        String data="6";
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
