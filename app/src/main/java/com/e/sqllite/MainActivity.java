package com.e.sqllite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    EditText word,meaning;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       word=findViewById(R.id.word);
       meaning=findViewById(R.id.meaning);
       button=findViewById(R.id.btnadd);

        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id=myHelper.InsertData(word.getText().toString(),meaning.getText().toString(),sqLiteDatabase);

                if (id>0){
                    Toast.makeText(MainActivity.this, "Succesfull"+id, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
