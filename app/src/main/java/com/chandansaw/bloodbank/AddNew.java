package com.chandansaw.bloodbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNew extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        mFirebaseDatabase = FirebaseDatabase.getInstance().getReference("messages");
        FloatingActionButton save=  findViewById(R.id.save);
        final EditText name=  findViewById(R.id.name);
        final EditText phone=  findViewById(R.id.phone);
        final EditText city=  findViewById(R.id.city);
        final EditText desc=  findViewById(R.id.desc);
        final Spinner spinner=  findViewById(R.id.blood);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname=name.getText().toString();
                String sblood=spinner.getSelectedItem().toString();
                String  sphone=phone.getText().toString();
                String scity=city.getText().toString();
                String sdesc=desc.getText().toString();
                String id = mFirebaseDatabase.push().getKey();
                AddEntry artist = new AddEntry(sname,sphone,scity,sblood,sdesc,id);
                mFirebaseDatabase.child(id).setValue(artist);
                Intent home=new Intent(AddNew.this,MainActivity.class);
                startActivity(home);
                finish();
            }
        });
    }
}
