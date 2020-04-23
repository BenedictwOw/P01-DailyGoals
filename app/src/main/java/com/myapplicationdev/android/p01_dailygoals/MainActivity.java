package com.myapplicationdev.android.p01_dailygoals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the button and setting theOnClickListener
        Button btnOk = (Button)findViewById(R.id.button1);
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                //Radio Group Info
                //Get the RadioGroup object
                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                //Getting id of the selected radio button in the RadioGroup
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                //Get the radio button object from the ID we had gotten above
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                RadioButton rb3 = (RadioButton)findViewById(selectedButtonId3);

                //Getting editText which user keys in name
                EditText etName = (EditText) findViewById(R.id.editText);
                //Put name and age into an array
                String[] info = {etName.getText().toString(),rb1.getText().toString(),rb2.getText().toString(),rb3.getText().toString()};
                //Create an intent to start another activity called DemoActivities
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                //Passing string array holding the name and age to new activity
                i.putExtra("info",info);
                //start the new activity
                startActivity(i);
            };

        });
    }
}
