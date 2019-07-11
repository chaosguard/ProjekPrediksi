package com.example.steven.projekprediksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MenuUtama extends AppCompatActivity {


    // TextView to Show Login User Email and Name.
    TextView  LoginUserEmail;
    Button goPrediksi, goTentang;
    String alamatEmail;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainmenu);

        LoginUserEmail = (TextView)findViewById(R.id.LoginUserEmail);
        goPrediksi = (Button)findViewById(R.id.goPrediksi);
        goTentang = (Button)findViewById(R.id.goTentang);

       //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String message=extras.getString("key1");
            LoginUserEmail.setText(message);
            alamatEmail=message;
        }


        goPrediksi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                go_satu();
            }
        });



    }
    public void go_satu(){
        Intent intent = new Intent(MenuUtama.this,Pilih_satu.class);

        intent.putExtra("eemail",alamatEmail);
        startActivity(intent);
    }
}

