package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private TextView usdResult;
    private TextView jpyResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        edNtd = findViewById(R.id.ed_ntd);
        usdResult = findViewById(R.id.usdResult);
        jpyResult = findViewById(R.id.jpyResult);
        Button exchangeRate = findViewById(R.id.exchange_rate);
        exchangeRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.exchange_rate)
                        .setMessage(getString(R.string.jpy_is) + "0.27" + "\n" +
                                    getString(R.string.use_is) + "30.9")
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });
    }

    public void exchange(View view) {
        String dollars = edNtd.getText().toString();
        if(dollars.length() == 0){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd)
                    .setPositiveButton(R.string.ok, null)
                    .show();
            return;
        }

        float ntd = Float.parseFloat(dollars);
        float usd = ntd / 30.9f;
        float jpy = ntd / 0.27f;
        Log.d("MainActivity", getString(R.string.use_is) + usd);
        Log.d("MainActivity", getString(R.string.jpy_is) + jpy);
        Toast.makeText(this, getString(R.string.use_is) + usd, Toast.LENGTH_LONG).show();
        Toast.makeText(this, getString(R.string.jpy_is) + jpy, Toast.LENGTH_LONG).show();
        usdResult.setText(String.valueOf(usd));
        jpyResult.setText(String.valueOf(jpy));

        new AlertDialog.Builder(this)
                .setTitle(R.string.result)
                .setMessage(getString(R.string.use_is) + usd + "\n" + getString(R.string.jpy_is) + jpy)
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}


