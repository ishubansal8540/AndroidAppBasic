package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.multiscreen.OrderActivity;
import com.example.multiscreen.R;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.codewithharry.multiscreen.ORDER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void PlaceOrder(View view){
        //to use button
        // we use intent to go to one activity to another
        Intent  intent = new Intent(this, OrderActivity.class);
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        String message = "Order for " + editText.getText().toString() + ", "
                + editText2.getText().toString() + " & "
                + editText3.getText().toString() + " has been successfully placed";
        intent.putExtra(MSG, message);
        startActivity(intent);

    }
}


