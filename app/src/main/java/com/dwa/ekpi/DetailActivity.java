package com.dwa.ekpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DetailActivity extends AppCompatActivity {

    Spinner dtlSpinner1,dtlSpinner2,dtlSpinner3;
    Button buatLaporanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dtlSpinner1 = findViewById(R.id.line_spinner);
        String[] pilihan1 = {"ER 01","ER 02","ER 03","ER 150"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pilihan1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dtlSpinner1.setAdapter(adapter1);

        dtlSpinner2 = findViewById(R.id.produk_spinner);
        String[] pilihan2 = {"D14N","KS Hyundai","D26N","D55L","D52B","D91/92L"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pilihan2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dtlSpinner2.setAdapter(adapter2);

        dtlSpinner3 = findViewById(R.id.jam_spinner);
        String[] pilihan3 = {"8 Jam","7 Jam","5 Jam"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pilihan3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dtlSpinner3.setAdapter(adapter3);

        buatLaporanBtn = findViewById(R.id.buatLaporan_btn);
        buatLaporanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent (DetailActivity.this, LaporanActivity.class);
                startActivity(pindah);

            }
        });
    }
}