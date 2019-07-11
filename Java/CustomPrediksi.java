package com.example.steven.projekprediksi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomPrediksi extends AppCompatActivity {

    String hasil,kesimpulan;
    TextView textView,hasilnya;
    Button tutup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_msg);

        textView = findViewById(R.id.txtHasil);
        hasilnya = findViewById(R.id.tvKesimpulan);
        tutup =findViewById(R.id.btnSelesai);


        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            hasil = extras.getString("hasilPrediksi");
            kesimpulan =extras.getString("jeger");

        }
        textView.setText(hasil);
        hasilnya.setText(kesimpulan);

        tutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomPrediksi.this.finish();
            }
        });




    }
}
