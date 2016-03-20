package com.asis.gl.week5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lst;
    private ArrayList<String> aList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (ListView)findViewById(R.id.mylist);

        //set listener
        lst.setOnItemClickListener(this);

        //first step : Adding items
        aList = new ArrayList<>();
        aList.add("Pikachu");
        aList.add("Charizard");
        aList.add("Mewtwo");
        aList.add("GigglyPuff");

        //2nd step : initializng adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_layout,
                R.id.txt,
                aList
        );

        //the last step: set the adapter to listview
        lst.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
        //Select item
        String selectedItem = lst.getItemAtPosition(index).toString();
        Toast.makeText(this, "You choosed " + selectedItem, Toast.LENGTH_LONG).show();
    }
}
