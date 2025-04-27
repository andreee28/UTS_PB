package com.example.uts_bmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        EditText edtBerat = findViewById(R.id.edtBerat);
        EditText edtTinggi = findViewById(R.id.edtTinggi);
        Button btnHitung = findViewById(R.id.btnHitung);
        TextView txtHasil = findViewById(R.id.txtHasil);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String beratStr = edtBerat.getText().toString();
                String tinggiStr = edtTinggi.getText().toString();

                if (!beratStr.isEmpty() && !tinggiStr.isEmpty()) {
                    float berat = Float.parseFloat(beratStr);
                    float tinggi = Float.parseFloat(tinggiStr) / 100;

                    float bmi = berat / (tinggi * tinggi);

                    String kategori;
                    if (bmi < 18.5) {
                        kategori = "Kurus";
                    } else if (bmi < 25) {
                        kategori = "Normal";
                    } else if (bmi < 30) {
                        kategori = "Gemuk";
                    } else {
                        kategori = "Obesitas";
                    }

                    txtHasil.setText(String.format("BMI kamu: %.2f\nKategori: %s", bmi, kategori));
                } else {
                    txtHasil.setText("Masukkan berat dan tinggi yang benar!");
                }
            }
        });
    }
}
