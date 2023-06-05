package com.dwa.ekpi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class LaporanActivity extends AppCompatActivity {

    EditText edtAkt1, edtAkt2, edtAkt3, edtAkt4, edtAkt5, edtAkt6, edtAkt7, edtAkt8;
    TextView akmView1, akmView2, akmView3, akmView4, akmView5, akmView6, akmView7, akmView8, aktTtl, akmTtl;
    TextView dev1, dev2, dev3, dev4, dev5, dev6, dev7, dev8, devTtl;
    TextView devAkm1, devAkm2, devAkm3, devAkm4, devAkm5, devAkm6, devAkm7, devAkm8, devAkmTtl;
    TextView lT1,lT2,lT3,lT4,lT5,lT6,lT7,lT8,lTTtl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        edtAkt1 = findViewById(R.id.editAkt1);
        edtAkt2 = findViewById(R.id.editAkt2);
        edtAkt3 = findViewById(R.id.editAkt3);
        edtAkt4 = findViewById(R.id.editAkt4);
        edtAkt5 = findViewById(R.id.editAkt5);
        edtAkt6 = findViewById(R.id.editAkt6);
        edtAkt7 = findViewById(R.id.editAkt7);
        edtAkt8 = findViewById(R.id.editAkt8);
        aktTtl = findViewById(R.id.aktTtl);

        akmView1 = findViewById(R.id.tv_akm1);
        akmView2 = findViewById(R.id.tv_akm2);
        akmView3 = findViewById(R.id.tv_akm3);
        akmView4 = findViewById(R.id.tv_akm4);
        akmView5 = findViewById(R.id.tv_akm5);
        akmView6 = findViewById(R.id.tv_akm6);
        akmView7 = findViewById(R.id.tv_akm7);
        akmView8 = findViewById(R.id.tv_akm8);
        akmTtl = findViewById(R.id.tv_akmTtl);

        dev1 = findViewById(R.id.tv_dev1);
        dev2 = findViewById(R.id.tv_dev2);
        dev3 = findViewById(R.id.tv_dev3);
        dev4 = findViewById(R.id.tv_dev4);
        dev5 = findViewById(R.id.tv_dev5);
        dev6 = findViewById(R.id.tv_dev6);
        dev7 = findViewById(R.id.tv_dev7);
        dev8 = findViewById(R.id.tv_dev8);
        devTtl = findViewById(R.id.tv_devTtl);

        devAkm1 = findViewById(R.id.tv_devAkum1);
        devAkm2 = findViewById(R.id.tv_devAkum2);
        devAkm3 = findViewById(R.id.tv_devAkum3);
        devAkm4 = findViewById(R.id.tv_devAkum4);
        devAkm5 = findViewById(R.id.tv_devAkum5);
        devAkm6 = findViewById(R.id.tv_devAkum6);
        devAkm7 = findViewById(R.id.tv_devAkum7);
        devAkm8 = findViewById(R.id.tv_devAkum8);
        devAkmTtl = findViewById(R.id.tv_devAkumTtl);

        lT1 = findViewById(R.id.lossTime1);
        lT2 = findViewById(R.id.lossTime2);
        lT3 = findViewById(R.id.lossTime3);
        lT4 = findViewById(R.id.lossTime4);
        lT5 = findViewById(R.id.lossTime5);
        lT6 = findViewById(R.id.lossTime6);
        lT7 = findViewById(R.id.lossTime7);
        lT8 = findViewById(R.id.lossTime8);
        lTTtl = findViewById(R.id.lossTimeTtl);

        EditText[] edtAktArr = {edtAkt1, edtAkt2, edtAkt3, edtAkt4, edtAkt5, edtAkt6, edtAkt7, edtAkt8};
        TextView[] AkmArr = {akmView1, akmView2, akmView3, akmView4, akmView5, akmView6, akmView7, akmView8};
        TextView[] devArr = {dev1, dev2, dev3, dev4, dev5, dev6, dev7, dev8};
        TextView[] devAkmArr = {devAkm1, devAkm2, devAkm3, devAkm4, devAkm5, devAkm6, devAkm7, devAkm8};
        TextView[] lTArr = {lT1,lT2,lT3,lT4,lT5,lT6,lT7,lT8};


        for (int i = 0; i < edtAktArr.length; i++) {
            int index = i;
            edtAktArr[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
                @Override
                public void afterTextChanged(Editable s) {
                    String editTextAkt = s.toString();
                    try {
                        int input = Integer.parseInt(editTextAkt);
                        int hasil = input;

                        if (index > 0) {
                            hasil += Integer.parseInt(AkmArr[index - 1].getText().toString());
                        }
                        AkmArr[index].setText(String.valueOf(hasil));
                        aktTtl.setText(AkmArr[index].getText().toString());
                        akmTtl.setText(AkmArr[index].getText().toString());

                        if (index == 3 || index == 7) {
                            hasil = input - 50;
                        } else {
                            hasil = input - 55;
                        }
                        devArr[index].setText(String.valueOf(hasil));

                        if (index > 0) {
                            hasil += Integer.parseInt(devAkmArr[index - 1].getText().toString());
                        }
                        devAkmArr[index].setText(String.valueOf(hasil));
                        devTtl.setText(devAkmArr[index].getText().toString());
                        devAkmTtl.setText(devAkmArr[index].getText().toString());

                        double loss;
                        if (index == 3 || index == 7) {
                            loss = (50 - input) * 1.09;
                        } else {
                            loss = (55 - input) * 1.09;
                        }
                        long lossPembulatan = Math.round(loss);
                        String lT = lossPembulatan + "'";
                        lTArr[index].setText(lT);

                        if (index > 0) {
                            lossPembulatan += Long.parseLong(lTArr[index - 1].getText().toString().replace("'", ""));
                        }

                        long[] lossArray = new long[lTArr.length];
                        for (int i = 0; i < lTArr.length; i++) {
                            String lossText = lTArr[i].getText().toString();
                            if (!lossText.isEmpty()) {
                                long lossValue = Long.parseLong(lossText.replace("'", ""));
                                if (i > 0) {
                                    lossValue += lossArray[i - 1];
                                }
                                lossArray[i] = lossValue;
                            }
                        }
                        lTTtl.setText(lossArray[index] + "'");



                    } catch (NumberFormatException e) {
                        AkmArr[index].setText("");
                        devArr[index].setText("");
                        devAkmArr[index].setText("");
                        lTArr[index].setText("");
                    }
                }
            });
        }
    }
}

