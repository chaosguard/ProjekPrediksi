package com.example.steven.projekprediksi;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Pilih_final extends AppCompatActivity {




    String yey1,yey2,yey3,yey4,yey5,yey6,apakek,hey,tayo;
    String msg1,msg2,msg3,msg4,msg5,msg6,msg7,msg8,msg9,msg10,msg11,msg12,msg13,msg14,msg15,msg16,final1,final2;
    String jawab1,jawab2,jawab3,jawab4,jawab5,jawab6,jawab7,jawab8,jawab9,alamatEmail;
    String ov1,ov2,ov3,ov4,ov5,ov6,ov7,ov8,ov9;

    Integer test1,test2,test3,test4,test5,test6,test7,test8;
    TextView v1,v2,v3,v4,v5,v6,v7,v8;

    Button btnSatu,btnDua,btnTiga,btnLanjut,btnPrediksi;

    DecimalFormat nilai = new DecimalFormat("##.##%");
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilih_final);

        constraintLayout = findViewById(R.id.tengaku);
        animationDrawable = (AnimationDrawable)constraintLayout.getBackground();

        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        btnSatu = (Button) findViewById(R.id.btnSatu);
        btnDua = (Button) findViewById(R.id.btnDua);
        btnTiga = (Button) findViewById(R.id.btnTiga);
        btnLanjut = (Button) findViewById(R.id.btnGo);
        btnPrediksi = (Button) findViewById(R.id.btnPrediksi);

        btnLanjut.setVisibility(View.GONE);


        v1= findViewById(R.id.res1);
        v2= findViewById(R.id.res2);
        v3= findViewById(R.id.res3);
        v4= findViewById(R.id.res4);
        v5= findViewById(R.id.res5);
        v6= findViewById(R.id.res6);
        v7= findViewById(R.id.res7);
        v8= findViewById(R.id.res8);





        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            msg1 = extras.getString("key1");
            msg2 = extras.getString("key2");
            msg3 = extras.getString("key3");
            msg4 = extras.getString("key4");
            msg5 = extras.getString("key5");
            msg6 = extras.getString("key6");
            msg7 = extras.getString("key7");
            msg8 = extras.getString("key8");

            msg9 = extras.getString("key9");
            msg10 = extras.getString("key10");
            msg11 = extras.getString("key11");
            msg12 = extras.getString("key12");
            msg13 = extras.getString("key13");
            msg14 = extras.getString("key14");
            msg15 = extras.getString("key15");
            msg16 = extras.getString("key16");

            final1 = extras.getString("keyN");
            final2 = extras.getString("keyO");

            jawab1= extras.getString("jb1");
            jawab2= extras.getString("jb2");
            jawab3= extras.getString("jb3");
            jawab4= extras.getString("jb4");
            jawab5= extras.getString("jb5");
            jawab6= extras.getString("jb6");
            jawab7= extras.getString("jb7");
            jawab8= extras.getString("jb8");

            alamatEmail =extras.getString("eemail");


        }

        apakek = msg1  + msg2 + msg3 +msg4 +msg5 +msg6+msg7+msg8+final1;
        hey = msg9+msg10+msg11+msg12+msg13+msg14+msg15+msg16+final2;
        //njir1.setText(apakek);
        //njir2.setText(hey);


         test1 = Integer.parseInt(jawab1);
        test2 = Integer.parseInt(jawab2);
        test3 = Integer.parseInt(jawab3);
        test4 = Integer.parseInt(jawab4);
        test5 = Integer.parseInt(jawab5);
        test6 = Integer.parseInt(jawab6);
        test7 = Integer.parseInt(jawab7);
        test8 = Integer.parseInt(jawab8);



        if(test1>1){
            //ov1= "Umur dibawah 27 tahun";
            ov1= "Umur diatas 27 tahun";
        }else{
            //ov1= "Umur diatas 27 tahun";
            ov1= "Umur dibawah 27 tahun";
        }

        if(test2>0){
            ov2= "Terkena penyakit khusus ketika kecil";
            //ov2= "Tidak pernah terkena penyakit khusus";
        }else{
            ov2= "Tidak pernah terkena penyakit khusus";
            //ov2= "Terkena penyakit khusus ketika kecil";
        }

        if(test3>0){
            //ov3= "Punya trauma";
            ov3= "Tidak punya trauma";
        }else{
            //ov3= "Tidak punya trauma";
            ov3= "Punya trauma";
        }

        if(test4>0){
            //ov4= "Pernah dibedah";
            ov4= "Tidak pernah dibedah";
        }else{
            //ov4= "Tidak pernah dibedah";
            ov4= "Pernah dibedah";
        }

        if(test5>2){
            ov5="Tidak terkena demam setahun ini";
        }else if(test5>1){
            ov5= "Terkena demam lebih dari 3 bulan yg lalu";
        }else{
            ov5= "Terkena demam kurang dari 3 bulan yg lalu";
        }

        if(test6>2){
            ov6 = "Tidak pernah minum alkohol";
        }else if(test6>1){
            ov6 = "Minum alkohol sekali seminggu";
        }else{
            ov6= "Minum alkohol beberapa kali dalam seminggu";
        }

        if(test7>2){
            ov7= "Setiap hari merokok";
        }else if(test7>1){
            ov7= "Kadang-kadang merokok";
        }else{
            ov7= "Tidak merokok";
        }

        if(test8>0){
            ov8 =  "Duduk lebih dari delapan jam sehari";
        }else{
            ov8= "Duduk satu sampai delapan jam sehari";
        }

        v1.setText(ov1);
        v2.setText(ov2);
        v3.setText(ov3);
        v4.setText(ov4);
        v5.setText(ov5);
        v6.setText(ov6);
        v7.setText(ov7);
        v8.setText(ov8);

        double kasusNormal = Double.valueOf(final1);
        double kasusAltered = Double.valueOf(final2);

        double nmsg1 = Double.valueOf(msg1);
        double nmsg2 = Double.valueOf(msg2);
        double nmsg3 = Double.valueOf(msg3);
        double nmsg4 = Double.valueOf(msg4);
        double nmsg5 = Double.valueOf(msg5);
        double nmsg6 = Double.valueOf(msg6);
        double nmsg7 = Double.valueOf(msg7);
        double nmsg8 = Double.valueOf(msg8);

        double omsg1 = Double.valueOf(msg9);
        double omsg2 = Double.valueOf(msg10);
        double omsg3 = Double.valueOf(msg11);
        double omsg4 = Double.valueOf(msg12);
        double omsg5 = Double.valueOf(msg13);
        double omsg6 = Double.valueOf(msg14);
        double omsg7 = Double.valueOf(msg15);
        double omsg8 = Double.valueOf(msg16);

        double resNormal = (nmsg1/kasusNormal)*(nmsg2/kasusNormal)*(nmsg3/kasusNormal)
                *(nmsg4/kasusNormal)*(nmsg5/kasusNormal)*(nmsg6/kasusNormal)
                *(nmsg7/kasusNormal)*(nmsg8/kasusNormal);

        double resAltered = (omsg1/kasusAltered)*(omsg2/kasusAltered)*(omsg3/kasusAltered)
                *(omsg4/kasusAltered)*(omsg5/kasusAltered)*(omsg6/kasusAltered)
                *(omsg7/kasusAltered)*(omsg8/kasusAltered);

        double resTotal = resNormal +resAltered;
        final double finalNormal = resNormal/resTotal;
        final double finalAltered = resAltered/resTotal;





        btnPrediksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalNormal>finalAltered){
                    String goal = "Normal " + nilai.format(finalNormal);
                    String kesimpulan = "Sel sperma anda Normal";
                    Intent intent = new Intent(Pilih_final.this,CustomPrediksi.class);
                    intent.putExtra("hasilPrediksi",goal);
                    intent.putExtra("jeger",kesimpulan);
                    startActivity(intent);

                }else{
                    String goal = "Altered "+ nilai.format(finalAltered);
                    String kesimpulan = "Sel sperma anda mengalami perubahan (tidak normal)";
                    Intent intent = new Intent(Pilih_final.this,CustomPrediksi.class);
                    intent.putExtra("hasilPrediksi",goal);
                    intent.putExtra("jeger",kesimpulan);
                    startActivity(intent);
                }

                if(finalNormal>finalAltered){
                    tayo="N";
                }else{
                    tayo="O";
                }
                btnLanjut.setVisibility(View.VISIBLE);
                //addItemToSheet();
            }
        });

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(finalNormal>finalAltered){
                    tayo="N";
                }else{
                    tayo="O";
                }*/
                addItemToSheet();
            }
        });
    }
    private void showPesan(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Mohon dipilih");
        alert
                .setMessage("Apakah anda sudah membuktikan hasil prediksi ? Jika sudah , pilih benar jika hasil prediksi benar dan pilih Salah jika prediksi salah. Pilih Belum jika anda belum membuktikannya")
                .setCancelable(false)
                .setPositiveButton("Benar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //todo
                    }
                })
                .setNegativeButton("Salah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //todo
                    }
                })
                .setNeutralButton("Belum", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //todo
                    }
                });
        AlertDialog alertDialog= alert.create();
        alertDialog.show();
    }

    private void addItemToSheet(){
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String umur = jawab1;
        final String anak = jawab2;
        final String trauma = jawab3;
        final String bedah = jawab4;
        final String panas = jawab5;
        final String alkohol = jawab6;
        final String rokok = jawab7;
        final String duduk = jawab8;
        final String hwasil = tayo;
        final String mail = alamatEmail;




        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://script.google.com/macros/s/AKfycbyGV4UtaBlPlXtAR1BXgMHQtkQgXzqUiR7bqXuNw8Wcscz6yu8/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(Pilih_final.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        bambang();
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("itemSatu",umur);
                parmas.put("itemDua",anak);
                parmas.put("itemTiga",trauma);
                parmas.put("itemEmpat",bedah);
                parmas.put("itemLima",panas);
                parmas.put("itemEnam",alkohol);
                parmas.put("itemTujuh",rokok);
                parmas.put("itemDelapan",duduk);
               parmas.put("itemHasil",hwasil);
               parmas.put("itemMail",mail);

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }

    private void bambang(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "https://script.google.com/macros/s/AKfycbx-eKl3tOE4T_COA6BMh7oPQSbxbDrwk6yjfJHMCSBtdBjwyg/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }
}
