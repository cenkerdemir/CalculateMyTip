package com.example.cenkerdemir.calculatemytip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tipTextView;
    TextView totalTextView;
    EditText billTotalEditText;
    Button tenPercentButton;
    Button fifteenPercentButton;
    Button twentyPercentButton;

    double tipPercentage;
    double tipAmount;
    double billGrandTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        billTotalEditText = (EditText) findViewById(R.id.billTotalEditText);
        tenPercentButton = (Button) findViewById(R.id.tenPercentButton);
        fifteenPercentButton = (Button) findViewById(R.id.fifteenPercentButton);
        twentyPercentButton = (Button) findViewById(R.id.twentyPercentButton);

        tenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercentage = 0.1;
                CalculateTip();
                CalculateGrandTotal();
                UpdateTextViews();
            }
        });

        fifteenPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercentage = 0.15;
                CalculateTip();
                CalculateGrandTotal();
                UpdateTextViews();
            }
        });

        twentyPercentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercentage = 0.2;
                CalculateTip();
                CalculateGrandTotal();
                UpdateTextViews();
            }
        });
    }

    private void CalculateTip() {
        tipAmount = Double.valueOf(billTotalEditText.getText().toString()) * tipPercentage;
    }

    private void CalculateGrandTotal() {
        billGrandTotal = Double.valueOf(billTotalEditText.getText().toString()) + tipAmount;
    }

    private void UpdateTextViews() {
        tipTextView.setText("Tip - " + String.valueOf(tipAmount));
        totalTextView.setText("Total - " + String.valueOf(billGrandTotal));
    }
}
