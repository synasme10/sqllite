package com.e.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DisplayAllActivity extends AppCompatActivity {

    EditText EtWord,EtMeaning;
    Button BtnUpdate, BtnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all);

        EtWord=findViewById(R.id.EtWord);
        EtMeaning=findViewById(R.id.EtMeaning);
        BtnUpdate=findViewById(R.id.BtnUpdate);
        BtnDelete=findViewById(R.id.BtnDelete);
    }
}
