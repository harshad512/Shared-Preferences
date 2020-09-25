package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_id;
    Button save,retrive;

    SharedPreferences sharedPreferences;
    public static final String Filename = "ID_File";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id = (EditText)findViewById(R.id.edit_id);
        save = (Button)findViewById(R.id.button_save);
        retrive = (Button)findViewById(R.id.button_retrive);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences = getSharedPreferences(Filename, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                String s = edit_id.getText().toString();
                editor.putString(Filename,s);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Save successfully", Toast.LENGTH_LONG).show();

            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit_id.setText(sharedPreferences.getString(Filename,""));

            }
        });
    }
}