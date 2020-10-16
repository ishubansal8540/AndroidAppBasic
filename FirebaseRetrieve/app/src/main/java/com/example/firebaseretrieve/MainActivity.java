package com.example.firebaseretrieve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    TextView a,b,c,d;
    Button btn;

    DatabaseReference reff;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=(TextView)findViewById(R.id.nameview);
        b=(TextView)findViewById(R.id.ageview);
        c=(TextView)findViewById(R.id.htview);
        d=(TextView)findViewById(R.id.phview);
        btn=(Button)findViewById(R.id.btnload);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Member").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String name = snapshot.child("name").getValue().toString();
                        String age = snapshot.child("age").getValue().toString();
                        String ht = snapshot.child("ht").getValue().toString();
                        String ph = snapshot.child("ph").getValue().toString();

                        a.setText(name);
                        b.setText(age);
                        c.setText(ht);
                        d.setText(ph);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}
