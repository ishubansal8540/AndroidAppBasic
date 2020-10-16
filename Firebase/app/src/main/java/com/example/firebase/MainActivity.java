package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText txtname, txtage, txtphone, txtheight;
    Button btnsave;
  DatabaseReference reff;
  Member member;
  long maxid = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = (EditText)findViewById(R.id.txtname);
        txtage = (EditText)findViewById(R.id.txtage);
        txtheight = (EditText)findViewById(R.id.txtheight);
        txtphone = (EditText)findViewById(R.id.txtphone);

        btnsave = (Button)findViewById(R.id.btnsave);
        member =new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int agea = Integer.parseInt(txtage.getText().toString().trim());
                Float hit = Float.parseFloat((txtheight.getText().toString().trim()));
                Long phn = Long.parseLong(txtphone.getText().toString().trim());

                member.setName(txtname.getText().toString().trim());
                member.setAge(agea);
                member.setHt(hit);
                member.setPh(phn);

              //  reff.push().setValue(member); // for random naming

                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(MainActivity.this,"data insert successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}
