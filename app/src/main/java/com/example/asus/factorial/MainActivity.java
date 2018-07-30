package com.example.asus.factorial;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {
   private EditText number;
   private TextView result;
   private final BigInteger MAX_VALUE = BigInteger.valueOf(49000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = findViewById(R.id.input);
        result = findViewById(R.id.Text);
    }

    public void Calculate_Factorial(View view) {
        String res = number.getText().toString();
        if (res.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }
        BigInteger fact= BigInteger.valueOf(parseInt(res));
        if (MAX_VALUE.compareTo(fact)<=0){
            Toast.makeText(this, "Please enter a smaller number", Toast.LENGTH_LONG).show();
            return;
        }
        BigInteger i;
        BigInteger t = BigInteger.valueOf(1);
        for (i= BigInteger.valueOf(1); i.compareTo(fact)<=0; i = i.add(BigInteger.valueOf(valueOf(1))))
        {
            t = t.multiply(i);
        }
        result.setText(String.valueOf(t));
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}