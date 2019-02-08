package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;
    private TextView usdResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews(){
        edNtd = findViewById(R.id.ed_ntd);
        usdResult = findViewById(R.id.usdResult);
    }

    public void exchange(View view) {
        String dollars = edNtd.getText().toString();
        if(dollars.length() == 0){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount again.")
                    .setPositiveButton("OK", null)
                    .show();
            return;
        }

        float ntd = Float.parseFloat(dollars);
        float usd = ntd / 30.9f;
        Log.d("MainActivity", "USD is " + usd);
        Toast.makeText(this, "USD is " + usd, Toast.LENGTH_LONG).show();
        usdResult.setText(String.valueOf(usd));

        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("USD is " + usd)
                .setPositiveButton("OK", null)
                .show();
    }
}


