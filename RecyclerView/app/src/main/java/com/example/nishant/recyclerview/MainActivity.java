package com.example.nishant.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner s1,s2;

    EditText name,number ;

    Button save ;
    String name1,number1,country1,state1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (Spinner)findViewById(R.id.s1);
        s2= (Spinner)findViewById(R.id.s2);
        save = (Button)findViewById(R.id.button);
        name = (EditText)findViewById(R.id.editText);
        number = (EditText)findViewById(R.id.editText2);

        List<String> list = new ArrayList<String>();
        list.add("Select Country");
        list.add("India");
        list.add("USA");
        list.add("Malaysia");
        list.add("Canada");
        list.add("Australia");

        ArrayAdapter<String> spinner = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list);

        spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s1.setAdapter(spinner);

        s1.setOnItemSelectedListener(this);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1=name.getText().toString();
                number1 = number.getText().toString();
                state1 = String.valueOf(s2.getSelectedItem());
                country1 = String.valueOf(s1.getSelectedItem());
                Intent i = new Intent(MainActivity.this,ViewActivity.class);
                i.putExtra("name2",name1);
                i.putExtra("number2",number1);
                i.putExtra("Country2",country1);
                i.putExtra("State2",state1);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       String selected = String.valueOf(s1.getSelectedItem());

       if(selected.contentEquals("India")){

           List<String> list = new ArrayList<String>();
           list.add("Select State");
           list.add("i1");
           list.add("i2");
           list.add("i3");
           list.add("i4");
           list.add("i5");

           ArrayAdapter<String> spinner2 = new ArrayAdapter<String>(this,
                   android.R.layout.simple_spinner_item,
                   list);

           spinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

           s2.setAdapter(spinner2);
       }

       else if(selected.contentEquals("USA")){

           List<String> list = new ArrayList<String>();
           list.add("Select State");
           list.add("u1");
           list.add("u2");
           list.add("u3");
           list.add("u4");
           list.add("u5");

           ArrayAdapter<String> spinner2 = new ArrayAdapter<String>(this,
                   android.R.layout.simple_spinner_item,
                   list);

           spinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

           s2.setAdapter(spinner2);

       }else{
           s2.setAdapter(null);
       }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
