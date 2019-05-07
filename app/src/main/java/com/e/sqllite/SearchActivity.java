package com.e.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.Word;

public class SearchActivity extends AppCompatActivity {
private EditText etWord;
private Button BtnSearch;
private ListView lstOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        etWord=findViewById(R.id.etWord);
        BtnSearch=findViewById(R.id.BtnSearch);
        lstOutput=findViewById(R.id.lstOutput);

        BtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    myHelper.Search(etWord.getText().toString(),db);
                Load();
            }
        });



    }

    public void Load(){
        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        List<Word> wordList=new ArrayList<>();
        wordList=myHelper.Search(etWord.getText().toString(),sqLiteDatabase);

        HashMap<String,String> hashMap=new HashMap<>();

        for(int i=0;i<wordList.size();i++){
            hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
        }

        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        lstOutput.setAdapter(stringArrayAdapter);
    }

}
