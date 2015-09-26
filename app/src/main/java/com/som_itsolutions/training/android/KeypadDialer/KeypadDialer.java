package com.som_itsolutions.training.android.KeypadDialer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;

public class KeypadDialer extends Activity implements OnClickListener, OnLongClickListener{
	
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	
	private Button buttonStar;
	private Button buttonHash;
	
	private Button buttonCall;
	private Button buttonClear;
	
	private EditText displayNumber;
	
	private Intent callIntent;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        button0 = (Button)findViewById(R.id.Button0);
        button1 = (Button)findViewById(R.id.Button01);
        button2 = (Button)findViewById(R.id.Button02);
        button3 = (Button)findViewById(R.id.Button03);
        button4 = (Button)findViewById(R.id.Button04);
        button5 = (Button)findViewById(R.id.Button05);
        button6 = (Button)findViewById(R.id.Button06);
        button7 = (Button)findViewById(R.id.Button07);
        button8 = (Button)findViewById(R.id.Button08);
        button9 = (Button)findViewById(R.id.Button09);
        
        
        buttonStar = (Button)findViewById(R.id.ButtonSTAR);
        buttonHash = (Button)findViewById(R.id.ButtonHash);
        
        buttonCall = (Button)findViewById(R.id.ButtonCall);
        buttonClear = (Button)findViewById(R.id.ButtonClear);
        
        displayNumber = (EditText)findViewById(R.id.EditText01);
        
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        
        buttonStar.setOnClickListener(this);
        buttonHash.setOnClickListener(this);
        
        buttonClear.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        
        buttonClear.setOnLongClickListener(this);
        
    }
    
    public void onClick(View v){
    
    	if(v == button0)
    		displayNumber.append("0");
    	if(v == button1)
    		displayNumber.append("1");
    	if(v == button2)
    		displayNumber.append("2");
    	if(v == button3)
    		displayNumber.append("3");
    	if(v == button4)
    		displayNumber.append("4");
    	if(v == button5)
    		displayNumber.append("5");
    	if(v == button6)
    		displayNumber.append("6");
    	if(v == button7)
    		displayNumber.append("7");
    	if(v == button8)
    		displayNumber.append("8");
    	if(v == button9)
    		displayNumber.append("9");
    	
    	if(v == buttonClear){
    		int length = displayNumber.getText().length();
    		if(length != 0){
    		displayNumber.getText().replace(length-1,length,"");
    		}
    	}
    	
    	if ((Button)v == buttonCall ){
    		String number = displayNumber.getText().toString();
    			Uri	uri = Uri.parse("tel:" + number);
    			callIntent = new Intent("android.intent.action.CALL",uri);
    		try{
    			startActivity(callIntent);
    		}
    		catch(ActivityNotFoundException e){	
    		}
    	}
    }
    
    public boolean onLongClick(View v){
    	
    	if(v == buttonClear)
    		if(displayNumber.getText().length()!=0){
    			displayNumber.getText().clear();
    		}
    		return true;
    }
}
