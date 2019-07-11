package com.example.steven.projekprediksi;

import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu_about extends AppCompatActivity {


    TextView nama,jurusan,jumlahData,jumlahPrediksi;
    String yey1,yey2,yey3,yey4,go1,go2,go3,go4;
    Integer nilai1,nilai2,nilai3,nilai4;
    Button duar;
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_about);

        constraintLayout = findViewById(R.id.kokose);
        animationDrawable = (AnimationDrawable)constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        nama = findViewById(R.id.tvNama);
        jurusan = findViewById(R.id.tvJurusan);
        jumlahData = findViewById(R.id.tvData);
        jumlahPrediksi = findViewById(R.id.tvPrediksi);
        duar = findViewById(R.id.keluar);



        duar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu_about.this.finish();
            }
        });

    }


    public void perbarui(){
        String namaa = "Pengembang : Steven Hosana Sihombing";
        String jurusann = "Jurusan : Teknik Informatika";

        nama.setText(namaa);
        jurusan.setText(jurusann);
    }
}
