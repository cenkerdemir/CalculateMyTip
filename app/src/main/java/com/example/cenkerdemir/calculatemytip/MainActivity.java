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
    EditText tipPercentageText;
    Button tipCalculateButton;

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
        tipPercentageText = (EditText) findViewById(R.id.tipPercentageText);
        tipCalculateButton = (Button) findViewById(R.id.tipCalculateButton);

        tipCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipPercentage = Double.valueOf(tipPercentageText.getText().toString()) / 100.0;
                ProcessTipAndTotal();
            }
        });
    }

    private void ProcessTipAndTotal(){
        CalculateTip();
        CalculateGrandTotal();
        UpdateTextViews();
    }

    private void CalculateTip() {
        tipAmount = Double.valueOf(billTotalEditText.getText().toString()) * tipPercentage;
    }

    private void CalculateGrandTotal() {
        billGrandTotal = Double.valueOf(billTotalEditText.getText().toString()) + tipAmount;
    }

    private void UpdateTextViews() {
        tipTextView.setText("Tip - $" + String.format("%.2f", tipAmount));
        totalTextView.setText("Total - $" + String.format("%.2f", billGrandTotal));
    }
}
