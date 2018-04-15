package com.chandansaw.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewEntries extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_entries);
        t1=  findViewById(R.id.blood);
        t2=  findViewById(R.id.name);
        t3=findViewById(R.id.phone);
        t4=  findViewById(R.id.city);
        t5=  findViewById(R.id.desc);
        Intent i=this.getIntent();
        final String na=i.getExtras().getString("NAME");
        final String ph=i.getExtras().getString("PHONE");
        final String cit=i.getExtras().getString("CITY");
        final String bl=i.getExtras().getString("BLOOD");
        final String de=i.getExtras().getString("DESC");
        t1.setText(bl);
        t2.setText(na);
        t3.setText(ph);
        t4.setText(cit);
        t5.setText(de);

    }
}
