package id.ac.poliban.mi.lidyalusianae020317032;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch sw = findViewById(R.id.sw);
        EditText etNama = findViewById(R.id.etNama);
        EditText etNim = findViewById(R.id.etNim);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        RadioButton rbLaki = findViewById(R.id.rbLk);
        RadioButton rbPr = findViewById(R.id.rbPr);


        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
        if (sw.isChecked()) {
            etNama.setEnabled(true);
            etNim.setEnabled(true);
            etAlamat.setEnabled(true);
            etTelp.setEnabled(true);
            rgGender.setEnabled(true);
        } else {
            etNama.setEnabled(false);
            etNim.setEnabled(false);
            etAlamat.setEnabled(false);
            etTelp.setEnabled(false);
            rgGender.setEnabled(false);
        }
        });
        btSubmit.setOnClickListener(v -> {
            String jenisKelamin = "";
            if (rbLaki.isChecked()) {
                jenisKelamin+= "Laki Laki";
            }
            if (rbPr.isChecked()){
                jenisKelamin+= "Perempuan";
            }

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Info")
                        .setMessage(etNim.getText().toString() + "\n" +
                                etNama.getText().toString() + "\n" +
                                etAlamat.getText().toString() + "\n" +
                                etTelp.getText().toString() + "\n"
                        )
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("OK", null).show();
        });

        btClear.setOnClickListener(v -> {
            etNim.setText("");
            etNama.setText("");
            etAlamat.setText("");
            etTelp.setText("");
            rgGender.clearCheck();
            etNim.requestFocus();

        });

    }

}
