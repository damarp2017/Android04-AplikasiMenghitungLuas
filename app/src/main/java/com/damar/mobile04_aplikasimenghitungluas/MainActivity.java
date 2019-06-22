package com.damar.mobile04_aplikasimenghitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    EditText edt_sisi;
    Button btn_hitung;
    TextView tv_hasil;
    Spinner spinner;
    String[] pilihan = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_sisi = findViewById(R.id.edt_sisi);
        btn_hitung = findViewById(R.id.btn_hitung);
        tv_hasil = findViewById(R.id.tv_hasil);
        spinner = findViewById(R.id.spinner);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().toString().equals(pilihan[0])){
                    rumusVolume();
                } else if (spinner.getSelectedItem().toString().equals(pilihan[1])){
                    rumusKeliling();
                } else if (spinner.getSelectedItem().toString().equals(pilihan[2])){
                    rumusLuasPermukaan();
                }
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihan);
        spinner.setAdapter(adapter);

    }

    private void rumusLuasPermukaan() {
        Double sisi = Double.valueOf(edt_sisi.getText().toString());
        Double hasil = 6 * sisi * sisi;
        tv_hasil.setText(hasil.toString());
    }

    private void rumusKeliling() {
        Double sisi = Double.valueOf(edt_sisi.getText().toString());
        Double hasil = 12 * sisi;
        tv_hasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(edt_sisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tv_hasil.setText(hasil.toString());
    }
}
