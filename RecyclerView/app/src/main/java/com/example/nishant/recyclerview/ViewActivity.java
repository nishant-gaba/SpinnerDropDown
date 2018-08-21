package com.example.nishant.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView name2,number2,Country2,State2;

    Button b1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent i2 = getIntent();
        String name = getIntent().getExtras().getString("name2");
        String number = getIntent().getExtras().getString("number2");
        String Country = getIntent().getExtras().getString("Country2");
        String State = getIntent().getExtras().getString("State2");

        name2=(TextView)findViewById(R.id.name2);
        number2 =(TextView)findViewById(R.id.number2);
        Country2 = (TextView)findViewById(R.id.Country2);
        State2 =(TextView)findViewById(R.id.state2);

        b1=(Button)findViewById(R.id.button2);

        name2.setText(name);
        number2.setText(number);
        Country2.setText(Country);
        State2.setText(State);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(ViewActivity.this,MainActivity.class);
               startActivity(i);
            }
        });
    }
}
