package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    Button  btnEncodeBase64, btnDecodeBase64;

    TextView tvOutput;
    EditText etInput;
    private EncryptionManager encryptionManager;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        btnEncodeBase64 = findViewById( R.id.btnEncodeBase64 );
        btnDecodeBase64 = findViewById( R.id.btnDecodeBase64 );

        tvOutput = findViewById( R.id.tvOutput );
        etInput = findViewById( R.id.etInput );

        encryptionManager = EncryptionManager.getInstance();


        btnEncodeBase64.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etInput.getText().toString();
                if (!TextUtils.isEmpty( data )) {
                    result = encryptionManager.encodeBase64( data );
                    tvOutput.setText( result );
                } else {
                    Toast.makeText( MainActivity.this, "Field is empty",
                            Toast.LENGTH_SHORT ).show();
                }
            }
        } );

        btnDecodeBase64.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty( result )) {
                    result = encryptionManager.decodeBase64( result );
                    tvOutput.setText( result );
                } else {
                    Toast.makeText( MainActivity.this, "No data to code",
                            Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }

    public void btnMD5(View v) {
        EditText etInput = (EditText) findViewById( R.id.etInput );
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] md5Input = etInput.getText().toString().getBytes();
        BigInteger md5Data = null;
        try {
            md5Data = new BigInteger( 1, md.encryptMD5( md5Input ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        String md5Str = md5Data.toString( 16 );
        if (md5Str.length() < 64) {
            md5Str = 0 + md5Str;
        }

        tvOutput.setText( md5Str );
    }

    public void btnSHA1(View v){
        EditText etInput = (EditText) findViewById( R.id.etInput);
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA( inputData, "SHA-1" );
        }catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger( 1, outputData );
        tvOutput.setText(shaData.toString(16));

    }
    public void btnSHA224(View v){
        EditText etInput = (EditText) findViewById( R.id.etInput);
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA( inputData, "SHA-224" );
        }catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger( 1, outputData );
        tvOutput.setText(shaData.toString(16));

    }

    public void btnSHA256(View v){
        EditText etInput = (EditText) findViewById( R.id.etInput);
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA( inputData, "SHA-256" );
        }catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger( 1, outputData );
        tvOutput.setText(shaData.toString(16));

    }

    public void btnSHA384(View v){
        EditText etInput = (EditText) findViewById( R.id.etInput);
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA( inputData, "SHA-384" );
        }catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger( 1, outputData );
        tvOutput.setText(shaData.toString(16));

    }
    public void btnSHA512(View v){
        EditText etInput = (EditText) findViewById( R.id.etInput);
        TextView tvOutput = (TextView) findViewById( R.id.tvOutput );

        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA( inputData, "SHA-512" );
        }catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger( 1, outputData );
        tvOutput.setText(shaData.toString(16));

    }

}


