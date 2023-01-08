package com.cornez.autopurchase;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class PurchaseActivity extends Activity {
    Auto mAuto;

    String loanReport;
    String monthlyPayment;

    private EditText carPriceET;
    private EditText downPayET;
    private RadioGroup loanTermRG;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);

        carPriceET = (EditText) findViewById(R.id.editText1);
        downPayET = (EditText) findViewById(R.id.editText2);
        loanTermRG = (RadioGroup) findViewById(R.id.radioGroup1);
        mAuto = new Auto();
    }

    private void collectAutoInputData(){

        mAuto.setPrice((double)Integer.valueOf(carPriceET.getText().toString()));

        mAuto.setDownPayment((double)Integer.valueOf(downPayET.getText().toString()));

        Integer radioId = loanTermRG.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) findViewById(radioId);
        mAuto.setLoanTerm(term.getText().toString());
    }

    private void buildLoanReport(){
        Resources res = getResources();
        monthlyPayment = res.getString(R.string.report_line1)
                +String.format("%.02f",mAuto.monthlyPayment());

        loanReport = res.getString(R.string.report_line6)
                +String.format("%10.02f",mAuto.getPrice());
        loanReport += res.getString(R.string.report_line7)
                +String.format("%10.02f",mAuto.getDownPayment());
        loanReport += res.getString(R.string.report_line9)
                +String.format("%18.02f",mAuto.taxAmount());
        loanReport += res.getString(R.string.report_line10)
                +String.format("%18.02f",mAuto.totalCost());
        loanReport += res.getString(R.string.report_line11)
                +String.format("%12.02f",mAuto.borrowedAmount());
        loanReport += res.getString(R.string.report_line12)
                +String.format("%12.02f",mAuto.interestAmount());
        loanReport += "\n\n" +res.getString(R.string.report_line8)+
                " "+mAuto.getLoanTerm()+" years.";
        loanReport += "\n\n" + res.getString(R.string.report_line2);
        loanReport +=  res.getString(R.string.report_line3);
        loanReport +=  res.getString(R.string.report_line4);
        loanReport +=  res.getString(R.string.report_line5);

    }

    public void activateLoanSummary(View view){
        collectAutoInputData();
        buildLoanReport();

        Intent launchReport = new Intent(this, LoanSummaryActivity.class);
        launchReport.putExtra("LoanReport",loanReport);
        launchReport.putExtra("MonthlyPayment",monthlyPayment);

        startActivity(launchReport);
    }

}
